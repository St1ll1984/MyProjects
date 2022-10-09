import java.util.Arrays;

public class ArlanHelper {

    public String drawPattern(char[] pattern, int repeatCount) {
        String result = new String();
        // int i=0;
        // while (i<pattern.length){
        //     result+=pattern[i];
        // }
        result = Arrays.toString(pattern);
        int j=1;
        while (j<repeatCount){
            result+=result;
        }
        return result;
    }

    public static void main(String[] args) {
        ArlanHelper helper = new ArlanHelper();
        //Should be:
        //JavaJavaJavaJava
        System.out.println(helper.drawPattern(new char[] {'J', 'a', 'v', 'a'}, 3));
    }

}
