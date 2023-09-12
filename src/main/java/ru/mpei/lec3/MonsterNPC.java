package ru.mpei.lec3;

public class MonsterNPC extends NPC implements Walkable{

    public MonsterNPC(boolean alive, double speed, String name, boolean angry) {
        super(alive, speed, name);
//        this.alive = alive;
//        this.speed = speed;
//        this.name = name;
//        this.born();
        this.angry = angry;
    }

    @Override
    public void attack() {
        System.out.println("MONSTER ATTACK!");
    }

    @Override
    public NpcState getState() {
        return NpcState.Idle;
    }

    public MonsterNPC(boolean alive, double speed, String name) {
        super(alive, speed, name);
    }

    public MonsterNPC() {
    }

    private boolean angry;

    public void say(){
        System.out.println(this.name +" "+this.alive);
    }

    public boolean isAngry() {
        return angry;
    }

    public void setAngry(boolean angry) {
        this.angry = angry;
    }

    @Override
    public double walk() {
        System.out.println("i'm running");
        return 10;
    }
}
