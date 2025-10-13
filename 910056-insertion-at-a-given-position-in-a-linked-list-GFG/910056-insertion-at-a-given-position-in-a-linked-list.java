/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node insertPos(Node head, int pos, int val) {
        // code here
        Node newNode = new Node(val);
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        Node temp = head;
        int count = 1;
        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            return head;
        }
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }
}