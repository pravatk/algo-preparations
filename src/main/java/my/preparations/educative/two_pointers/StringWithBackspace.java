package my.preparations.educative.two_pointers;

/**
 * Comparing Strings containing Backspaces (medium)#
 * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
 * <p>
 * Example 1:
 * <p>
 * Input: str1="xy#z", str2="xzz#"
 * Output: true
 * Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
 * Example 2:
 * <p>
 * Input: str1="xy#z", str2="xyz#"
 * Output: false
 * Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
 * Example 3:
 * <p>
 * Input: str1="xp#", str2="xyz##"
 * Output: true
 * Explanation: After applying backspaces the strings become "x" and "x" respectively.
 * In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
 * Example 4:
 * <p>
 * Input: str1="xywrrmp", str2="xywrrmu#p"
 * Output: true
 * Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
 */
public class StringWithBackspace {
    public static boolean compareWithExtraSpace(String str1, String str2) {
        str1 = processBackspace(str1);
        str2 = processBackspace(str2);
        return str1.equals(str2);
    }

    private static String processBackspace(String str) {
        int skipCount = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == '#')
                skipCount++;
            else if (skipCount > 0) {
                skipCount--;
            } else {
                sb.append(ch);
            }
        }
        return sb.reverse().toString();
    }

    public static boolean compareWithoutExtraSpace(String str1, String str2) {
        int index1 = str1.length() - 1, index2 = str2.length() - 1;

        while (index1 >= 0 || index2 >= 0) {
            int i1 = getNextIndex(str1, index1);
            int i2 = getNextIndex(str2, index2);

            if (i1 < 0 && i2 < 0) return true;
            if (i1 < 0 || i2 < 0) return false;

            if (str1.charAt(i1) != str2.charAt(i2)) return false;

            index1 = i1 - 1;
            index2 = i2 - 1;
        }
        return true;
    }

    private static int getNextIndex(String str, int end) {
        int skipCount = 0;
        while (end >= 0) {
            if (str.charAt(end) == '#')
                skipCount++;
            else if (skipCount > 0)
                skipCount--;
            else
                break;
            end--;
        }
        return end;
    }

    public static void main(String[] args) {
        System.out.println(compareWithoutExtraSpace("xy#z", "xzz#"));
        System.out.println(compareWithoutExtraSpace("xy#z", "xyz#"));
        System.out.println(compareWithoutExtraSpace("xp#", "xyz##"));
        System.out.println(compareWithoutExtraSpace("xywrrmp", "xywrrmu#p"));
    }
}
