/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        if (head.next == null) {
            Node newHead = new Node(head.val);
            if (head.random != null)
                newHead.random = newHead;
            return newHead;
        }

        HashMap<Integer, Node> indexToNodeMap = new HashMap<>();
        HashMap<Node, Integer> nodeToIndexMap = new HashMap<>();

        Node newHead = new Node(head.val);
        Node curr = newHead, curr1 = head.next;
        nodeToIndexMap.put(head, 0);
        indexToNodeMap.put(0, newHead);
        int i = 1;

        while (curr1 != null) {
            curr.next = new Node(curr1.val);
            curr = curr.next;
            nodeToIndexMap.put(curr1, i);
            indexToNodeMap.put(i, curr);
            curr1 = curr1.next;
            i++;
        }

        curr = newHead;
        curr1 = head;
        while (curr1 != null) {
            if (curr1.random != null) {
                int index = nodeToIndexMap.get(curr1.random);
                Node randomNode = indexToNodeMap.get(index);
                curr.random = randomNode;
            }
            curr1 = curr1.next;
            curr = curr.next;
        }

        return newHead;
    }
}