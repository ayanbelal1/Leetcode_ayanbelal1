class Solution {
    public int thirdMax(int[] nums) {

        Integer v1 = null;
        Integer v2 = null;
        Integer v3 = null;

        for (int n : nums) {

            if ((v1 != null && n == v1) ||
                (v2 != null && n == v2) ||
                (v3 != null && n == v3)) {
                continue;
            }
            if (v1 == null || n > v1) {
                v3 = v2;
                v2 = v1;
                v1 = n;
            }
            else if (v2 == null || n > v2) {
                v3 = v2;
                v2 = n;
            }
            else if (v3 == null || n > v3) {
                v3 = n;
            }
        }

        return (v3 == null) ? v1 : v3;
    }
}
