package my.preparations.utils;

public class InsertionSort {
    public void insertionSort(Integer arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 2, 3, 4, 8, 7, 5};
        InsertionSort i = new InsertionSort();
        i.insertionSort(a);
        PrintUtils.printArray(a);
    }
}
