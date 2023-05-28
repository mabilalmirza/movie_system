package devklazz.ms.service

import devklazz.ms.db.getConnection
import devklazz.ms.entities.Movie

class MoviesRepository {

    fun addMovie(movie: Movie) {

        val sql = """
            insert into movies 
            (title, writer, cast, release_year, rating) 
            values (?, ?, ?, ?, ?)
        """.trimIndent()


        getConnection().use { connection ->
            connection.prepareStatement(sql).use { statement ->

                statement.setString(1, movie.title)
                statement.setString(2, movie.writer)
                statement.setString(3, movie.cast.joinToString(","))
                statement.setInt(4, movie.releaseYear)
                statement.setFloat(5, movie.rating)

                statement.execute()
            }
        }
    }

    fun updateMovie(movie: Movie) {

        val sql = """
            update movies
            set title = ?, writer = ?, cast = ? , release_year = ?, rating = ?
            where id = ?
        """.trimIndent()


        getConnection().use { connection ->
            connection.prepareStatement(sql).use { statement ->

                statement.setString(1, movie.title)
                statement.setString(2, movie.writer)
                statement.setString(3, movie.cast.joinToString(","))
                statement.setInt(4, movie.releaseYear)
                statement.setFloat(5, movie.rating)
                statement.setLong(6, movie.id)

                statement.execute()
            }
        }
    }

    fun deleteMovie(movie: Movie) {

        val sql = "delete from movies where id = ?"

        getConnection().use { connection ->
            connection.prepareStatement(sql).use { statement ->
                statement.setLong(1, movie.id)
                statement.execute()
            }
        }

    }

    fun find(id: Long): Movie? {

        var movie: Movie? = null;

        val sql = """
            select id, title, writer, cast, release_year, rating 
            from movies where id = ?
        """.trimIndent()

        getConnection().use { connection ->
            connection.prepareStatement(sql).use { statement ->
                statement.setLong(1, id)
                statement.executeQuery().use { rs ->
                    if (rs.next()) {
                        movie = Movie (
                            rs.getLong("id"),
                            rs.getString("title"),
                            rs.getString("writer"),
                            rs.getString("cast").split(","),
                            rs.getInt("release_year"),
                            rs.getFloat("rating")

                        )
                    }
                }
            }
        }
        return movie;
    }

}