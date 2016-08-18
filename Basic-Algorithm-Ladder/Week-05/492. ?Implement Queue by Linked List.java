class Node {  // 这个class是自己写的，要记得写。
    public int val;
    public Node next;
    public Node(int _val) {
        val = _val;
        next = null;
    }
}


public class Queue {
    
    public Node first, last;
    
    public Queue() {
        // do initialize if necessary
        first = last = null; // 注意这里不是 first = new Node(...); 起始状态必须是null
    }

    public void enqueue(int item) {
        // Write your code here
        Node temp = new Node(item);
        if (first == null) { // 特别注意这个判断条件如果是 'last == null' 就要把36行取消注释。
            first = temp;
            last = temp;
        } else {
            last.next = temp;
            last = temp;
        }
    }

    public int dequeue() {
        // Write your code here
        if (first == null) return -1; // 注意因为本函数的output是int，所以不存在的时候要输出-1而不是null
        int val = first.val;
        //if(last == first) last = last.next;
        first = first.next;
        return val;
    }
   
}

/*
    1. 题目中用'Linked List'以及'LinkedList'是不是不同？
    Linked List 意味着只能用Node这个class而不能用LinkedList这个class？
    2. 而且最上面class的定义中不用声明public么？是不是同文件中的class都不用加public?
    3. 滴17行中的first不能是last，是因为dequeue()中没有update last，所以可能出现first是null但last不是null的情况(只有一个节点的时候dequeue())？这可以么？
*/
