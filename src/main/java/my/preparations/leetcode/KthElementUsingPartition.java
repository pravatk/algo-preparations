package my.preparations.leetcode;

public class KthElementUsingPartition {
    public int findKthTopElement(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int j = getPartition(arr, low, high);
            if (j > k) high = j - 1;
            else if (j < k) low = j + 1;
            else return arr[k];
        }
        return arr[k];
    }

    public int getPartition(int arr[], int low, int high) {
        int j = high + 1, i = low;
        while (true) {
            while (++i < arr.length && arr[i] < arr[low]) {
                if (i == high) break;
            }
            while (arr[low] < arr[--j]) {
                if (j == low) break;
            }
            if (i >= j) break;
            exchange(arr, i, j);
        }
        exchange(arr, low, j);
        return j;
    }

    public void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 6, 17, 11, 9, 18};
        KthElementUsingPartition k = new KthElementUsingPartition();
        System.out.println(k.findKthTopElement(arr, 0));
    }
}
