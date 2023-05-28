package devklazz.ms.entities

data class Movie (
    val id: Long,
    val title: String,
    val writer: String,
    val cast: List<String>,
    val releaseYear: Int,
    val rating: Float
)