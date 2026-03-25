package com.lobosmanuel.knowdatbook.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lobosmanuel.knowdatbook.model.local.BookDao
import com.lobosmanuel.knowdatbook.model.local.BookEntity
import com.lobosmanuel.knowdatbook.model.remote.BookRemote
import com.lobosmanuel.knowdatbook.model.remote.RetrofitClient

class BookRepository(private val bookDao: BookDao) {

    private val apiService = RetrofitClient().getApiService()

    // LiveData para observar el libro que encontremos en internet
    val bookFromInternet = MutableLiveData<BookRemote?>()

    suspend fun fetchBookFromInternet(query: String) {
        try {
            val response = apiService.searchBooks(query)
            if (response.isSuccessful) {
                val books = response.body()?.books
                // Elegimos uno al azar y lo publicamos
                val selectedBook = books?.randomOrNull()
                bookFromInternet.postValue(selectedBook)
            } else {
                Log.e("REPO", "Error: ${response.code()}")
            }
        } catch (t: Throwable) {
            Log.e("REPO", "Fallo de red: ${t.message}")
        }
    }

    // --- TERRENO ALLANADO PARA ROOM ---

    // Obtener todos los favoritos guardados
    val allFavorites: LiveData<List<BookEntity>> = bookDao.getAllFavorites()

    // Guardar un libro en favoritos
    suspend fun insertFavorite(book: BookEntity) {
        bookDao.insertFavorite(book)
    }

    // Borrar de favoritos
    suspend fun deleteFavorite(book: BookEntity) {
        bookDao.deleteFavorite(book)
    }
}