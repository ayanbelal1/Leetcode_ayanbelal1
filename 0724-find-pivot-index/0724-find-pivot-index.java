class Solution {
    public int pivotIndex(int[] nums) {
        return findPivot(nums, 0);
    }

    int findPivot(int arr[], int index) {

        if (index >= arr.length) {
            return -1;
        }
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < index; i++) {
            leftSum += arr[i];
        }
        for (int j = index + 1; j < arr.length; j++) {
            rightSum += arr[j];
        }
        if (leftSum == rightSum) {
            return index;
        }
        return findPivot(arr, index + 1);
    }
}