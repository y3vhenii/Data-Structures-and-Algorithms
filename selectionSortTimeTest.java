package com.company;
import java.util.*;

public class Main {

    static void selectionSort(Integer arr[]) {
        int n = arr.length;

        // One by one move boundary of unsorted sub-array
        for (int i = 0; i < n-1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        //Instantiate arrays
        Integer[] arr1 = new Integer[10];
        Integer[] arr2 = new Integer[100];
        Integer[] arr3 = new Integer[1000];
        Integer[] arr4 = new Integer[10000];
        Integer[] arr5 = new Integer[100000];
        Integer[] arr6 = new Integer[1000000];

        //Populate arrays with ordered numbers
        for (int i = 0; i < arr1.length; i++) { arr1[i] = i; }
        for (int i = 0; i < arr2.length; i++) { arr2[i] = i; }
        for (int i = 0; i < arr3.length; i++) { arr3[i] = i; }
        for (int i = 0; i < arr4.length; i++) { arr4[i] = i; }
        for (int i = 0; i < arr5.length; i++) { arr5[i] = i; }
        for (int i = 0; i < arr6.length; i++) { arr6[i] = i; }

        //Shuffle elements inside arrays
        Collections.shuffle(Arrays.asList(arr1));
        Collections.shuffle(Arrays.asList(arr2));
        Collections.shuffle(Arrays.asList(arr3));
        Collections.shuffle(Arrays.asList(arr4));
        Collections.shuffle(Arrays.asList(arr5));
        Collections.shuffle(Arrays.asList(arr6));

        //TESTING ARRAY 1 SORTING TIME
        long startArr1 = System.currentTimeMillis();
        selectionSort(arr1);
        long endArr1 = System.currentTimeMillis();
        long resultArr1 = endArr1 - startArr1;
        System.out.println("Time for sorting 10 elements: " + resultArr1);

            //TESTING ARRAY 2 SORTING TIME
            long startArr2 = System.currentTimeMillis();
            selectionSort(arr2);
            long endArr2 = System.currentTimeMillis();
            long resultArr2 = endArr2 - startArr2;
            System.out.println("Time for sorting 100 elements: " + resultArr2);

                //TESTING ARRAY 3 SORTING TIME
                long startArr3 = System.currentTimeMillis();
                selectionSort(arr3);
                long endArr3 = System.currentTimeMillis();
                long resultArr3 = endArr3 - startArr3;
                System.out.println("Time for sorting 1000 elements: " + resultArr3);

                    //TESTING ARRAY 4 SORTING TIME
                    long startArr4 = System.currentTimeMillis();
                    selectionSort(arr4);
                    long endArr4 = System.currentTimeMillis();
                    long resultArr4 = endArr4 - startArr4;
                    System.out.println("Time for sorting 10000 elements: " + resultArr4);

                        //TESTING ARRAY 5 SORTING TIME
                        long startArr5 = System.currentTimeMillis();
                        selectionSort(arr5);
                        long endArr5 = System.currentTimeMillis();
                        long resultArr5 = endArr5 - startArr5;
                        System.out.println("Time for sorting 100000 elements: " + resultArr5);

                            //TESTING ARRAY 6 SORTING TIME
                            long startArr6 = System.currentTimeMillis();
                            selectionSort(arr6);
                            long endArr6 = System.currentTimeMillis();
                            long resultArr6 = endArr6 - startArr6;
                            System.out.println("Time for sorting 1000000 elements: " + resultArr6);

    }
}