package ru.mpei.lec4;

public class MoneyNotEnoughException extends BankException{
    public MoneyNotEnoughException(String message) {
        super(message);
    }
}
