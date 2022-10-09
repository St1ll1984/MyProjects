import java.util.Arrays;

class QuadraticEquationSolver {
    public double[] solve(int a, int b, int c) {
        float disk = b*b - 4*a*c;
        if (disk >0) {

            double x1= (double)(-b+Math.sqrt(disk))/(2*a);
            double x2= (double)(-b-Math.sqrt(disk))/(2*a);
            if (x1>x2){
                return  new double[]{x1,x2};
            } else {
                return  new double[]{x2,x1};
            }
        } else if (disk == 0){
            return new double[]{(double)(-b+Math.sqrt(disk))/(2*a)};
        }else {
            return new double[0];
        }

    }

    public static void main(String[] args) {
        QuadraticEquationSolver ship = new QuadraticEquationSolver();



        //Should be true
        System.out.println(Arrays.toString(ship.solve(6, -78, 216)));
    }

}