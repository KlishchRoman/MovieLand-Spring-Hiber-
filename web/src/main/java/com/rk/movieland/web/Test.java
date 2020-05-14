package com.rk.movieland.web;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    private static int i = 0;

    public static void main(String[] args) {

        int [] arr = {3,2,1,5,9,6,0,7};
        String[] arrString = {"sad", "pod", "lop", "gdr", "sra"};
        System.out.println(fibonachi(5));
        halfsum(arr);
       // Arrays.stream(arrString).sorted((o1,o2)->o1.compareTo(o2)).forEach(System.out::println);
    }

    public static int fibonachi(int start){
        if (start==1){
            return 1;
        }
        return start + fibonachi(start - 1);
    }
    public static int halfsum(int[] arr) {
        for (int j = 1; j <arr.length-1 ; j++) {
         if ((arr[j-1]+arr[j+1])/2==arr[j]){
             System.out.println(arr[j]);
         }
        }
        return 0;
    }
}
