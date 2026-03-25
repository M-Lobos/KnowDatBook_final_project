package com.lobosmanuel.knowdatbook.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lobosmanuel.knowdatbook.model.local.BookDao
import com.lobosmanuel.knowdatbook.model.local.BookEntity
import com.lobosmanuel.knowdatbook.model.remote.BookRemote
import com.lobosmanuel.knowdatbook.model.remote.OpenLibraryResponse
import com.lobosmanuel.knowdatbook.model.remote.RetrofitClient
import retrofit2.Response

class BookRepository(private val bookDao: BookDao) {

    // Instancia del cliente de Retrofit para obtener el servicio
    private val apiService = RetrofitClient().getApiService()

    // LiveData para que el ViewModel observe el resultado de la API
    val bookFromInternet = MutableLiveData<BookRemote?>()

    // Lógica para traer datos de OpenLibrary (Corrutinas)
    suspend fun fetchBookFromInternet(query: String) {
        try {
            val response: Response<OpenLibraryResponse> = apiService.searchBooks(query)

            if (response.isSuccessful) {
                val books = response.body()?.books
                // Elegimos un libro al azar de los resultados para la "sugerencia"
                val selectedBook = books?.randomOrNull()
                bookFromInternet.postValue(selectedBook)

                Log.d("REPO", "¡Éxito! Se encontraron ${books?.size ?: 0} libros")
            } else {
                Log.e("REPO", "Error en la API: ${response.code()} - ${response.errorBody()}")
            }
        } catch (t: Throwable) {
            Log.e("REPO", "Fallo de red o conversión: ${t.message}")
        }
    }

    // --- MÉTODOS DE ROOM (LOCAL) ---

    // Observar todos los favoritos guardados
    val allFavorites: LiveData<List<BookEntity>> = bookDao.getAllFavorites()

    // Guardar en la base de datos local
    suspend fun insertFavorite(book: BookEntity) {
        bookDao.insertFavorite(book)
    }

    // Eliminar de la base de datos local (boton que no existe en el PMV, pero debería ir en la V.2)
    suspend fun deleteFavorite(book: BookEntity) {
        bookDao.deleteFavorite(book)
    }
}