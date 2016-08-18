public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
       // do initialization if necessary
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>(); // 别忘了这两步 initialization
    }
    
    public void push(int element) {
        // write your code here
        stack2.push(element);
    }

    public int pop() {
        // write your code here
        if (stack1.empty() == true) {
			this.stack2ToStack1();
		}
        return stack1.pop();
    }

    public int top() {
        // write your code here
        if (stack1.empty() == true) {
			this.stack2ToStack1();
		}
        return stack1.peek();
    }
    
    
    private void stack2ToStack1(){
        while (!stack2.empty()) { // 注意这里不是'isEmpty()'
            stack1.push(stack2.pop());
        }
    }
}

/*
    只有 stack1 空的时候才从 stack2 里往 stack1 里倾倒。
*/
