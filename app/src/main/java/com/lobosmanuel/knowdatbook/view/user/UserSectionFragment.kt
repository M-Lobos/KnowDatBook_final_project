package com.lobosmanuel.knowdatbook.view.user

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lobosmanuel.knowdatbook.databinding.FragmentUserSectionBinding
import com.lobosmanuel.knowdatbook.view.book.BookViewModel

class UserSectionFragment : Fragment() {

    private var _binding: FragmentUserSectionBinding? = null
    private val binding get() = _binding!!

    // Compartimos el mismo ViewModel
    private val viewModel: BookViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserSectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar el Adapter con las lambdas para borrar y calificar

        val adapter = UserSectionAdapter(
            onDeleteClick = { book -> viewModel.deleteFavorite(book) },
            onRatingChanged = { book, newRating ->
                // 1. Creamos una copia del libro con el nuevo puntaje
                // 2. Cambia isRead a 'true' automáticamente
                val updatedBook = book.copy(
                    rating = newRating,
                    isRead = true
                )

                // 3. Actualizamos en Room
                viewModel.insertFavorite(updatedBook)

                // Opcional: Toast informativo
                // Toast.makeText(requireContext(), "¡Libro marcado como leído!", Toast.LENGTH_SHORT).show()

                }
        )

        binding.btnSugerirLibro.setOnClickListener {
            println("DEBUG: Click en el botón detectado")
            Toast.makeText(requireContext(), "Abriendo correo...", Toast.LENGTH_SHORT).show()

            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("m.lobos.dev@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Sugerencia: KnowDatBook")
                putExtra(Intent.EXTRA_TEXT, "Hola Manuel, mi sugerencia es: ")
            }

            try {
                startActivity(Intent.createChooser(intent, "Selecciona una App"))
            } catch (e: Exception) {
                println("DEBUG: Error al lanzar intent: ${e.message}")
            }
        }r

        binding.rvUserSectionFragment.layoutManager = LinearLayoutManager(requireContext())
        binding.rvUserSectionFragment.adapter = adapter

        // OBSERVAR LA DB: Aquí ocurre la magia
        viewModel.allFavorites.observe(viewLifecycleOwner) { listaDeLibros ->
            adapter.setBooks(listaDeLibros)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}