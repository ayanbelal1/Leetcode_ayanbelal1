class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();

        if(m>n || m==0) return "";
        
        TreeMap<Character,Integer>map=new TreeMap<>();
        for(int i=0;i<m;i++){
            char ch=t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int i=0,j=0,size=(int)1e9;
        int start=-1;
        boolean foundAll=false;
        while(j<n){
            char ch=s.charAt(j);

            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
            }

            if(j-i+1>=m){
                foundAll=true;
                for(Map.Entry<Character,Integer> entry:map.entrySet()){
                    if(entry.getValue()>0){
                        foundAll=false;
                        break;
                    }
                }
                if(foundAll){
                    while(foundAll){
                        if(j-i+1<size){
                            size = j - i + 1;
                            start = i;
                        }
                        char findNext=s.charAt(i);
                        if(map.containsKey(findNext)){
                            map.put(findNext, map.get(findNext) + 1);
                            if (map.get(findNext) > 0) {
                                foundAll = false;
                            }
                        }
                        i++;
                    }
                }
            }

            j++;
        }
        if (start==-1) return "";
        return s.substring(start, start + size);
    }
}