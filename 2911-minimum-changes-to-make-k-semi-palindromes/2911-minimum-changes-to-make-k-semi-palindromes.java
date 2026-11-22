class Solution {
    int n;
    String s;
    int maindp[][];
    int helperdp[][];

    public int minimumChanges(String s, int k) {
        n=s.length();
        this.s=s;

        maindp=new int[n+1][k+1];
        for(int []row:maindp){
            Arrays.fill(row,-1);
        }
        helperdp=new int[n+1][n+1];
        for(int []row:helperdp){
            Arrays.fill(row,-1);
        }

        return solve(0,k);
    }

    private int solve(int i,int k){
        
        if(k==0){
            if(i==n){
                return 0;
            }
            else{
                return (int)1e9;
            }
        }

        if(i+2*k>n) return (int)1e9;

        if(maindp[i][k]!=-1) return maindp[i][k];

        int minCost=(int)1e9;
        for(int partition=i+1;partition<n;partition++){

            int cost=getCost(i,partition)+solve(partition+1,k-1);
            minCost=Math.min(minCost,cost);
        }
        return maindp[i][k]=minCost;
    }

    private int getCost(int start,int end){

        int len=end-start+1;
        int minDivCost=(int)1e9;

        if(helperdp[start][end]!=-1) return helperdp[start][end];

        for(int d=1;d<len;d++){
            
            if(len%d!=0) continue;
            int count=0;
            for(int group=0;group<d;group++){
                
                int first=start+group;
                int last=(start+group)+((len/d)-1)*d;
                while(first<=last){
                    if(s.charAt(first)!=s.charAt(last)){
                        count++;
                    }
                    first+=+d;
                    last-=d;
                }
            }
            minDivCost=Math.min(minDivCost,count);
        }
        return helperdp[start][end]=minDivCost;
    }
}