package ru.javawebinar.topjava.model;

import ru.javawebinar.topjava.util.UserMealsUtil;

import java.time.LocalDateTime;

public class UserMealWithExceed {
    //private final LocalDateTime dateTime;
    private  LocalDateTime dateTime;
   // private final String description;
    private  String description;
   // private  final int calories;
    private   int calories;
    //private final boolean exceed;
    private  boolean exceed;

    public boolean isExceed() {
        return exceed;
    }

    public  void setExceed(boolean exceed) {
        this.exceed = exceed;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }



    public UserMealWithExceed(LocalDateTime dateTime, String description, int calories, boolean exceed) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.exceed = exceed;
    }


    @Override
    public String toString() {
        return "UserMealWithExceed{" +
                "dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", exceed=" + exceed +
                '}';
    }
}
