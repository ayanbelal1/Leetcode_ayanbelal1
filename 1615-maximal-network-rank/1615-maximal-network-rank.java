class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean [][]adj=new boolean[n][n];
        int []degree=new int[n];

        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            adj[u][v]=true;
            adj[v][u]=true;

            degree[u]++;
            degree[v]++;
        }

        int max=(int)-1e9;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(adj[i][j]){
                        max=Math.max(max,degree[i]+degree[j]-1);
                    }
                    else{
                        max=Math.max(max,degree[i]+degree[j]);
                    }
                }
            }
        }
        return max;
    }
}