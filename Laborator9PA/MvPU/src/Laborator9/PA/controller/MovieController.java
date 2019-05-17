package Laborator9.PA.controller;

import Laborator9.PA.entity.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class MovieController {

    private EntityManagerFactory emf;
    public MovieController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public void create(Movie movie) {
        EntityManager em = emf.createEntityManager();
        Long id;
        if(em.createQuery("select max(m.id) from Movie m").getSingleResult()==null)
            id = new Long(1);
        else id=(Long)em.createQuery("select max(m.id) from Movie m").getSingleResult()+1;
        movie.setId(id);
        em.getTransaction().begin();
        em.persist(movie);
        em.getTransaction().commit();
        em.close();
    }
    public List<Movie> findByName(String directorName) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select t from Movie t where t.director_name = :name");
        List<Movie> movies = query.setParameter("name", directorName).getResultList();
        em.close();
        return movies.isEmpty() ? null : movies;
    }

}
