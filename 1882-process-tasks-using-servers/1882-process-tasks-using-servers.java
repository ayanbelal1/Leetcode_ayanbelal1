class Solution {
    boolean []occupied;
    int []ans;
    int n;
    int m;
    PriorityQueue<int[]>available=new PriorityQueue<>((a,b) ->{
        if(a[0]!=b[0]){
            return Integer.compare(a[0],b[0]);
        }
        return Integer.compare(a[1],b[1]);
        
    });
    PriorityQueue<int[]>busy=new PriorityQueue<>((a,b) ->{
        if(a[0]!=b[0]){
            return Integer.compare(a[0],b[0]);
        }
        if(a[1]!=b[1]){
            return Integer.compare(a[1],b[1]);
        }
        return Integer.compare(a[2],b[2]);
    });


    public int[] assignTasks(int[] servers, int[] tasks) {
        n=servers.length;
        m=tasks.length;
        ans=new int[m];

        for(int i=0;i<n;i++){
            available.offer(new int[]{servers[i],i});
        }

        for(int i=0;i<m;i++){
            
            while(busy.size()>0 && busy.peek()[0]<=i){
                int []transfer=busy.poll();
                available.offer(new int[]{transfer[1],transfer[2]});
            }

            int startTime=i;

            if(available.isEmpty()){
                int []transfer=busy.poll();

                startTime=transfer[0];
                available.offer(new int[]{transfer[1],transfer[2]});
            }
            int []av=available.poll();

            busy.offer(new int[]{startTime+tasks[i],av[0],av[1]});
            ans[i]=av[1];
        }
        return ans;
    }
}