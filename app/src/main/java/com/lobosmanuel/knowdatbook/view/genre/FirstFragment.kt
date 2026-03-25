package com.lobosmanuel.knowdatbook.view.genre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.lobosmanuel.knowdatbook.R
import com.lobosmanuel.knowdatbook.databinding.FragmentFirstBinding
import com.lobosmanuel.knowdatbook.model.local.Genre

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Preparamos la data (Esto vendrá de un repositorio después, pero para el MVP es perfecto así)
        val genreList = listOf(
            Genre(1, "Terror", R.drawable.ic_launcher_foreground),
            Genre(2, "Fantasía", R.drawable.ic_launcher_foreground),
            Genre(3, "Ciencia Ficción", R.drawable.ic_launcher_foreground),
            Genre(4, "Drama", R.drawable.ic_launcher_foreground),
            Genre(5, "Suspenso", R.drawable.ic_launcher_foreground),
            Genre(6, "Historia", R.drawable.ic_launcher_foreground)
        )

        // 2. Creamos el Adapter y le pasamos la lambda de navegación
        val adapter = GenreAdapter(genreList) { selectedGenre ->
            // Creamos un Bundle para pasar el nombre del género al siguiente fragmento
            val bundle = bundleOf("genreName" to selectedGenre.name)

            // Navegamos usando el ID de la acción definida en tu nav_graph.xml
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
        }

        // 3. Configuramos el RecyclerView que está en fragment_first.xml
        binding.rvGenres.apply {
            layoutManager = GridLayoutManager(context, 2) // 2 columnas como en tu dibujo
            this.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}