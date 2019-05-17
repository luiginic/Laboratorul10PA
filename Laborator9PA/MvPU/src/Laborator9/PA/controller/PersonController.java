package Laborator9.PA.controller;

import Laborator9.PA.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class PersonController {

    private EntityManagerFactory emf;
    public PersonController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public void create(Person person) {
        EntityManager em = emf.createEntityManager();
        Long id=(Long)em.createQuery("select max(p.id) from Person p").getSingleResult()+1;
        person.setId(id);
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }
    public Person findByName(String personName) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select t from Person t where t.name like :name");
        List<Person> persons = query.setParameter("name", personName).getResultList();
        em.close();
        return persons.isEmpty() ? null : persons.get(0);
    }

}
