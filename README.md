# 📚 KnowDatBook

**KnowDatBook** es una aplicación Android nativa diseñada para los amantes de la lectura que buscan descubrir nuevas obras de manera inteligente. Utilizando la API de OpenLibrary, permite explorar miles de títulos filtrados por género, autor y época, gestionando una biblioteca personal con persistencia de datos local.

![Android](https://img.shields.io/badge/Platform-Android-brightgreen.svg) 
![Kotlin](https://img.shields.io/badge/Language-Kotlin-blue.svg)
![Architecture](https://img.shields.io/badge/Architecture-MVVM-orange.svg)

---

## 🚀 Características (MVP)

- **Exploración por Géneros:** 14 categorías predefinidas con más de 1400 sugerencias dinámicas.
- **Filtros Avanzados:** Búsqueda combinada por autor y rangos temporales (Siglos XIX, XX y XXI).
- **Biblioteca Personal:** Guardado de libros favoritos utilizando **Room Database**.
- **Gestión de Lectura:** Sistema de calificación por estrellas y marcado de estado "Leído/No leído".
- **Diseño Adaptativo:** Interfaz optimizada con **Material Design 3**, modo oscuro y componentes visuales personalizados.

## 🛠️ Stack Tecnológico

- **Lenguaje:** Kotlin + Coroutines para operaciones asíncronas.
- **Arquitectura:** MVVM (Model-View-ViewModel) para una separación de responsabilidades limpia.
- **Networking:** Retrofit 2 + Gson para el consumo de la API de OpenLibrary.
- **Persistencia:** Room Database para el almacenamiento local de favoritos.
- **UI Components:** Navigation Component, ViewBinding, Glide (carga de imágenes), Font Awesome.
- **Testing:** JUnit 4 (Unit tests) y Espresso (Instrumented tests).

---

## 🏗️ Arquitectura y Patrones

El proyecto sigue los principios de **Clean Architecture** a nivel de datos:
- **Remote Data Source:** Gestión de llamadas a la API con manejo de latencia.
- **Local Data Source:** Caché local y favoritos con Room.
- **Repository Pattern:** Punto único de verdad para el acceso a datos.

## 🧪 Plan de Testing

Se implementaron pruebas automatizadas para garantizar la estabilidad del núcleo:
- **Unit Tests:** Validación de lógica de negocio (formateo de queries y filtros).
- **Instrumented Tests:** - Pruebas de persistencia en Room (Insert/Query/Delete).
    - Validación de flujo de navegación y visibilidad de componentes UI.

---

## 📈 Próximas Mejoras (Roadmap)
- [ ] Implementación de búsqueda global por texto libre.
- [ ] Integración con Google Books API como respaldo (High Availability).
- [ ] Sistema de "Archivado" de libros para gestión de memoria en el RecyclerView.
- [ ] Soporte para sinopsis detalladas mediante consultas secundarias.

---

## 👤 Autor
**Manuel Lobos** *Junior Fullstack Web Developer | Estudiante de Desarrollo Android*

---
> *Este proyecto fue desarrollado como parte de la Evaluación Final del Módulo 7 - Talento Digital Sence.*
