package com.lobosmanuel.knowdatbook.model.local

import androidx.lifecycle.LiveData
import androidx.room.*

//interfaz que define las operaciones de la base de datos.
@Dao
interface BookDao {

    // Insertar un libro (si ya existe, lo reemplaza)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(book: BookEntity)

    // Obtener todos los libros guardados como favoritos
    @Query("SELECT * FROM fav_books_table ORDER BY title ASC")
    fun getAllFavorites(): LiveData<List<BookEntity>>

    // Eliminar un libro específico
    @Delete
    suspend fun deleteFavorite(book: BookEntity)

    // Limpiar toda la tabla (útil para pruebas)
    @Query("DELETE FROM fav_books_table")
    suspend fun deleteAll()
}
