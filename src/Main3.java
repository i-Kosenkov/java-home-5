//Реализовать алгоритм пирамидальной сортировки (HeapSort). (Можно использовать массивы)

import java.util.Arrays;
import java.util.Random;

public class Main3 {
    public static int size;
    public static int temp;

    public static void main(String[] args) {
        int[] arr = getRandomArray(15, 0, 30);
        System.out.println(Arrays.toString(arr));
        getHeap(arr);
        while (size > 1) {
            temp = arr[0];
            arr[0] = arr[size - 1];
            arr[size - 1] = temp;
            size--;
            heapify(arr, 0);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int[] getRandomArray(int length, int min, int max) {
        Random random = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt((max - min) + 1) + min;
        }
        return arr;
    }

    public static void getHeap(int[] arr) {
        size = arr.length;
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    public static void heapify(int[] arr, int i) {
        int l = 2 * i + 1; //левый дочерний элемент 2 i + 1
        int r = 2 * i + 2; //правый дочерний элемент 2 i + 2
        int max = i; //наибольший элемент
        if (l < size && arr[i] < arr[l]) {
            max = l;
        }
        if (r < size && arr[max] < arr[r]) {
            max = r;
        }
        if (i != max) {
            temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapify(arr, max);
        }
    }
}
