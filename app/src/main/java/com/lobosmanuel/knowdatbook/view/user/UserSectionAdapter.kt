package com.lobosmanuel.knowdatbook.view.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lobosmanuel.knowdatbook.databinding.BookItemBinding
import com.lobosmanuel.knowdatbook.model.local.BookEntity

class UserSectionAdapter(
    private val onDeleteClick: (BookEntity) -> Unit,
    private val onRatingChanged: (BookEntity, Float) -> Unit
) : RecyclerView.Adapter<UserSectionVH>() {

    private var books = emptyList<BookEntity>()

    // Función para actualizar la lista cuando Room nos mande datos nuevos
    fun setBooks(newBooks: List<BookEntity>) {
        this.books = newBooks
        notifyDataSetChanged() // Refresca el RecyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserSectionVH {
        // Inflamos el XML usando el Binding
        val binding = BookItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        // Retornamos el ViewHolder EXTERNO pasando las lambdas de clics
        return UserSectionVH(binding, onDeleteClick, onRatingChanged)
    }

    override fun onBindViewHolder(holder: UserSectionVH, position: Int) {
        // Le pedimos al VH que "asocie" los datos del libro en esta posición
        holder.bind(books[position])
    }

    override fun getItemCount(): Int = books.size
}