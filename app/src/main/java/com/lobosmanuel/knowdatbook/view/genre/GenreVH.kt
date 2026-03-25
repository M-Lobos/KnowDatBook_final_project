package com.lobosmanuel.knowdatbook.view.genre

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lobosmanuel.knowdatbook.databinding.GenreItemBinding
import com.lobosmanuel.knowdatbook.model.local.Genre


/*Un viewHolder es una suerte de director de orquesta que le dice a cada sección qué
tocar, en este caso el VH toma un objeto de datos y le dice a cada elmento
del XML qué mostrar exactamente.
*/

// 1. Hereda de RecyclerView.ViewHolder -> Sistema gestiona la memoria de la vista
class GenreVH(view: View) : RecyclerView.ViewHolder(view) {

    // 2. Vincula el layout 'genre_item.xml' mediante ViewBinding
    private val binding = GenreItemBinding.bind(view)

    /**
     * 3. Función 'render': El corazón del ViewHolder.
     * @param genre: El objeto de detos con la información (Terror, Fantasía, etc.)
     * @param onClickListener: La acción al tocar la tarjeta
     */
    fun render(genre: Genre, onClickListener: (Genre) -> Unit) {

        // Setea el texto en el TextView genre_item.xml
        binding.txtGenreName.text = genre.name

        // Setea el ícono en ImageView del genre_item.xml
        // usa el ID del recurso (drawable)
        binding.imgGenreIcon.setImageResource(genre.iconRes)

        // 4. Se setea el click en toda la celda (itemView)
        itemView.setOnClickListener {
            onClickListener(genre)
        }
    }
}