package my.preparations.educative.binarysearch;

public class FindBoundary {
    public int findBoundary(boolean[] arr) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid]) {
                high = mid - 1;
                result = mid;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindBoundary f = new FindBoundary();
        boolean[] arr = {false, false, false, true, true};
        System.out.println(f.findBoundary(arr));
    }
}
