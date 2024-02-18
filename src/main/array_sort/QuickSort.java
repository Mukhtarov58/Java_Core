package main.array_sort;

/**
 * Алгоритм бинарного поиска по элементам массива
 */
public class QuickSort {
    /**
     * Функция быстрого поиска элем енотов массива
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        int p = arr[(start + end) / 2];
        do {
            while (arr[left] < p) {
                left++;
            }
            while (arr[right] > p) {
                right--;
            }
            if (left <= right) {
                if (left < right) {
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
                left++;
                right--;
            }
        } while (left <= right);
        if (left < end) {
            quickSort(arr, left, end);
        }
        if (start < right) {
            quickSort(arr, start, right);
        }
    }
}
