package module9;
import java.util.*;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList <String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("One");
        myLinkedList.add("Two");
        myLinkedList.add("Three");
        myLinkedList.add("Four");
        myLinkedList.add("Five");
        myLinkedList.add("Six");
        myLinkedList.add("seven");
        myLinkedList.add("Eight");
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.size());
        System.out.println(myLinkedList.get(20));
//        myLinkedList.get(7);
//        myLinkedList.clear();
//        myLinkedList.remove(9);
//        MyLinkedList<String> strLl = new MyLinkedList<>();
//        strLl.add("F000");
//        strLl.get(0);
//        strLl.size();
//        strLl.clear();
    }
}

