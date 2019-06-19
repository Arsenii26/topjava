package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

//4 made connection
public interface MealRepository {
    Meal save(Meal meal); //responsible for creating and updating

    // false if not deleted
    boolean delete(int id);

    // null if not found
    Meal get(int id);

    Collection<Meal> getAll();
}
