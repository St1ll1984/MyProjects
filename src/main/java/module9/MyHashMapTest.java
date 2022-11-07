package module9;

public class MyHashMapTest {
    public static void main(String[] args) {
        ImplHashMap myHashMap = new ImplHashMap<>();
        myHashMap.put(1, "one");
        myHashMap.put(2, "two");
        myHashMap.put(2, "two two");
        myHashMap.put(3, "three");
        myHashMap.put(11, "11");
        myHashMap.put(21, "21");
        myHashMap.put(100, "100");
        myHashMap.put(101, "101");

        System.out.println(myHashMap.get(2));

        System.out.println(myHashMap.size());
        System.out.println(myHashMap.get(101));
     //   myHashMap.clear();
      //  System.out.println(myHashMap.size());
    }
}
