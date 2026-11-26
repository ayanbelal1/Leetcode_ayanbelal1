class Solution {
    int n;
    boolean []visited;
    List<List<Integer>> adj;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        this.n=n;
        visited=new boolean[n];
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[]temp:edges){
            int u=temp[0];
            int v=temp[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        bfs(adj,source,destination);

        return visited[destination];
    }

    private void bfs(List<List<Integer>> adj,int src,int dest){

        Queue<Integer>q=new LinkedList<>();
        q.add(src);
        visited[src]=true;

        while(!q.isEmpty()){
            int u=q.remove();

            if(u==dest) break;

            for(int x:adj.get(u)){
                if(!visited[x]){
                    q.add(x);
                    visited[x]=true;
                }
            }
        }
    }
}