class Solution {
    public String destCity(List<List<String>> paths) {
        TreeMap<String, Integer> inDeg=new TreeMap<>();
        TreeMap<String, Integer> outDeg=new TreeMap<>();

        for (List<String> ll : paths) {
            outDeg.put(ll.get(0),outDeg.getOrDefault(ll.get(0),0)+ 1);
            inDeg.put(ll.get(1),inDeg.getOrDefault(ll.get(1),0)+ 1);
        }
        for (String key:inDeg.keySet()) {
            int value=outDeg.getOrDefault(key, 0);

            if (value==0) {
                return key;
            }
        }

        return "";
    }
}