package my.preparations.utils;

public class PrintUtils {
    public static <T> void printArray(T[] arr) {
        for (T t : arr) {
            System.out.print(t + "\t");
        }
    }
}
