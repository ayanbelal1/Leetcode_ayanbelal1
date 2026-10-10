class Solution {
    public int maximum69Number (int num) {
        int[] digits = Integer.toString(num).chars().map(c -> c - '0').toArray();

        int n=digits.length;
        int max1=num;
        while(n>0){
            int[] digits1 = Arrays.copyOf(digits, digits.length);
            if(digits1[n-1]==6){
                digits1[n-1]=9;
                int nums=0;
                for (int digit : digits1) {
                    nums = (nums * 10) + digit;
                }
                max1=Math.max(max1,nums);
            }
            else{
                digits1[n-1]=6;
                int nums=0;
                for (int digit : digits1) {
                    nums = (nums* 10) + digit;
                }
                max1=Math.max(max1,nums);
            }
            n--;
        }
        return max1;
    }
}