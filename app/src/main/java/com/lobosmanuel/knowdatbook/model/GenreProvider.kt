package com.lobosmanuel.knowdatbook.model

import com.lobosmanuel.knowdatbook.model.local.Genre

object GenreProvider {
    fun getGenres(): List<Genre> {
        return listOf(
            Genre(1, "Fantasía",android.R.drawable.ic_menu_gallery),
            Genre(2, "Ficción histórica",android.R.drawable.ic_menu_gallery),
            Genre(3, "Terror",android.R.drawable.ic_menu_gallery),
            Genre(4, "Humor",android.R.drawable.ic_menu_gallery),
            Genre(5, "Literatura",android.R.drawable.ic_menu_gallery),
            Genre(6, "Magia",android.R.drawable.ic_menu_gallery),
            Genre(7, "Misterio e historias de detectives",android.R.drawable.ic_menu_gallery),
            Genre(8, "Obras de teatro",android.R.drawable.ic_menu_gallery),
            Genre(9, "Poesía",android.R.drawable.ic_menu_gallery),
            Genre(10, "Romántica", android.R.drawable.ic_menu_gallery),
            Genre(11, "Ciencia ficción",android.R.drawable.ic_menu_gallery),
            Genre(12, "Historias cortas",android.R.drawable.ic_menu_gallery),
            Genre(13, "Suspense" ,android.R.drawable.ic_menu_gallery),
            Genre(14, "Juvenil",android.R.drawable.ic_menu_gallery)
        )
    }
}




//override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//    super.onViewCreated(view, savedInstanceState)
//
//    // El fragment no sabe cuáles son los géneros, solo los pide
//    val genres = GenreProvider.getGenres()
//
//    val adapter = GenreAdapter(genres) { selectedGenre ->
//        // Aquí programas la navegación al SecondFragment pasando el nombre
//        val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(selectedGenre.name)
//        findNavController().navigate(action)
//    }
//
//    binding.rvGenres.adapter = adapter
//}