package devklazz.ms.db

import java.sql.Connection
import java.sql.DriverManager

fun getConnection() : Connection {

    val url = "jdbc:mysql://localhost:3306/movie_system"
    val user = "root"
    val password = "root"
    return DriverManager.getConnection(url, user, password);

}