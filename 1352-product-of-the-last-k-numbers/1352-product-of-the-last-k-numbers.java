class ProductOfNumbers {
    List<Integer>list=new ArrayList<>();
    int n;
    public ProductOfNumbers() {
        list=new ArrayList<>();
        n=0;
    }
    
    public void add(int num) {
        if(list.isEmpty()){
            if(num!=0){
                list.add(num);
                n++;
            }
        }
        else{
            if(num!=0){
                list.add(list.get(n-1)*num);
                n++;
            }
            else{
                list.clear();
                n=0;
            }
        }
    }
    
    public int getProduct(int k) {

        if(k>n){
            return 0;
        }
        if(k==n) return list.get(n-1);
        int calc=list.get(n-1);
        return calc/list.get(n-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */