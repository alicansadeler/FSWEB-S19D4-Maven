package com.workintech.s19d1.dto;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import lombok.Getter;

@Getter
public class MovieActorRequest {
    private Movie movie;
    private Actor actor;
}
