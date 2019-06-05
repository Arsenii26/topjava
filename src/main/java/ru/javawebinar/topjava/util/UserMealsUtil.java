package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserMealsUtil {
   private static UserMealWithExceed userMealWithExceed = new UserMealWithExceed();
   private static ArrayList kk = new ArrayList();
   private static ArrayList kk2 = new ArrayList();


   // private static Map kk = new HashMap();
   // private static Map kk2 = new HashMap();
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
              //  new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 7777),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
      //  .toLocalDate();
      //  .toLocalTime();



        System.out.println();
        for (Object my : kk){
            System.out.println(my);
           // System.out.println(userMealWithExceed.isExceed());
        }
        for (Object my : kk2){
            System.out.println(my);
        }


    }
    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {


        for (UserMeal userMeal : mealList){

            if(TimeUtil.isBetween(userMeal.getDateTime().toLocalTime(), startTime, endTime) == true){

                if(userMeal.getCalories() > caloriesPerDay){
                    userMealWithExceed.setExceed(true);
                    kk2.add(userMealWithExceed.isExceed());
                    //System.out.println("More");
                }else {
                    userMealWithExceed.setExceed(false);
                    kk2.add(userMealWithExceed.isExceed());
                    // System.out.println("Less");
                }
                kk.add(userMeal);
            }
        }

        return kk;

    }

}
