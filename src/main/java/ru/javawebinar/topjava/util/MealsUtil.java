package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

public class MealsUtil {
    public static void main(String[] args) {
        List<Meal> mealList = Arrays.asList(
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );
        getFilteredWithExcess(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
//        .toLocalDate();
//        .toLocalTime();
        List<MealTo> fw = getFilteredWithExcess(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        fw.forEach(m -> System.out.println(m));
    }


    private static Map<LocalDate, Integer> mapDay = new HashMap<>();

    public static List<MealTo> getFilteredWithExcess(List<Meal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        List<MealTo> list = new ArrayList<>();

        mapDay.merge(mealList.get(0).getDateTime().toLocalDate(), mealList.get(0).getCalories(), (a, b) -> a + b);

        if (mealList.size() > 1) {
            list.addAll(getFilteredWithExcess(mealList.subList(1, mealList.size()),
                    startTime, endTime, caloriesPerDay));
        }
        LocalTime time = mealList.get(0).getDateTime().toLocalTime();
        if (TimeUtil.isBetween(time, startTime, endTime)) {
            list.add(new MealTo(
                    mealList.get(0).getDateTime(),
                    mealList.get(0).getDescription(),
                    mealList.get(0).getCalories(),
                    mapDay.get(mealList.get(0).getDateTime().toLocalDate()) <= caloriesPerDay));

        }
        return list;
    }
}