package devklazz.ms.service

import devklazz.ms.entities.Movie

class MovieService {

    private val repository = MoviesRepository()

    fun addMovie(movie: Movie) {
        repository.addMovie(movie)
    }

    fun deleteMovie(movie: Movie)  {
        repository.deleteMovie(movie)
    }

    fun findById(id: Long) : Movie? {
        return repository.find(id)
    }

    fun updateMovie(movie: Movie) {
        return repository.updateMovie(movie)
    }


}