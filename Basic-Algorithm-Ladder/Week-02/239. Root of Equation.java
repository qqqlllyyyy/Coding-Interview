public class Solution {
    /**
     * @param a, b, c: parameters of the equation
     * @return a double array, contains at most two root
     */
    public double[] rootOfEquation(double a, double b, double c) {
        // Write your code here
        double delta2 = b * b - 4 * a * c;
        
        if (delta2 < 0){
            double[] result = new double[0];
            return result;
        }
        
        else if (delta2 == 0) {
            double[] result = new double[1];
            result[0] = -b / 2.0 / a;
            return result;
        }
        
        else {
            double[] result = new double[2];
            double delta = Math.sqrt(delta2);
            
            result[0] = (-b - delta) / 2.0 / a;
            result[1] = (-b + delta) / 2.0 / a;
            
            if (result[0] > result[1]) {
                double temp = result[0];
                result[0] = result[1];
                result[1] = temp;
            }
            return result;
        }
        
    }
}

/*
    ***: ‘return result’ 这句话必须各自写在三种情况的里面，因为 'result' 是在 if 语句中声明的，其 life cycle 只在大括号中，这与 scripting language 都不同，格外注意！
*/
