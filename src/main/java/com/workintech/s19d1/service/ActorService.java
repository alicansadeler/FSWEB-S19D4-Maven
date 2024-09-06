package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;

import java.util.List;

public interface ActorService {
    Actor save(Actor actor);
    void delete(Actor actor);
    Actor findById(long id);

    List<Actor> findAll();
}
