package com.lobosmanuel.knowdatbook.view.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.lobosmanuel.knowdatbook.databinding.FragmentUserSectionBinding
import com.lobosmanuel.knowdatbook.model.local.Genre
import com.lobosmanuel.knowdatbook.view.genre.GenreAdapter

class UserSectionFragment : Fragment() {

    private var _binding: FragmentUserSectionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserSectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Configurar el LayoutManager (Lista vertical)
        binding.rvUserSectionFragment.layoutManager = LinearLayoutManager(context)

        // 2. Crear datos de prueba (Mock data)
//        val librosFavoritos = listOf(
//            Book("El Aleph", "Jorge Luis Borges"),
//            Book("Demian", "Hermann Hesse"),
//            Book("La tregua", "Mario Benedetti")
//        )



        // 3. Asignar el adaptador
        // (Asumiendo que reusarás el GenreAdapter o crearás uno similar para libros)
//        val adapter = GenreAdapter(librosFavoritos)
//        binding.rvUserSectionFragment.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}