package com.lobosmanuel.knowdatbook

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.lobosmanuel.knowdatbook.model.local.BookDao
import com.lobosmanuel.knowdatbook.model.local.BookDatabase
import com.lobosmanuel.knowdatbook.model.local.BookEntity
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RoomDatabaseTest {
    private lateinit var db: BookDatabase
    private lateinit var dao: BookDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        // Creamos una base de datos en memoria (se borra al terminar el test)
        db = Room.inMemoryDatabaseBuilder(context, BookDatabase::class.java).build()
        dao = db.getBookDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertar_y_leer_libro_favorito() = runBlocking {
        // Usamos parámetros nombrados para que no haya error de orden o falta de datos
        val book = BookEntity(
            id = "123",
            title = "El Aleph",
            authorName = "Borges",
            isRead = false,    // Agregué estos porque los pusimos ayer
            rating = 0.0f,     // Agregué estos porque los pusimos ayer
            coverId = 0     // O el campo que tengas para la carátula
        )

        dao.insertFavorite(book)

        // El "Once" es para que no se quede pegado esperando un Flow/LiveData infinito
        val result = dao.getAllFavoritesSync() // Ahora 'result' SÍ es una List
        assertEquals(1, result.size)
        assertEquals("El Aleph", result[0].title)
    }
}