class Solution {
    public String[] createGrid(int m, int n) {
        String []ans=new String[m];
        if(m==1){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<n;i++){
                sb.append(".");
            }
            ans[m-1]=sb.toString();
            return ans;
        }
        if(n==1){
            for(int i=0;i<m;i++){
                StringBuilder sb=new StringBuilder();
                sb.append(".");
                ans[i]=sb.toString();
            }
            return ans;
        }
        for(int i=0;i<m;i++){
            StringBuilder sb1=new StringBuilder();
            for(int j=0;j<n;j++){
                
                
                if(i==0 || j==n-1) sb1.append(".");
                else sb1.append("#");
                ans[i]=sb1.toString();
            }
        }
        return ans;
    }
}