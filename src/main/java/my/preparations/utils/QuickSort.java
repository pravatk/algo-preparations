package my.preparations.utils;

public class QuickSort {
    int getPartition(Integer[] arr, int low, int high) {
        int i = low;
        int j = high;
        while (true) {
            while (arr[++i] < arr[low]) {
                if (i == high) break;
            }

            while (arr[j] > arr[low]) {
                if (j == low) break;
                j--;
            }
            if (i >= j) break;
            exchange(arr, i, j);
        }
        exchange(arr, low, j);
        return j;
    }

    public void exchange(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void quickSort(Integer[] arr, int low, int high) {
        if (high <= low) return;
        int j = getPartition(arr, low, high);
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }

    public void threeWayQuickSort(Integer[] arr, int low, int hi) {
        if (hi <= low) return;
        int lt = low, i = lt, gt = hi;
        int p = arr[low];
        while (i <= gt) {
            if (arr[i] < p) exchange(arr, i++, lt++);
            else if (arr[i] > p) exchange(arr, i, gt--);
            else i++;
        }
        threeWayQuickSort(arr, low, lt - 1);
        threeWayQuickSort(arr, gt + 1, hi);
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        q.quickSort(arr, 0, arr.length - 1);

        q.threeWayQuickSort(arr, 0, arr.length - 1);
        PrintUtils.printArray(arr);
    }
}
