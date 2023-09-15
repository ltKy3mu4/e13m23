package ru.mpei.lec4;

public class BadUserException extends BankException{
    public BadUserException(String message) {
        super(message);
    }
}
