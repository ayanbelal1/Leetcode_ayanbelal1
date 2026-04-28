/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode temp=head;
        int n=1;
        ArrayList <Integer> arr=new ArrayList<>();
        boolean b=false;
        for (int i=1;temp.next!=null;i++){
            temp=temp.next;
            n++;
        }
        temp=head;
        if (n%2==0){
            for(int j=1;j<=n/2;j++){
                arr.add(temp.val);
                temp=temp.next;

            }

            for(int k=1;k<=arr.size();k++){
                if(arr[0]=temp.val){
                    temp=temp.next;
                    b=true;
                }
                else{
                    b=false;
                }
            }
        }
        else{
            for(int j=1;j<=n/2;j++){
                arr.add(temp.val);
                temp=temp.next;

            }

            for(int k=1;k<=arr.size();k++){
                if(arr[0]=temp.next.val){
                    temp=temp.next;
                    b=true;
                }
                else{
                    b=false;
                }
            }
        }
        
        
        return b;
    }
}