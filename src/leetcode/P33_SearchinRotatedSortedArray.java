package leetcode;

/**
 * 입력의 배열의 길이가 짝수 개(n) 일때 mid(n / 2 or n / 2 + 1)가 어떻게 주어질지 모든 케이스를 고려해야한다.
 */
public class P33_SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;

            if(nums[left] < nums[mid]) {
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }

        return -1;
    }
}
