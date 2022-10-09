
    import java.util.*;

    public class UberShop {
        public void printPrices(float[] prices) {
            for(float price: prices) {
                System.out.println(price + " jup.");
            }
        }

        public void multiplyPrices(float[] prices) {
            for (int i=0;i<=prices.length-1;i++) {
                if (prices[i]<1000){
                    prices[i] *= 2f;
                } else {
                    prices[i] *= 1.5f;
                }

            }
        }

        public int[] findMinMaxPrices(int[] prices){
            int max = -10000;
            int min = 10000;
            for (int i=0; i<prices.length; i++) {
                if (prices[i]<min){
                    min=prices[i];
                }
                if (prices[i]>max) {
                    max=prices[i];
                }
            }
            if (prices.length == 0){
                return new int[0];
            }else if (max==min) {
                return new int[]{max};
            }else if (max!=-1000 && min!=1000) {
                return new int[]{min,max};
            }
            return new int[0];
        }

        //Test output
        public static void main(String[] args) {
            UberShop shop = new UberShop();

            //Should be [50, 1500]
            int[] prices = new int[] {100, 1500, 300, 50};
            int[] minMax = shop.findMinMaxPrices(prices);
            System.out.println(Arrays.toString(minMax));
        }
    }



