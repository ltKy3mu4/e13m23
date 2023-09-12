package ru.mpei.lec3;

import java.sql.SQLOutput;

public abstract class NPC {
    public static double HiGh = 100;
    protected boolean alive;
    protected double speed;
    protected String name;

    public  abstract  NpcState getState();

    public NPC(boolean alive, double speed, String name) {
        this.alive = alive;
        this.speed = speed;
        this.name = name;
        this.born();
    }

    public void attack(){
        System.out.println("Attack!!!");
    }

    private void born(){
        System.out.println("I was born");
    }

    public NPC() {
    }

    public void say(){
        System.out.println(this.name +" "+this.alive);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
