package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;


//1
@Controller
public class MealRestController extends AbstractMealRestController{
//    @Autowired
//    private MealService service;


    @Override
    public Meal create(Meal meal) {
        return super.create(meal);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        super.delete(id);
    }

    @Override
    public Meal get(int id) throws NotFoundException {
        return super.get(id);
    }

    @Override
    public void update(Meal meal, int id) {
        super.update(meal, id);
    }

    @Override
    public Collection<Meal> getAll() {
        return super.getAll();
    }
}