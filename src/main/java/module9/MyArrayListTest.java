package module9;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList <String> myArrayList = new MyArrayList<>();
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        myArrayList.add("4");
        myArrayList.add("5");
        myArrayList.add("6");
        myArrayList.add("7");
        myArrayList.add("8");
        myArrayList.add("9");
        myArrayList.add("10");
        System.out.println(myArrayList);
        myArrayList.remove(5);
        System.out.println(myArrayList);
        myArrayList.clear();

        System.out.println(myArrayList);
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        myArrayList.add("4");
        myArrayList.add("5");

        System.out.println(myArrayList);
        System.out.println("Size " + myArrayList.size());
        System.out.println(myArrayList.get(3));

        //myArrayList.clear();
        //System.out.println(myArrayList);
    }
}
