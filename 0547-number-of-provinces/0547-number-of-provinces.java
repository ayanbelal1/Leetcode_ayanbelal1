class Solution {
    List<List<Integer>> adj=new ArrayList<>();
    boolean []visited;

    public int findCircleNum(int[][] isConnected) {

        int n=isConnected.length;
        visited=new boolean[n];
        adj=new ArrayList<>(n);
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1&& i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int count=0;
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                q.add(i);
                visited[i]=true;

                while(!q.isEmpty()){
                    int u=q.remove();

                    for(int x:adj.get(u)){
                        if(!visited[x]){
                            q.add(x);
                            visited[x]=true;
                        }
                    }
                }
            }
        }
        return count;
    }
}