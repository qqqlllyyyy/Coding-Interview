class Node{ // 不太明白为啥这里必须新定义一个 Node 的 class
    public int val;
    public Node prev, next;
    public Node(int _val){
        val = _val; // 这里用 this.val = _val 试试看?
        prev = next = null;
    }
}



interface InterfaceQueue {
    void push(int val);

    // define an interface for pop method
    /* write your code here */
    int pop();

    // define an interface for top method
    /* write your code here */
    int top();
}

public class MyQueue implements InterfaceQueue {
    /* you can declare your private attributes here */
    public Node first, last; // 定义第一个与最后一个点。

    public MyQueue() {
       // do initialization if necessary
    }

    // implement the push method
    /* write your code here */
    @Override
    public void push(int val) {
        if (last == null) {
            last = new Node(val);
            first = last;
        } else {
            Node node = new Node(val);
            last.next = node;
            node.prev = last;
            last = last.next;
        }
    }


    @Override
    public int pop() {
        /* write your code here */
        if (first != null) {
            int val = first.val;
            first = first.next;
            if (first != null) { // 注意这个if，要记得first.prev一定是null
                first.prev = null;
            } else { // 容易忽略，只有一个节点时，以前last=first，现在都是null了
                last = null;
            }
            return val;
        }
        return -1;
    }

    @Override
    public int top() {
        /* write your code here */
        if (first != null) return first.val;
        return -1;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue queue = new MyQueue();
 * queue.push(123);
 * queue.top(); will return 123;
 * queue.pop(); will return 123 and pop the first element in the queue
 */



/*
    注意 queue 只有三个主要命令，先入先出，可以往后增加一个(push), 只能接触到第一个点，可以获取这个点的值(top) 或者取出并去掉这个点(pop)
*/
