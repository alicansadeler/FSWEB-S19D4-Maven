package com.workintech.s19d1.repository;

import com.workintech.s19d1.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
