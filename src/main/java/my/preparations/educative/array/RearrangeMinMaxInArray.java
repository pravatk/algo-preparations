package my.preparations.educative.array;

/**
 * In this problem, you have to implement the void maxMin(int[] arr) method.
 * This will re-arrange the elements of a sorted array in such a way that the first position
 * will have the largest number, the second will have the smallest, the third will have the
 * second-largest, and so on.
 * <p>
 * Input
 * arr = {1, 2, 3, 4, 5}
 * Output
 * arr = {5, 1, 4, 2, 3}
 */
public class RearrangeMinMaxInArray {
    public static void rearrangeMaxMin(int[] arr) {
        int minIndex = 0, maxIndex = arr.length - 1;
        int max = arr[maxIndex] + 1;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] += (arr[maxIndex] % max) * max;
                maxIndex--;
            } else {
                arr[i] += (arr[minIndex] % max) * max;
                minIndex++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] /= max;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.print("Array before min/max: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        rearrangeMaxMin(arr);

        System.out.print("Array after min/max: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
