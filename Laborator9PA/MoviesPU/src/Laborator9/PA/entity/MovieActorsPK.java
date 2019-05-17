package Laborator9.PA.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MovieActorsPK implements Serializable {
    private long movieId;
    private long actorId;

    @Column(name = "MOVIE_ID")
    @Id
    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    @Column(name = "ACTOR_ID")
    @Id
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
        MovieActorsPK that = (MovieActorsPK) o;
        return movieId == that.movieId &&
                actorId == that.actorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, actorId);
    }
}
