package com.company;
import java.util.*;

public class Main {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(Integer arr[], int l, int m, int r)
    {
        // Find sizes of two sub-arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged sub-array array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void mergeSort(Integer arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
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
            mergeSort(arr1, 0, arr1.length-1);
            long endArr1 = System.currentTimeMillis();
            long resultArr1 = endArr1 - startArr1;
            System.out.println("Time for sorting 10 elements: " + resultArr1);

            //TESTING ARRAY 2 SORTING TIME
            long startArr2 = System.currentTimeMillis();
            mergeSort(arr2, 0, arr2.length-1);
            long endArr2 = System.currentTimeMillis();
            long resultArr2 = endArr2 - startArr2;
            System.out.println("Time for sorting 100 elements: " + resultArr2);

            //TESTING ARRAY 3 SORTING TIME
            long startArr3 = System.currentTimeMillis();
            mergeSort(arr3, 0, arr3.length-1);
            long endArr3 = System.currentTimeMillis();
            long resultArr3 = endArr3 - startArr3;
            System.out.println("Time for sorting 1000 elements: " + resultArr3);

            //TESTING ARRAY 4 SORTING TIME
            long startArr4 = System.currentTimeMillis();
            mergeSort(arr4, 0, arr4.length-1);
            long endArr4 = System.currentTimeMillis();
            long resultArr4 = endArr4 - startArr4;
            System.out.println("Time for sorting 10000 elements: " + resultArr4);

            //TESTING ARRAY 5 SORTING TIME
            long startArr5 = System.currentTimeMillis();
            mergeSort(arr5, 0, arr5.length-1);
            long endArr5 = System.currentTimeMillis();
            long resultArr5 = endArr5 - startArr5;
            System.out.println("Time for sorting 100000 elements: " + resultArr5);

            //TESTING ARRAY 6 SORTING TIME
            long startArr6 = System.currentTimeMillis();
            mergeSort(arr6, 0, arr6.length-1);
            long endArr6 = System.currentTimeMillis();
            long resultArr6 = endArr6 - startArr6;
            System.out.println("Time for sorting 1000000 elements: " + resultArr6);

            //TESTING ARRAY 7 SORTING TIME
            long startArr7 = System.currentTimeMillis();
            mergeSort(arr7, 0, arr7.length-1);
            long endArr7 = System.currentTimeMillis();
            long resultArr7 = endArr7 - startArr7;
            System.out.println("Time for sorting 10000000 elements: " + resultArr7);

            //TESTING ARRAY 8 SORTING TIME
            //long startArr8 = System.currentTimeMillis();
            //mergeSort(arr8, 0, arr8.length-1);
            //long endArr8 = System.currentTimeMillis();
            //long resultArr8 = endArr8 - startArr8;
            //System.out.println("Time for sorting 10000000 elements: " + resultArr8);
}}