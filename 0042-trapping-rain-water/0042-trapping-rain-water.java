class Solution {
    int n;
    public int trap(int[] height) {
        n=height.length;
        int []MAX_left=new int[n];
        int []MAX_right=new int[n];

        MAX_left[0]=height[0];
        MAX_right[n-1]=height[n-1];

        for(int i=1;i<n;i++){
            MAX_left[i]=Math.max(MAX_left[i-1],height[i]);
        }
        for(int i=n-2;i>=0;i--){
            MAX_right[i]=Math.max(MAX_right[i+1],height[i]);
        }
        
        int trapped=0;
        for(int i=0;i<n;i++){
            trapped+=Math.min(MAX_left[i],MAX_right[i])-height[i];
        }

        return trapped;
    }
}