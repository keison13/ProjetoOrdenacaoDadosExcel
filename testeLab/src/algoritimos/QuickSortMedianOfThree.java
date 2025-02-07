package algoritimos;

import java.util.Date;

public class QuickSortMedianOfThree {
    public static double sort(int[] arr) {
        long startTime = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1e9; // Convertendo para segundos
        return executionTime;
    }

    public static double sort(String[] arr) {
        long startTime = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1e9; // Convertendo para segundos
        return executionTime;
    }

    public static double sort(Date[] arr) {
        long startTime = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1e9; // Convertendo para segundos
        return executionTime;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static void quickSort(Date[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        int medianIndex = medianOfThree(arr, low, mid, high);
        int pivot = arr[medianIndex];
        swap(arr, medianIndex, high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private static int partition(Date[] arr, int low, int high) {
        Date pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                Date temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Date temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private static int medianOfThree(int[] arr, int low, int mid, int high) {
        if (arr[low] < arr[mid]) {
            if (arr[mid] < arr[high]) {
                return mid;
            } else if (arr[low] < arr[high]) {
                return high;
            } else {
                return low;
            }
        } else {
            if (arr[low] < arr[high]) {
                return low;
            } else if (arr[mid] < arr[high]) {
                return high;
            } else {
                return mid;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


