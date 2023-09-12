package ru.mpei.lec3;

import ru.mpei.lec3.MonsterNPC;
import ru.mpei.lec3.NPC;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        String s = "Hello wrodl!";
        String s = new String("Hello world!");
        String[] res = s.split(" ");
        boolean res1 = s.startsWith("Hel");
        System.out.println(s.contains("world"));

//        NPC npc = new NPC();


        NPC mnpc = new MonsterNPC();

//        npc.attack();
        mnpc.attack();

        MonsterNPC monsterNPC = new MonsterNPC();
        HumanNPC humanNPC = new HumanNPC();

        runAway(monsterNPC);
        runAway(humanNPC);

        Walkable[] monsters = new Walkable[2];
        monsters[0] = monsterNPC;
        monsters[1] = humanNPC;

//        double h = Walkable.HiGh;

        double h1  = monsterNPC.HiGh;

        double h2  = monsterNPC.HiGh;

    }

    static void runAway(Walkable w){
        w.walk();
    }
}
