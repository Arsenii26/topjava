package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;

import static ru.javawebinar.topjava.util.ValidationUtil.assureIdConsistent;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNew;

public abstract class AbstractMealRestController {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private MealService service;

    public Meal create(Meal meal) {
        log.info("create");
        checkNew(meal);
        return service.create(meal);
    }

    public void delete(int id) throws NotFoundException {

        log.info("delete");
        service.delete(id);
    }

    public Meal get(int id) throws NotFoundException {
        log.info("get");
        return service.get(id);
    }

    public void update(Meal meal, int id) {

        log.info("update");
        assureIdConsistent(meal, id);
        service.update(meal);
    }

    public Collection<Meal> getAll() {
        log.info("getAll");
        return service.getAll();
    }
}
