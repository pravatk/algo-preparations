package my.preparations.educative.binarysearch;

public class BinarySearch {
    public int binarySearch(int[] sortedArr, int target) {
        int low = 0, high = sortedArr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedArr[mid] == target) return mid;

            if (sortedArr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {2, 4, 5, 9, 16};
        System.out.println(binarySearch.binarySearch(arr, 5));
    }
}
