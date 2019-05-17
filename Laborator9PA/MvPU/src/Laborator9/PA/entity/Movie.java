package Laborator9.PA.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="MOVIES", schema = "LUIGI")
public class Movie implements Serializable {
    private long id;
    private String name;
    private long director_id;
    private String director_name;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name="DIRECTOR_ID")
    public void setDirector_id(long director_id){
        this.director_id=director_id;
    }
    public long getDirector_id(){
        return this.director_id;
    }

    @Basic
    @Column(name="DIRECTOR_NAME")
    public void setDirector_name(String directorName){
        this.director_name = directorName;
    }
    public String getDirector_name(){
        return this.director_name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return name;
    }
}
