class Solution {
    public int[] searchRange(int[] nums, int target) {

        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int mid;
        int temp = -1;

        int arr[] = new int[2];

        while(low <= high){
            mid = low + (high - low) / 2;

            if(nums[mid] == target){
                temp = mid;
                break;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        if(temp == -1){
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }

        int left = temp;
        int right = temp;

        while(left >= 0 && nums[left] == target){
            left--;
        }

        while(right < n && nums[right] == target){
            right++;
        }

        arr[0] = left + 1;
        arr[1] = right - 1;

        return arr;
    }
}