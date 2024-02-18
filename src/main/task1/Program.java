package main.task1;

import java.util.Arrays;
import java.util.Random;

import static main.array_sort.QuickSort.quickSort;

public class Program {
    public static void main(String[] args) {
        int[] arr = new int[50];
        int[] arr2 = new int[50];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
            arr2[i] = arr[i];
        }

        long start = System.currentTimeMillis();
        quickSort(arr2, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        long over = System.currentTimeMillis();
        System.out.println(over - start);
    }
}
