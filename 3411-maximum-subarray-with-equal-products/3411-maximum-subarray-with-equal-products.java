class Solution {
    public int maxLength(int[] nums) {
        int n=nums.length;

        int max=(int)-1e9;
        for(int i=0;i<n;i++){
            long prod=1;
            long gc=0;
            long lc=1;
            for(int j=i;j<n;j++){
                prod*=(long)nums[j];
                gc=(gc==0)?(long)nums[j]:gcd(gc,(long)nums[j]);
                lc=lcm(lc,(long)nums[j]);
                
                if(prod==gc*lc) max=Math.max(max,(j-i+1));
            }
        }
        return max;
    }

    private long gcd(long a,long b){
        if(b==0){
            return a;
        }

        return gcd(b,a%b);
    }

    private long lcm(long a,long b){
        if(a==0||b==0){
            return 0;
        }
        return Math.abs((a/gcd(a,b))*b);
    }
}