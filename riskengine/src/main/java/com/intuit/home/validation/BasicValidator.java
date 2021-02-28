package com.intuit.home.validation;

/**
 * Defines an interface for validation logic.
 * @param <T>
 */
public interface BasicValidator<T> {
    boolean validate(T toBEValidated);
}
