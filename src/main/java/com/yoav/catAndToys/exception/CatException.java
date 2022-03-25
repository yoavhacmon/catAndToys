package com.yoav.catAndToys.exception;

public class CatException extends Exception{
    public CatException() {
        super("Cat not found");
    }

    public CatException(String message) {
        super(message);
    }
}
