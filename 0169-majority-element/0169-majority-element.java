class Solution {
    public int majorityElement(int[] nums) {
        int temp1=0;
        int temp2=0;
        for (int num:nums){
            if (temp1==0){
                temp2=num;
            }
            if(num==temp2){
                temp1++;
            }
            else{
             temp1 --;
            }
        }
        return temp2;
    }
}