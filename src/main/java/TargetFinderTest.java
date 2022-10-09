import java.util.Arrays;

import static java.lang.Math.*;

public class TargetFinderTest {

    public static void main(String[] args) {
        int[] aiCoords = {10, 10};
        int[][] targets = {
                {20, 20},
                {15, 14},
                {30, 5}
        };

        TargetFinder targetFinder = new TargetFinder();
        int[] nearestTarget = targetFinder.findTarget(aiCoords, targets);

        //Expect [15, 14]
        System.out.println(Arrays.toString(nearestTarget));
    }
}
    class TargetFinder{

        public int[] findTarget(int[] aiCoords, int[][] targets){
            int startX = aiCoords[0];
            int startY = aiCoords[1];
            float minDistance = (float) sqrt(pow(targets[0][0]-startX,2)+pow(targets[0][1]-startY,2));
            int position=0;
            for (int i=0; i<=targets.length-1; i++){

                if ((float) round(sqrt(pow(targets[i][0]-startX,2)+pow(targets[i][1]-startY,2))) < minDistance){
                    minDistance =  (float) sqrt(pow(targets[i][0]-startX,2)+pow(targets[i][1]-startY,2));
                    position = i;
                }

            }
            int[] arr = {targets[position][0],targets[position][1]};

            return arr;
        }

        @Override
        public String toString() {
            return "TargetFinder{}";
        }

        static class LevelInfo {
            private String name, difficulty;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDifficulty() {
                return difficulty;
            }

            public void setDifficulty(String difficulty) {
                this.difficulty = difficulty;
            }

            public LevelInfo(String name, String difficulty) {
                this.name = name;
                this.difficulty = difficulty;
            }
        }


    }


