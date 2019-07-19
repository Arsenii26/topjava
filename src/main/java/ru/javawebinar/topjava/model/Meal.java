package ru.javawebinar.topjava.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SuppressWarnings("JpaQlInspection") //@SuppressWarnings will tell the IDE to stop complaining about something.
@NamedQueries({ // именованные запросы — это такие запросы, которые вызываются по имени.
        @NamedQuery(name = Meal.ALL_SORTED, query = "SELECT m FROM Meal m WHERE m.user.id=:userId ORDER BY m.dateTime DESC"), //The DESC command is used to sort the data returned in descending order.
        @NamedQuery(name = Meal.DELETE, query = "DELETE FROM Meal m WHERE m.id=:id AND m.user.id=:userId"),
        @NamedQuery(name = Meal.GET_BETWEEN, query = "SELECT m FROM Meal m " +
                "WHERE m.user.id=:userId AND m.dateTime BETWEEN :startDate AND :endDate ORDER BY m.dateTime DESC"),
//        @NamedQuery(name = Meal.UPDATE, query = "UPDATE Meal m SET m.dateTime = :datetime, m.calories= :calories," +
//                "m.description=:desc where m.id=:id and m.user.id=:userId")
})
@Entity
@Table(name = "meals", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "date_time"}, name = "meals_unique_user_datetime_idx")}) //link for the table in DB
public class Meal extends AbstractBaseEntity {
    public static final String ALL_SORTED = "Meal.getAll";
    public static final String DELETE = "Meal.delete";
    public static final String GET_BETWEEN = "Meal.getBetween";

    @Column(name = "date_time", nullable = false) //column in meals table must has exactly the same name
    @NotNull
    private LocalDateTime dateTime;

    @Column(name = "description", nullable = false)
    @NotBlank //user should enter something
    @Size(min = 2, max = 120)
    private String description;

    @Column(name = "calories", nullable = false)
    @Range(min = 10, max = 5000) //range for number values
    private int calories;

    @ManyToOne(fetch = FetchType.LAZY) //one user  for many meals with LAZY type
    @JoinColumn(name = "user_id", nullable = false) //connect table users for meals table for key user_id
    @NotNull
    private User user;

    public Meal() {
    }

    public Meal(LocalDateTime dateTime, String description, int calories) {
        this(null, dateTime, description, calories);
    }

    public Meal(Integer id, LocalDateTime dateTime, String description, int calories) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
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

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }
}