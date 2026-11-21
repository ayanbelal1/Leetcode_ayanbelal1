class Solution {
    public int minRange(int a, int b, int c) {
        int max=Math.max(a,Math.max(b,c));
        int min=Math.min(a,Math.min(b,c));
        int middle=(int)1e9;

        if(max==a && min==b||max==b && min==a){
            middle=c;
        }
        else if(max==a && min==c||max==c && min==a){
            middle=b;
        }
        else if(max==b && min==c||max==c && min==b){
            middle=a;
        }

        while(max>(min+middle)){
            max=min+middle;
        }

        return max-min;
    }
}







        //int middle=(int)1e9;
        // if(max==a && min==b||max==b && min==a){
        //     middle=c;
        // }
        // else if(max==a && min==c||max==c && min==a){
        //     middle=b;
        // }
        // else if(max==b && min==c||max==c && min==b){
        //     middle=a;
        // }

        // System.out.println(middle);

        // return Math.min((max-min),(max-(middle+min)));