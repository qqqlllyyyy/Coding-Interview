public class Calculator {
    /**
      * @param a, b: Two integers.
      * @param operator: A character, +, -, *, /.
      */
    
    public int calculate(int a, char operator, int b){
        switch(operator){
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }
}

/*
  switch - case 语法
*/
