
class Solution {
    int n;
    int cTime;
    int[] maxEnd;
    int[] maxIdx;

    public int videoStitching(int[][] clips, int time) {
        n = clips.length;
        cTime = time;

        if (time == 0) return 0;
        if (n == 0) return -1;

        Arrays.sort(clips, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[0],b[0]);
        });

        if (clips[0][0]!=0) return -1;

        maxEnd = new int[n];
        maxIdx = new int[n];

        maxEnd[0] = clips[0][1];
        maxIdx[0] = 0;

        for (int i = 1;i<n;i++) {
            if (clips[i][1]>maxEnd[i-1]) {
                maxEnd[i]=clips[i][1];
                maxIdx[i]=i;
            } else {
                maxEnd[i]=maxEnd[i-1];
                maxIdx[i]=maxIdx[i-1];
            }
        }

        return solve(clips);
    }

    private int solve(int[][] clips) {

        ArrayList<Integer> al=new ArrayList<>();
        al.add(clips[0][1]);

        int count=1;

        while (al.get(al.size()-1)<cTime) {

            int end=al.get(al.size()-1);

            int idx=specialLowerBound(end,clips);

            if (idx==0) return -1;

            int bestIdx =maxIdx[idx-1];

            if (clips[bestIdx][1]<=end) return -1;

            al.add(clips[bestIdx][1]);
            count++;
        }

        return count;
    }

    private int specialLowerBound(int target, int[][] clips) {

        int i= 0;
        int j =n-1;
        int ans=n;

        while (i<=j) {
            int mid=i+(j- i)/2;

            if (clips[mid][0]>target) {
                j = mid-1;
                ans = mid;
            } else {
                i=mid+1;
            }
        }

        return ans;
    }
}
