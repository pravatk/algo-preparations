package my.preparations.educative.binarysearch;

public class SquareRoot {
    public static int square_root(int n) {
        int low = 0, high = n/2, result = 0;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if(mid * mid <= n) {
                result = mid;
            }
            if (mid * mid > n) {
                high = mid - 1 ;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(square_root(144));
        System.out.println(square_root(16758));
    }
}
