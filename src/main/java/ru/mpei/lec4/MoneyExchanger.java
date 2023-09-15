package ru.mpei.lec4;

public class MoneyExchanger {

    public MoneyExchanger(double balance, int socialRating) {
        this.balance = balance;
        this.socialRating = socialRating;
    }

    private double balance = 0;

    private int socialRating = 100;

    public void makeTransaction(String receiverId, double sum){
        if (sum > balance) {
            throw new MoneyNotEnoughException("No money no honey");
        }
        if (socialRating < 10) {
            throw new BadUserException("How dare you! (c) Gretta");
        }
        balance -= sum;

    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setSocialRating(int socialRating) {
        this.socialRating = socialRating;
    }
}
