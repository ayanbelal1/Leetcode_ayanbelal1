class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;

        HashMap<Integer,Integer>map=new HashMap<>();
        Integer[] main = new Integer[n];


        for(int i=0;i<n;i++){
            main[i]=nums[i];
            map.put(nums[i],i);
        }

        Arrays.sort(main,(a,b)->{
            int sum1=calcSum(a);
            int sum2=calcSum(b);

            return sum1!=sum2?Integer.compare(sum1,sum2):Integer.compare(a,b);
        });

        int swap=0;
        for(int i=0;i<n;i++){

            int expected=main[i];
            int curr=nums[i];

            if(expected==curr) continue;

            swap++;
            int key=map.get(expected);
            nums[i]=expected;
            nums[key]=curr;
            map.put(expected,i);
            map.put(curr,key);
        }
        return swap;
    }

    private static int calcSum(int num){

        int sum=0;
        while(num>0){
            int ext=num%10;
            sum+=ext;
            num/=10;
        }
        return sum;
    }
}