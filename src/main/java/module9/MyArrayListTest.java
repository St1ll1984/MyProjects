package module9;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList <String> myArrayList = new MyArrayList<>();
        myArrayList.add("0lk");
        myArrayList.add("1uj");
        myArrayList.add("2df");
        myArrayList.add("3sdsd");
        myArrayList.add("4sds");
        myArrayList.add("5ggfd");
        System.out.println(myArrayList);

        myArrayList.remove(3);
        System.out.println(myArrayList);

        System.out.println("Size " + myArrayList.size());

        System.out.println(myArrayList.get(3));

        myArrayList.clear();
        System.out.println(myArrayList);
    }
}
