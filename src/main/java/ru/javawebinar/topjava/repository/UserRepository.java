package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.User;

import java.util.List;

public interface UserRepository {
    // null if not found, when updated
    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User get(int id);

    // null if not found
    User getByEmail(String email);

    List<User> getAll();

    //Default методы так же можно переопределять как и обычные методы.
    // метод с реализацией в интерфейсах
    default User getWithMeals(int id) {
        throw new UnsupportedOperationException();
    }
}