package com.example.materia_seca;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Algorithms {

    public static void main(String[] args){

        int[] arr = {1, 3, 5, 7, 9, 10};
        System.out.println(binary_search(arr, 1));
        System.out.println(Arrays.toString(twoSum(arr, 11)));

    }

    public static int[] twoSum(int[] arr, int target){
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            int complement = target-arr[i];
            if(seen.containsKey(complement)){
                return new int[]{seen.get(complement), i};
            }
            seen.put(arr[i], i);
        }
        return new int[]{};
    }

    public static int binary_search(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid+1;
            else
                right = mid-1;
        }
        return -1;
    }

}
