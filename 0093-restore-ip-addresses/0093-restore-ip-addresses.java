import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String s, int index, int parts, StringBuilder curr, List<String> res) {
       
        if (parts == 4 && index == s.length()) {
            res.add(curr.toString());
            return;
        }
        if (parts == 4 || index == s.length()) return;

        int len = curr.length();

        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String piece = s.substring(index, index + i);
            if (piece.length() > 1 && piece.charAt(0) == '0') break;

            int val = Integer.parseInt(piece);
            if (val > 255) break;

            if (len != 0) curr.append('.');
            curr.append(piece);

            backtrack(s, index + i, parts + 1, curr, res);

            curr.setLength(len); 
        }
    }
}