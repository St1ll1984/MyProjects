import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class DistanceTest {


        public static void main(String[] args) {
            //Expect 14
            System.out.println(new Distance(36, 25, 2, -28).getDistance());

            //Expect 23
            System.out.println(new Distance(10, 10, 27, 25).getDistance());
        }
    }

    class Distance {

        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Distance(int startX, int startY, int endX, int endY){

            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        public int getDistance(){
            return (int) sqrt(pow((startY-startX),2)+pow((endY-endX),2));
        }



        @Override
        public String toString() {
            return "Distance{" +
                    "startX=" + startX +
                    ", startY=" + startY +
                    ", endX=" + endX +
                    ", endY=" + endY +
                    '}';
        }
    }

