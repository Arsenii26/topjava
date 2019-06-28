package ru.javawebinar.topjava.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import static org.junit.Assert.*;
//import static ru.javawebinar.topjava.UserTestData.ADMIN;
//import static ru.javawebinar.topjava.UserTestData.USER;
import static ru.javawebinar.topjava.MealsTestData.*;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {

    static {
        // Only for postgres driver logging
        // It uses java.util.logging and logged via jul-to-slf4j bridge
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private MealService mealService;

    @Test(expected = NotFoundException.class)
    public void get() {
        Meal meal = mealService.get(MEAL1.getId(), 10);
        assertMatch(meal, MEAL1);

    }

    @Test(expected = NotFoundException.class)
    public void delete() {
        mealService.delete(MEAL1.getId(), 10);
    }

    @Test(expected = NotFoundException.class)
    public void update() {
        mealService.update(MEAL1, 10);
    }



    @Test
    public void getBetweenDates() {
        LocalDate localTime1 = LocalDate.of(2011, 03, 11);
        LocalDate localTime2 = LocalDate.of(2019, 12, 25);

        mealService.getBetweenDates(localTime1, localTime2, MEAL1.getId());
    }

    @Test
    public void getBetweenDateTimes() {
        LocalDateTime aDateTime1 = LocalDateTime.of(2011, Month.MARCH, 14, 12, 43, 45);
        LocalDateTime aDateTime2 = LocalDateTime.of(2019, Month.MARCH, 14, 12, 43, 45);
        mealService.getBetweenDateTimes(aDateTime1, aDateTime2, MEAL1.getId());
    }

    @Test
    public void getAll() {
        assertMatch(mealService.getAll(USER_ID), MEALS);
    }


    @Test
    public void create() {
        Meal newMeal = getCreated();
        Meal created = mealService.create(newMeal, USER_ID);
        newMeal.setId(created.getId());
        assertMatch(newMeal, created);
        assertMatch(mealService.getAll(USER_ID), newMeal, MEAL6, MEAL5, MEAL4, MEAL3, MEAL2, MEAL1);
    }
}