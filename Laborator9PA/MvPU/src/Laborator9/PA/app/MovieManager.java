package Laborator9.PA.app;

import Laborator9.PA.controller.MovieController;
import Laborator9.PA.controller.PersonController;
import Laborator9.PA.entity.Movie;
import Laborator9.PA.entity.Person;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class MovieManager {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MvPU");

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input command:");
            String command = scanner.nextLine();
            if (command.equals("exit")) break;
            String[] params = command.trim().split("\\s+");
            switch (params[0]) {
                case "create-person":
                    createPerson(params[1]); //the person name
                    break;
                case "create-movie":
                    createMovie(params[1], params[2]); //the album name and the director
                    break;
                case "list-movies":
                    listMovies(params[1]); //the director name
                    break;
            }
        }
    }
    private void createPerson(String personName) {
        //Implement this method
        PersonController personController = new PersonController(this.emf);
        Person person = new Person();
        person.setName(personName);

//        person.setId(1);
        System.out.println(person.getName());
        personController.create(person);
    }
    private void createMovie(String movieName, String directorName) {
        //TODO Implement this method
        MovieController movieController = new MovieController(this.emf);
        Movie movie  = new Movie();
        movie.setName(movieName);
        movie.setDirector_name(directorName);
        movie.setDirector_id(1);
        movieController.create(movie);
    }
    private void listMovies(String directorName) {
        //TODO Implement this method
        MovieController movieController = new MovieController(this.emf);
        System.out.println(movieController.findByName(directorName));
    }
    public static void main(String args[]) {
        new MovieManager().run();
    }

}
