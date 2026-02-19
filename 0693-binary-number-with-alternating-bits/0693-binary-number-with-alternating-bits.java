class Solution {
    public boolean hasAlternatingBits(int n) {
        int x=0; int y=0;
        int i=0;
        boolean T=false;
        int arr[]=new int[100];
        while (n>0){
            x=n%2;
            arr[i]=(y*10)+x;
            n=n/2;
            i++;
        }
        
        for ( i=0;i<arr.length-1;i++){
            if (arr[i]!=arr[i+1]){
                T= true;
            }
            else T=false;
        }
        return T;
    }
}