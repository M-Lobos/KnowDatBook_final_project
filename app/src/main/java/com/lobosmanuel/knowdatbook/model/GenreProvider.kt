package com.lobosmanuel.knowdatbook.model


import com.lobosmanuel.knowdatbook.R
import com.lobosmanuel.knowdatbook.model.local.Genre

object GenreProvider {
    fun getGenres(): List<Genre> {
        return listOf(
            Genre(1, "Fantasía", R.drawable.ic_fantasy_fa),
            Genre(2, "Ficción histórica", R.drawable.ic_history_ficc_fa),
            Genre(3, "Terror", R.drawable.ic_horror_fa),
            Genre(4, "Humor", R.drawable.ic_humor_fa),
            Genre(5, "Literatura", R.drawable.ic_lit_fa),
            Genre(6, "Magia", R.drawable.ic_magic_fa),
            Genre(7, "Misterio e historias de detectives", R.drawable.ic_mistery_fa),
            Genre(8, "Obras de teatro", R.drawable.ic_masks_fa),
            Genre(9, "Poesía", R.drawable.ic_poetry_fa),
            Genre(10, "Romántica", R.drawable.ic_romantic),
            Genre(11, "Ciencia ficción", R.drawable.ic_scifi_fa),
            Genre(12, "Historias cortas", R.drawable.ic_short_stories_fa),
            Genre(13, "Suspense" , R.drawable.ic_suspence_fa),
            Genre(14, "Juvenil", R.drawable.ic_juvenile_fa)
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