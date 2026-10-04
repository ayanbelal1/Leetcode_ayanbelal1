class Solution {
    public int reverse(int x) {
        int temp=x;

        if(x<0){
            temp=-temp;
        }

        long result=0;
        while(temp>0){
            int a=temp%10;
            result=result*10+(long)(a);
            temp=temp/10;
        }
        
        if(result>Integer.MAX_VALUE){
            return 0;
        }
        if(x<0) result=-result;
        System.out.println(result);

        if(result<0 && x>0 || result>0 && x<0){
            return 0;
        }
        return (int)result;
    }
}