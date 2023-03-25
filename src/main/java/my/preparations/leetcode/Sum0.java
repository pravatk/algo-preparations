package my.preparations.leetcode;

public class Sum0 {
    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, -5};
        System.out.println(isSum0(arr));
    }

    private static int isSum0(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            if (sum == 0) return 1;
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0) return 1;
            }
        }
        return 0;
    }
}
