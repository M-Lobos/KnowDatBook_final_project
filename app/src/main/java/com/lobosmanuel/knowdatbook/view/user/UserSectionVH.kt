// UserSectionVH.kt
package com.lobosmanuel.knowdatbook.view.user

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lobosmanuel.knowdatbook.databinding.BookItemBinding // O ItemBookBinding según tu XML
import com.lobosmanuel.knowdatbook.model.local.BookEntity

class UserSectionVH(
    private val binding: BookItemBinding,
    private val onDeleteClick: (BookEntity) -> Unit,
    private val onRatingChanged: (BookEntity, Float) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(book: BookEntity) {
        binding.txtBookTitle.text = book.title
        binding.txtBookAuthor.text = book.authorName ?: "Autor desconocido"
        binding.rbStars.rating = book.rating

        // Estado del chip
        binding.chipStatus.text = if (book.isRead) "Leído" else "No leído"

        // Carga de imagen con la URL de OpenLibrary
        val url = "https://covers.openlibrary.org/b/id/${book.coverId}-L.jpg"
        Glide.with(binding.root.context)
            .load(url)
            .placeholder(android.R.drawable.ic_menu_report_image)
            .into(binding.imgBookThumb)

        // Configurar clics
        binding.btnDelete.setOnClickListener {
            onDeleteClick(book)
        }

        binding.rbStars.setOnRatingBarChangeListener { _, rating, fromUser ->
            if (fromUser) {
                onRatingChanged(book, rating)
            }
        }
    }
}