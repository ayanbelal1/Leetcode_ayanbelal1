import java.util.*;

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stk = new Stack<>();
        int n = arr.length;

        
        for (int i = 0; i < n; i++) {
            list.add(-1);
        }

        
        for (int j = n - 1; j >= 0; j--) {
            while (!stk.isEmpty() && stk.peek() <= arr[j]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                list.set(j, stk.peek());
            } 
            stk.push(arr[j]);
        }

        return list;
    }
}
