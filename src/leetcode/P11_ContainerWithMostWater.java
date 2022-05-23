package leetcode;

public class P11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int result = 0;
        int start = 0;
        int end = height.length - 1;
        while(start < end) {
            result = Math.max((end - start) * Math.min(height[start], height[end]), result);
            if(height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }
}
