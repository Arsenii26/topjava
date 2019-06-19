package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;
import java.util.List;

//4 made connection
public interface MealService {

    Meal create(Meal meal);

    void delete(int id) throws NotFoundException;

    Meal get(int id) throws NotFoundException;

    //User getByEmail(String email) throws NotFoundException;

    void update(Meal meal);

    Collection<Meal> getAll();
}