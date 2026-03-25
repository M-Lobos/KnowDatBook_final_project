package com.lobosmanuel.knowdatbook.view.genre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.lobosmanuel.knowdatbook.R
import com.lobosmanuel.knowdatbook.databinding.FragmentFirstBinding
import com.lobosmanuel.knowdatbook.model.GenreProvider
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

        // El Provider entrega la lista de objetos Genre
        val list = GenreProvider.getGenres()

        // El Adapter recibe esa lista y la función de clic
        val adapter = GenreAdapter(list) { genre ->
            // 1. Creamos el "sobre" (Bundle)
            val bundle = Bundle().apply {
                putString("genre_key", genre.name) // Guardamos el nombre del género
            }

            // 2. Navegamos usando el ID del destino y pasamos el bundle
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
        }

        binding.rvGenres.adapter = adapter
        binding.rvGenres.layoutManager = GridLayoutManager(context, 2) // O LinearLayoutManager
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}