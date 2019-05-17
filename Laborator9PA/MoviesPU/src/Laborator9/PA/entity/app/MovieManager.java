package Laborator9.PA.entity.app;

import Laborator9.PA.entity.Person;
import Laborator9.PA.entity.controller.PersonController;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class MovieManager {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MoviesPU");

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
        person.setId(1);
        personController.create(person);
    }
    private void createMovie(String movieName, String directorName) {
		//TODO Implement this method
    }
    private void listMovies(String directorName) {
		//TODO Implement this method
    }
    public static void main(String args[]) {
        new MovieManager().run();
    }

}
