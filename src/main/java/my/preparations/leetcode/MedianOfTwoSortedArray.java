package my.preparations.leetcode;

public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] mergedArr = new int[m + n];
        int i = 0, j = 0, k = -1;
        while (i < m && j < n) {
            mergedArr[++k] = Math.min(nums1[i], nums2[j]);
            if (nums1[i] <= nums2[j])
                i++;
            else
                j++;
        }

        while (i < m) {
            mergedArr[++k] = nums1[i++];
        }
        while (j < n) {
            mergedArr[++k] = nums2[j++];
        }

        k = mergedArr.length;
        return k % 2 == 0 ? (mergedArr[k / 2] + mergedArr[(k / 2) - 1]) / 2.0 : mergedArr[(k - 1) / 2];
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArray m = new MedianOfTwoSortedArray();
        int[] a = {100001};
        int[] b = {100000};
        System.out.println(m.findMedianSortedArrays(a, b));
    }
}
