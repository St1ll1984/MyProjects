package module9;

public class MyHashMapTest {
    public static void main(String[] args) {
        ImplHashMap myHashMap = new ImplHashMap<>();
        myHashMap.put("One", "1");
        myHashMap.put("Two", "2");
        myHashMap.put("Three", "3");
        System.out.println("One " + myHashMap.get("One"));
        System.out.println("Two " + myHashMap.get("Two"));
        System.out.println("Three " + myHashMap.get("Three"));
        System.out.println("Size: " + myHashMap.size());
        myHashMap.remove("Three");
        System.out.println("Size: " + myHashMap.size());
        myHashMap.clear();
        System.out.println("Size: " + myHashMap.size());
    }
}
