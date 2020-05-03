package com.company;
import java.util.*;


public class Main {
    // A utility function to get maximum value in arr[]
    static int getMax(Integer arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(Integer arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixsort(Integer arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    public static void main(String[] args) {
        //Instantiate arrays
        Integer[] arr1 = new Integer[10];
        Integer[] arr2 = new Integer[100];
        Integer[] arr3 = new Integer[1000];
        Integer[] arr4 = new Integer[10000];
        Integer[] arr5 = new Integer[100000];
        Integer[] arr6 = new Integer[1000000];
        Integer[] arr7 = new Integer[10000000];
        //Integer[] arr8 = new Integer[100000000];

        //Populate arrays with ordered numbers
        for (int i = 0; i < arr1.length; i++) { arr1[i] = i; }
        for (int i = 0; i < arr2.length; i++) { arr2[i] = i; }
        for (int i = 0; i < arr3.length; i++) { arr3[i] = i; }
        for (int i = 0; i < arr4.length; i++) { arr4[i] = i; }
        for (int i = 0; i < arr5.length; i++) { arr5[i] = i; }
        for (int i = 0; i < arr6.length; i++) { arr6[i] = i; }
        for (int i = 0; i < arr7.length; i++) { arr7[i] = i; }
        //for (int i = 0; i < arr8.length; i++) { arr8[i] = i; }

        //Shuffle elements inside arrays
        Collections.shuffle(Arrays.asList(arr1));
        Collections.shuffle(Arrays.asList(arr2));
        Collections.shuffle(Arrays.asList(arr3));
        Collections.shuffle(Arrays.asList(arr4));
        Collections.shuffle(Arrays.asList(arr5));
        Collections.shuffle(Arrays.asList(arr6));
        Collections.shuffle(Arrays.asList(arr7));
        //Collections.shuffle(Arrays.asList(arr8));

        //TESTING ARRAY 1 SORTING TIME
        long startArr1 = System.currentTimeMillis();
        radixsort(arr1, arr1.length);
        long endArr1 = System.currentTimeMillis();
        long resultArr1 = endArr1 - startArr1;
        System.out.println("Time for sorting 10 elements: " + resultArr1);

        //TESTING ARRAY 2 SORTING TIME
        long startArr2 = System.currentTimeMillis();
        radixsort(arr2, arr2.length);
        long endArr2 = System.currentTimeMillis();
        long resultArr2 = endArr2 - startArr2;
        System.out.println("Time for sorting 100 elements: " + resultArr2);

        //TESTING ARRAY 3 SORTING TIME
        long startArr3 = System.currentTimeMillis();
        radixsort(arr3, arr3.length);
        long endArr3 = System.currentTimeMillis();
        long resultArr3 = endArr3 - startArr3;
        System.out.println("Time for sorting 1000 elements: " + resultArr3);

        //TESTING ARRAY 4 SORTING TIME
        long startArr4 = System.currentTimeMillis();
        radixsort(arr4, arr4.length);
        long endArr4 = System.currentTimeMillis();
        long resultArr4 = endArr4 - startArr4;
        System.out.println("Time for sorting 10000 elements: " + resultArr4);

        //TESTING ARRAY 5 SORTING TIME
        long startArr5 = System.currentTimeMillis();
        radixsort(arr5, arr5.length);
        long endArr5 = System.currentTimeMillis();
        long resultArr5 = endArr5 - startArr5;
        System.out.println("Time for sorting 100000 elements: " + resultArr5);

        //TESTING ARRAY 6 SORTING TIME
        long startArr6 = System.currentTimeMillis();
        radixsort(arr6,  arr6.length);
        long endArr6 = System.currentTimeMillis();
        long resultArr6 = endArr6 - startArr6;
        System.out.println("Time for sorting 1000000 elements: " + resultArr6);

        //TESTING ARRAY 7 SORTING TIME
        long startArr7 = System.currentTimeMillis();
        radixsort(arr7, arr7.length);
        long endArr7 = System.currentTimeMillis();
        long resultArr7 = endArr7 - startArr7;
        System.out.println("Time for sorting 10000000 elements: " + resultArr7);

        //TESTING ARRAY 8 SORTING TIME
        //long startArr8 = System.currentTimeMillis();
        //mergeSort(arr8, 0, arr8.length-1);
        //long endArr8 = System.currentTimeMillis();
        //long resultArr8 = endArr8 - startArr8;
        //System.out.println("Time for sorting 10000000 elements: " + resultArr8);

    }
}