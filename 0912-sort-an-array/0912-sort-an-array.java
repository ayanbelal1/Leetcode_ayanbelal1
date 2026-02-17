class Solution {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int p = partition(nums, low, high);
            quickSort(nums, low, p - 1);
            quickSort(nums, p + 1, high);
        }
    }

    public int partition(int[] nums, int low, int high) {

        int pivot = nums[low];  
        int i = low;
        int j = high;

        while (i < j) {

            while (i <= high - 1 && nums[i] <= pivot) {
                i++;
            }

            while (j >= low + 1 && nums[j] > pivot) {
                j--;
            }

            if (i < j) {
                swap(nums, i, j);
            }
        }

        swap(nums, low, j);
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
