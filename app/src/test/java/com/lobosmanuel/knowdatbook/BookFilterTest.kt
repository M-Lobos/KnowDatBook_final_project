package com.lobosmanuel.knowdatbook

import org.junit.Assert.assertEquals
import org.junit.Test

// Se testea que la lógica de transformación de strings (pasar de 1900-1999 al
// formato que entiende OpenLibrary [1900 TO 1999]) es correcta.

class BookFilterTest {

    @Test
    fun `cuando el usuario elige 1900-1999 la query debe ser correcta`() {

        val yearRange = "1900-1999"
        val expectedQuery = "first_publish_year:[1900 TO 1999]"


        val result = "first_publish_year:[${yearRange.replace("-", " TO ")}]"

        assertEquals(expectedQuery, result)
    }
}