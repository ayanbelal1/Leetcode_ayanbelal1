class Solution {
    int n;
    int []lastSeen;
    int []result;
    TreeMap<Integer,List<Integer>> adj;

    public int[] findSubtreeSizes(int[] parent, String s) {
        n=parent.length;
        lastSeen=new int[26];
        result=new int[n];
        adj=new TreeMap<>();
        Arrays.fill(lastSeen,-1);
        Arrays.fill(result,1);
        
        for(int i=0;i<n;i++){
            if(parent[i]!=-1) adj.computeIfAbsent(parent[i],k->new ArrayList()).add(i);
        }

        solve(0,parent,s);

        return result;
    }

    private void solve(int currNode,int []parent, String s){

        char ch=s.charAt(currNode);
        int ls=ch-'a';
        int nearestAncestor=lastSeen[ls];
        lastSeen[ls]=currNode;

        for(int iterator:adj.getOrDefault(currNode,Collections.emptyList())){
            solve(iterator,parent,s);
        }

        lastSeen[ls]=nearestAncestor;
        
        if(currNode!=0){
            int newParent=parent[currNode];
            if(nearestAncestor!=-1) newParent=nearestAncestor;

            parent[currNode]=newParent;
            result[newParent]+=result[currNode];
        }
    }
}