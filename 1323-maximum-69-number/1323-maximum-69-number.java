class Solution {
    public int maximum69Number (int num) {
        int[] digits = Integer.toString(num).chars().map(c -> c - '0').toArray();
        for(int i=0;i<digits.length;i++){
            if(digits[i]==6){
                digits[i]=9;
                break;
            }
        }
        int nums=0;
        for (int digit : digits) {
            nums = (nums * 10) + digit;
        }
        return nums;
    }
}