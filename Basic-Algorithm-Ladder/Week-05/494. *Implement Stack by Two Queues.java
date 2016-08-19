class Stack {
    
    private Queue<Integer> queue1;
    private Queue<Integer> queue2; //试试把这个Queue换成LinkedList,或把下面的LinkedList换成Queue
    
    // 这里的Queue是个interface，而LinkedList implements Queue.
    public Stack() { // 注意这里不能加 void !!
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    
    private void moveItems() {
        // 让queue1中只留下最后一个元素，以实现Stack的top()或pop()操作
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
    }
    private void swapQueues() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    
    
    // Push a new item into the stack
    public void push(int x) {
        // Write your code here
        queue1.offer(x);
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        //if (queue1.size() == 0) return;
        moveItems();
        queue1.poll(); 
        swapQueues();
        
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        //if (queue1.size() == 0) return;
        moveItems();
        int item = queue1.poll();
        swapQueues();
        queue1.offer(item);
        return item;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return queue1.isEmpty();
    }    
}


/*
    Initialization 中，必须是 Queue<Integer> queue1 = new LinkedList<Integer>(), 原因如下：
        1. 前面的Queue不能变，因为本题是要用两个Queue来实现Stack
        2. 后面的LinkedList不能改为Queue，因为Queue本身不是一个class，只是一个interface，不能产生object
    -----------------------------------------------------------------------
    熟记用queue实现stack或者用stack实现queue的思想!
*/

/*  2016-08-15
    pop() 的最后一定要 swapQueue 么？
    如果连续pop两次的话，第二次pop出来的元素岂不是第二个元素，而非倒数第二个？
    2016-08-16
    仔细看这里的 moveItems(), 每次移动元素的时候只留最后一个供 pop & top.
*/



