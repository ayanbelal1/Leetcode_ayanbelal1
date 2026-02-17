import java.util.Arrays;

class Solution {
    public int thirdMax(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        int count = 1;  
        int res = nums[n - 1]; 
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] != nums[i + 1]) {
                count++;
            }

            if (count == 3) {
                return nums[i];  
            }
        }
        return nums[n - 1];
    }
}
