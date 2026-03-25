package com.lobosmanuel.knowdatbook.view.genre

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lobosmanuel.knowdatbook.R
import com.lobosmanuel.knowdatbook.model.local.Genre

/*El Adapter crea los ViewHolders necesarios y les pasa los datos
de la  lista de géneros. */

class GenreAdapter(
    private val genreList: List<Genre>,
    private val onClickListener: (Genre) -> Unit
) : RecyclerView.Adapter<GenreVH>() {

    // 1. Crear el contenedor (ViewHolder)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GenreVH(layoutInflater.inflate(R.layout.genre_item, parent, false))
    }

    // 2. Decirle al Adapter cuántos elementos debe mostrar
    override fun getItemCount(): Int = genreList.size

    // 3. Conectar la data con el contenedor (Paso de información)
    override fun onBindViewHolder(holder: GenreVH, position: Int) {
        val item = genreList[position]
        holder.render(item, onClickListener)
    }
}