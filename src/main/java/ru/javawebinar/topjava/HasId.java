package ru.javawebinar.topjava;

import org.springframework.util.Assert;

public interface HasId {
    Integer getId();

    void setId(Integer id);

    default boolean isNew() {
        return getId() == null;
    }

    // doesn't work for hibernate lazy proxy
    default int id() {
        //Assertion utility class that assists in validating arguments.
        //Useful for identifying programmer errors early and clearly at runtime.
        //
        //For example, if the contract of a public method states it does not allow null arguments,
        // Assert can be used to validate that contract.
        Assert.notNull(getId(), "Entity must has id");
        return getId();
    }
}
