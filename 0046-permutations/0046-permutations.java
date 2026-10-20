class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<List<Integer>> ll=new ArrayList<>();

        return solve(nums,n,0,ll);
    }

    public static List<List<Integer>> solve(int[] nums,int n,int index,List<List<Integer>> ll){

        if(index==n){ 
            List<Integer> ll2=new ArrayList<>();
            for(int x:nums){
                ll2.add(x);
            }

            ll.add(ll2);
            return ll;
        }

        for(int i=index;i<n;i++){

            swap(nums,index,i);
            solve(nums,n,index+1,ll);
            swap(nums,index,i);
        }

        return ll;
    }

    public static void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}