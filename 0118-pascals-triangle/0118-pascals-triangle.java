class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ll=new ArrayList<>();
        ll.add(new ArrayList<>());
        ll.get(0).add(1);
        for (int i=1;i<numRows;i++){
            List <Integer> p=new ArrayList<>(ll.get (i-1));
            List <Integer> c=new ArrayList<>();
            c.add(1);
            for (int j=1;j<i;j++){
                int val=p.get(j-1)+p.get(j);
                c.add(val);
            }
            c.add(1);
            ll.add(c);
        }
        return ll;
    }
}