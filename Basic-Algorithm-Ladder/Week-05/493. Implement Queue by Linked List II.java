class Node {
    public int val;
    public Node prev, next;
    public Node(int _val) {
        val = _val;
        prev = next = null;
    }
}

public class Dequeue {
    public Node first, last;
    
    public Dequeue() {
        // do initialize if necessary
        first = last = null;
    }

    public void push_front(int item) {
        // Write your code here
        if (first == null) {
            last = new Node(item);
            first = last;
        } else {
            Node temp = new Node(item);
            first.prev = temp; // 别忘了还要更新first的prev
            temp.next = first;
            first = first.prev; // 最后还要更新first
        }
    }

    public void push_back(int item) {
        // Write your code here
        if (last == null) { // 这里检查first==null可以么
            last = new Node(item);
            first = last;
        } else {
            Node temp = new Node(item);
            last.next = temp;
            temp.prev = last;
            last = last.next;
        }
    }

    public int pop_front() {
        // Write your code here
        if (first != null) {
            int item = first.val;
            first = first.next;
            if (first != null) {
                first.prev = null;
            } else {
                last = null; // 不要忘记update last，如果以前总共只有一个node
            }
            return item;
        } else {
            return -1;
        }
    }

    public int pop_back() {
        // Write your code here
        if (last != null) {
            int item = last.val;
            last = last.prev;
            if (last != null) {
                last.next = null;
            } else {
                first = null;
            }
            return item;
        } else {
            return -1;
        }
    }
}

/*
    做和front有关的操作时，检查(first == null), 做和end有关的操作时，就检查(last == null)
*/
