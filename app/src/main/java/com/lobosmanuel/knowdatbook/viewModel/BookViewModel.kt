package com.lobosmanuel.knowdatbook.view.book

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.lobosmanuel.knowdatbook.model.BookRepository
import com.lobosmanuel.knowdatbook.model.local.BookDatabase
import com.lobosmanuel.knowdatbook.model.local.BookEntity
import com.lobosmanuel.knowdatbook.model.remote.BookRemote
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application) {

    // 1) REPOSITORIO: Manejo de datos (Room + API)
    private val repository: BookRepository

    // 2) LIVEDATA:
    // Datos obtenidos desde internet (sugerencia libro)
    val bookFromInternet: LiveData<BookRemote?>

    // Datos almacenados en la DB local (mover libro a biblioteca)
    val allFavorites: LiveData<List<BookEntity>>

    init {
        // Obtener el DAO desde la Database de Room
        val bookDao = BookDatabase.getDatabase(application).getBookDao()

        repository = BookRepository(bookDao)

        // Asignamos los LiveData desde el repositorio
        bookFromInternet = repository.bookFromInternet
        allFavorites = repository.allFavorites
    }

    // Función para buscar en la API (se activa al pulsar el botón en el Fragment)
    fun searchBook(genre: String, author: String?, year: String?) {
        // query (limpiando espacios por guiones bajos para la API)
        var query = "subject:${genre.lowercase().replace(" ", "_")}"

        //filtros
        if (!author.isNullOrBlank()) {
            query += " author:$author"
        }

        if (!year.isNullOrBlank()) {
            query += " first_publish_year:$year"
        }

        // corrutina para que el repo se active
        viewModelScope.launch {
            repository.fetchBookFromInternet(query)
        }
    }

    // Funciones para Favoritos (CRUD local)
    fun insertFavorite(book: BookEntity) = viewModelScope.launch {
        repository.insertFavorite(book)
    }

    fun deleteFavorite(book: BookEntity) = viewModelScope.launch {
        repository.deleteFavorite(book)
    }
}