class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<List<Integer>>adj=new ArrayList(n);

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int max=(int)-1e9;
        for(int i=0;i<n;i++){
            List<Integer>main=adj.get(i);
            int size=main.size();
            for(int j=0;j<n;j++){
                
                if(i!=j){
                    List<Integer> temp = adj.get(j);
                    int curr = temp.size() + size;

                    if (main.contains(j)) {
                        curr--;
                    }
                    max = Math.max(max, curr);
                }
            }
        }
        return max;
    }
}