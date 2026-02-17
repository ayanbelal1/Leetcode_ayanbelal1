class Solution {
    public int thirdMax(int[] nums) {
        int v1=0;
        int v2=0;
        int v3=0;
        for (int num:nums){
            int n=num;
            if ((v1!=0 && n==v1) || (v2!=0 && n==v2) || (v3!=0 && n==v3 )){
                continue;
            }
            if (v1==0 || n>v1){
                v3=v2;
                v2=v1;
                v1=n;
            }
            else if (v2==0 || n>v2){
                
                v3=v2;
                v2=n;
            }
            else if (v3==0 || n>v3){
                v3=n;
            }
        }

        if(v3==0){
            return v1;
        }
        return v3;
    }
}