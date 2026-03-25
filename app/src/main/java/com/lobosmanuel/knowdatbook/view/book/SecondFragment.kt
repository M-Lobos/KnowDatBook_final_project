package com.lobosmanuel.knowdatbook.view.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.lobosmanuel.knowdatbook.R
import com.lobosmanuel.knowdatbook.databinding.FragmentSecondBinding

/**
 * A simple [androidx.fragment.app.Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BookViewModel by viewModels()
    private var selectedGenre: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Recuperamos el género correctamente
        selectedGenre = arguments?.getString("genre_key")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Configurar funcion auxiliar de búsquedas

        // Función auxiliar para disparar la búsqueda
        fun ejecutarBusqueda() {
            val author = binding.etAutor.text.toString().trim()
            val yearRange = when (binding.rgAnio.checkedRadioButtonId) {
                R.id.rb1800 -> "[1800 TO 1899]"
                R.id.rb1900 -> "[1900 TO 1999]"
                R.id.rb2000 -> "[2000 TO 2026]"
                else -> null
            }
            selectedGenre?.let { genre ->
                viewModel.searchBook(genre, author, yearRange)
            } ?: Toast.makeText(requireContext(), "Error: No hay género", Toast.LENGTH_SHORT).show()
        }

        // Botón principal
        binding.btnDescubrir.setOnClickListener {
            ejecutarBusqueda()
        }

        // Botón de "Sugerir otro"
        binding.btnRecomendarOtro.setOnClickListener {
            ejecutarBusqueda()
        }


        // 2. Observar los resultados de la API
        viewModel.bookFromInternet.observe(viewLifecycleOwner) { book ->
            if (book != null) {
                //Pinta la tarjeta
                binding.cardResultado.visibility = View.VISIBLE

                binding.txtTituloLibro.text = book.title
                binding.txtAutorLibro.text = book.authorNames?.joinToString(", ") ?: "Autor desconocido"
                //año del textinfo
                binding.txtInfoLibro.text = "Año: ${book.year ?: "--"} | Key: ${book.key.takeLast(5)}"

                book.coverId?.let { id ->
                    val url = "https://covers.openlibrary.org/b/id/$id-L.jpg"
                    Glide.with(this)
                        .load(url)
                        .placeholder(android.R.drawable.ic_menu_report_image) // Imagen mientras carga
                        .error(android.R.drawable.ic_menu_gallery) // Imagen si falla
                        .into(binding.imgPortada)
                }
            } else {
                binding.cardResultado.visibility = View.GONE
                // Esto se disparará si la lista de la API llegó vacía
                Toast.makeText(requireContext(), "No hay resultados para esta búsqueda", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}