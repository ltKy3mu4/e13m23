package ru.mpei.lec1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        byte variable = 127;
        System.out.println(variable);
        variable = -20;
        System.out.println(variable);
        variable = 127;

        variable = (byte) (variable + 3);
        System.out.println(variable);

        int intVar = 2000;

        boolean a = true;
        boolean b = false;

        System.out.println(a);
        System.out.println(b);

        double doubleVal = 2.355;
        System.out.println(doubleVal);
        System.out.println("-------------------------");

        int val = 2;

        System.out.println(8 / val);
        int p = 9 / val;
        double pp = 9.0 / val;
        System.out.println(pp);

        char aa = 'a';
        System.out.println(aa);
        aa = 200;
        System.out.println(aa);

        System.out.println("-------------------------");
        int bb, cc = 2;

        System.out.println("Value of variable cc=" + cc);

        boolean a1, a2, a3;

        a1 = (27 / 2 == 13);

        a2 = 15 % 4 == 2;

        a3 = a1 || a2;

        System.out.println(a1+" "+a2+" "+a3);

        System.out.println(a1 != a3);

        int ppp = 150;
        boolean res = ppp%50==0;
        if (ppp > 150) {
            System.out.println("PPP > 150");
        } else if (ppp < 150){
            System.out.println("PPP < 150");
        } else {
            System.out.println("PPP = 150");
        }

        if (pp>150 || res){
            System.out.println("Complex condition");
        }
        int sf = 100;
        switch (sf){
            case 150:
                System.out.println("switch = 150");
                break;
            case 200:
                System.out.println("switch = 200");
                break;
            case 100:
                System.out.println("switch = 100");
                break;
            default:
                System.out.println("switch = default");
                break;
        }

        int[] array = {0,1,2,3,4};

        int sum = array[0] + array[1] +array[2] + array[3] +array[4];

        int sum2 = 0;
        int i = 0;
        while (i < array.length){
            sum2 = sum2 + array[i];
//            System.out.println("Cycle");
            i = i + 1;
        }
        System.out.println("Sum2 = "+sum2);

        //j++;
        //j = j + 1;

        int sum3 = 0;
        for(int j = 0; j < array.length; j++){
            System.out.println("precontinue");
            if (array[j] == 2){
                System.out.println("continue");
                continue;
            }
                System.out.println("postcontinue");

            sum3 += array[j];
//            if (sum3 > 5) {
//                break;
//            }
        }
        System.out.println("Sum3 = "+sum3);

        int[] array2 = new int[10];

        for ( int k =0; k < array2.length; k++){
            array2[k] = k;
        }
        System.out.println(Arrays.toString(array2));
        System.out.println(array2[10]);







        /////////////////////////////////
        int[] array3 = {5, 8, 1, 6, 3};

        int summ = 0;
        for (int h =0; h < array3.length; h++){
            summ = summ + array3[h]*array3[h];
        }
        summ = summ / array3.length;
        System.out.println("Sum : "+summ);

    }
}