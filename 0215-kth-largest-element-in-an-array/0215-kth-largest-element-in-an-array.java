class Solution {
    public int findKthLargest(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int x : nums) {
            max = Math.max(max, x);
            min = Math.min(min, x);
        }
        int[] arr = new int[max-min+1];
        for(int x : nums) {
            arr[x-min]++;
        }
        for(int i = arr.length-1; i >= 0; i--) {
            k -= arr[i];
            if(k <= 0) {
                return i + min;
            }
        }

        return -1;
    }
}