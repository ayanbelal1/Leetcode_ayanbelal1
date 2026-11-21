class Solution {
    public String[] assignUmbrella(int[] rain) {
        int count1=0;
        int count2=0;
        int n=rain.length;
        String []ans=new String[n];

        for(int i=0;i<n;i++){
            if(rain[i]==0){
                ans[i]="None";
            }

            else if(i+1<n &&rain[i]==1 && rain[i+1]==1){
                if(count2<count1){
                    ans[i]="Bob";
                    count2++;
                }
                else{
                    ans[i]="Alice";
                    count1++;
                }
            }
            else if(i+1<n&&rain[i]==1 && rain[i+1]==0){
                ans[i]="Bob";
                count2++;
            }
        }
        if(rain[n-1]==1) ans[n-1]="Bob";
        else ans[n-1]="None";

        return ans;
    }
}