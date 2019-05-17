package Laborator9.PA;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            PersonController persons = new PersonController();
            MovieController movies = new MovieController();

            persons.create("Francis Ford Coppola");
            persons.create("Marlon Brando");
            persons.create("Al Pacino");
            /*Database.commit();*/
            System.out.println(persons.findByName("Coppola"));
            movies.create("The Godfather", persons.findByName("Coppola"));
            //...Add other movies to the database
            /*Database.commit();*/

            Database.closeConnection();
        } catch (SQLException e) {
            System.err.println(e);
//            Database.rollback();
        }
    }
}
