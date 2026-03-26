package com.lobosmanuel.knowdatbook

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.lobosmanuel.knowdatbook.view.MainActivity
import org.junit.Rule
import org.junit.Test



class NavigationTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun al_abrir_la_app_se_deben_ver_los_generos() {
        // Verifica que el RecyclerView de géneros esté visible
        // Asegúrate de que el ID sea el correcto (rvGenres o como lo llamaras)
        onView(withId(R.id.rvGenres)).check(matches(isDisplayed()))
    }
}