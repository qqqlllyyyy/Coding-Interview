public class Student {
    /**
     * Declare two public attributes name(string) and score(int).
     */
    // write your code here
    public String name;
    public int score;
    
    /**
     * Declare a constructor expect a name as a parameter.
     */
    // write your code here
    public Student(String name, int score) {
        this.name = name;
    }
    
    /**
     * Declare a public method `getLevel` to get the level(char) of this student.
     */
    // write your code here
    public char getLevel() {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 60) {
            return 'C';
        } else {
            return 'D';
        }
    }
}

/*
    ？这个 score 既不是 constructor 里的，也不作为 getLevel 的参数，是怎么来的？
*/
