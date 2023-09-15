package ru.mpei.lec4;

public class BankException extends RuntimeException {
    public BankException(String message) {
        super("It's my lib : "+message);
    }
}
