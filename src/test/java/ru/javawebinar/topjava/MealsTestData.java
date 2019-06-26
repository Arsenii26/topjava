package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealsTestData {
    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;
    private static LocalDateTime aDateTime = LocalDateTime.of(2013, Month.MARCH, 15, 17, 03, 35);
    private static LocalDateTime aDateTime1 = LocalDateTime.of(2013, Month.APRIL, 12, 15, 13, 25);
    private static LocalDateTime aDateTime2 = LocalDateTime.of(2013, Month.MARCH, 14, 12, 43, 45);
   // private static LocalDateTime aDateTime2 = LocalDateTime.now();




    public static final Meal meal = new Meal(USER_ID, aDateTime, "Kartoshka", 888);
    public static final Meal meal1 = new Meal(ADMIN_ID, aDateTime1, "'Carrot'", 777);
    public static final Meal meal2 = new Meal(ADMIN_ID + 1, aDateTime2, "Steak", 1888);

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "registered", "roles");
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("registered", "roles").isEqualTo(expected);
    }
}
