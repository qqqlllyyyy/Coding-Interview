class Stack {
    
    private List<Integer> array = new ArrayList<Integer>(); // 别忘了 initialization。
    
    // Push a new item into the stack
    public void push(int x) {
        // Write your code here
        array.add(x);
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        int n = array.size();
        if (n > 0) array.remove(n - 1);
        return;
    }

    // Return the top of the stack
    public int top() { // Java的官方文档中是用 peek() 而非 top()
        // Write your code here
        int n = array.size();
        return array.get(n - 1);
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return array.size() == 0;
    }    
}

/*
    List.size();
    List.add();
    List.get();
    List.remove();
*/
