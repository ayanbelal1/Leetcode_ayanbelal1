class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        // code here
        Queue <Integer> q2=new LinkedList<>();
        int a=0;
        int size= q.size();
        for (int i=1;i<=size/2;i++){
            q2.offer(q.peek());
            q.poll();
        }
        while(!q2.isEmpty()){
            
                q.offer(q2.peek());
                
                q2.poll();
                q.offer(q.peek());
                q.poll();
                
            
        }
    }
}
