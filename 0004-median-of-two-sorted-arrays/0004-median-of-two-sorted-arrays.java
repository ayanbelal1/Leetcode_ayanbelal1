class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int[] arr = new int[n];

        int p1 = 0, p2 = 0;
        for (int i = 0; i < n; i++) {
            if (p1 < n1 && (p2 >= n2 || nums1[p1] <= nums2[p2])) {
                arr[i] = nums1[p1++];
            } else {
                arr[i] = nums2[p2++];
            }
        }
        if (n % 2 == 1) {
            return arr[n / 2]; 
        } else {
            return (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
        }
    }
}