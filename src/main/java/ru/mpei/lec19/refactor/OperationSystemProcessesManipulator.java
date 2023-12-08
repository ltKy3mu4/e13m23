package ru.mpei.lec19.refactor;

import java.util.ArrayList;
import java.util.List;

public class OperationSystemProcessesManipulator {

    public  boolean runJar(String jarPath, List<String> args){
        /**  execute statistic utility */
        try {
            List<String> commandArgs = new ArrayList<>(List.of("java", "-jar", jarPath));
            commandArgs.addAll(args);
            ProcessBuilder pb = new ProcessBuilder();
            pb.command(commandArgs);

            Process start = pb.start();
            while (start.isAlive()){
                start.isAlive();
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
