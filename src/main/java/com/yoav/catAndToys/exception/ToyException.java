package com.yoav.catAndToys.exception;

public class ToyException extends Exception{
    public ToyException() {
        super("Toy not found");
    }

    public ToyException(String message) {
        super(message);
    }
}
