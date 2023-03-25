package my.preparations.leetcode;

public class MaxAreaInContainerArr {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxAreaInContainerArr m = new MaxAreaInContainerArr();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(m.maxArea(arr));
    }
}
