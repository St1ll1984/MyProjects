package module9;
import java.util.Arrays;
public class MyArrayList<T> {
    private final int INIT_SIZE = 5;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    public void add(T item) {
        if(pointer == array.length-1)
            resize(array.length*2); // увеличу в 2 раза, если достигли границ
        array[pointer++] = item;
    }

    public void remove(int index) {
        for (int i = index; i<pointer; i++)
            array[i] = array[i+1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length/2);
    }

    public void clear(){
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    public int size() {
        return pointer;
    }

    public T get(int index) {
        return (T) array[index];
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

     @Override
    public String toString() {
        return "MyArrayList{" +
                "INIT_SIZE=" + INIT_SIZE +
                ", CUT_RATE=" + CUT_RATE +
                ", array=" + Arrays.toString(array) +
                ", pointer=" + pointer +
                '}';
    }
}

