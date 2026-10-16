package com.ds.p00_recursions.problems;

public class RecursionProblems {
    public static int factorial(int num){
        System.out.println("--> num : " + num);
        if(num == 0){
            return 1;
        }
        int res = num * factorial(num - 1);
        System.out.println("--> res : " + res);
        return res;
    }
}
