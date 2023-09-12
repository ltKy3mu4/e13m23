package ru.mpei.lec3;

public class HumanNPC extends NPC implements Walkable{

    @Override
    public NpcState getState() {
        return NpcState.Moving;
    }

    public void say(){
        System.out.println("Put down your weapon.");
    }

    @Override
    public double walk() {
        System.out.println("I'm walking");
        return 3;
    }
}
