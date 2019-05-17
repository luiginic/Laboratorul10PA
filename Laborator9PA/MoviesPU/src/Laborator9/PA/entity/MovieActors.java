package Laborator9.PA.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MOVIE_ACTORS", schema = "LUIGI", catalog = "")
@IdClass(MovieActorsPK.class)
public class MovieActors {
    private long movieId;
    private long actorId;

    @Id
    @Column(name = "MOVIE_ID")
    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    @Id
    @Column(name = "ACTOR_ID")
    public long getActorId() {
        return actorId;
    }

    public void setActorId(long actorId) {
        this.actorId = actorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieActors that = (MovieActors) o;
        return movieId == that.movieId &&
                actorId == that.actorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, actorId);
    }
}
