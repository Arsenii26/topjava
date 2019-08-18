package ru.javawebinar.topjava;

import javax.validation.groups.Default;

//The persist method is intended for adding a new entity instance to the persistence context,
// i.e. transitioning an instance from transient to persistent state.
//
//We usually call it when we want to add a record to the database (persist an entity instance):
//Person person = new Person();
//person.setName("John");
//session.persist(person);
public class View {
    public interface Persist extends Default {}
}