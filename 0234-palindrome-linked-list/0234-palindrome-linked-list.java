class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        int n = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        
        // Count length
        while (temp.next != null) {
            temp = temp.next;
            n++;
        }
        
        temp = head;
        
        // Store first half
        for (int j = 1; j <= n / 2; j++) {
            arr.add(temp.val);
            temp = temp.next;
        }
        
        // Skip middle element if odd
        if (n % 2 != 0) {
            temp = temp.next;
        }
        
        // Compare with second half (reverse order using index)
        for (int k = arr.size() - 1; k >= 0; k--) {
            if (arr.get(k) != temp.val) {
                return false;
            }
            temp = temp.next;
        }
        
        return true;
    }
}