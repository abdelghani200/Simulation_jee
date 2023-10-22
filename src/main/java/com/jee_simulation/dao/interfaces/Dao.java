package com.jee_simulation.dao.interfaces;

import java.util.List;
import java.util.Optional;

public interface Dao<T, P> {

    List<T> read();
    Optional<T> find(P identifier);

}
