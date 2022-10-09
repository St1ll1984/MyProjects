package module9;

public class ImplHashMap<k,v> implements ImplHashMapInterface {
    // Начальный размер емкости --- исходный код 1 << 4
    private final int DEFAULT_INITIAL_CAPACITY = 16;
    // Коэффициент загрузки
    private final float DEFAULT_LOAD_FACTOR = 0.75f;
    // В соответствии с определенным статическим внутренним классом, инициализируем связанный список, длина является длиной по умолчанию
    Node[] table = new Node[DEFAULT_INITIAL_CAPACITY];
    // длина
    private  int size = 0;

    @Override
    public int size() {
        return size;
    }
    @Override
    public void clear(){
        Node[] tab = table;
        if ((tab = table) != null && size > 0) {
            size = 0;
            for (int i = 0; i < tab.length; ++i)
                tab[i] = null;
        }
    }

    @Override
    public void remove(Object key) {
        int location = Hashing(hash(key));
        if(table[location].getKey() == key) {
            table[location] = null;
            size--;
        }
    }

     private int Hashing(int hashCode) {
        int location = hashCode % DEFAULT_INITIAL_CAPACITY;
        System.out.println("Location:"+location);
        return location;
    }
    @Override
    public Object put(Object key, Object value) {
        int hashValue = hash(key);
        int i = indexFor(hashValue,table.length);
        for(Node node = table[i];node != null; node = node.next){
            Object k;
            if(node.hash == hashValue && ((k = node.key)==key||key.equals(k))){
                Object oldValue = node.value;
                node.value = value;
                return  oldValue;
            }
        }
        addEntry(key,value,hashValue,i);
        return null;
    }

    @Override
    public Object get(Object key) {
        int hashValue = hash(key);
        int i = indexFor(hashValue,table.length);
        for(Node node = table[i];node != null;node = node.next){
            if(node.key.equals(key) && hashValue == node.hash){
                return node.value;
            }
        }
        return null;
    }

    public void addEntry(Object key,Object value,int hashValue,int i){
        if(++size >= table.length * DEFAULT_LOAD_FACTOR){
            Node[] newTable = new Node[table.length << 1];
            transfer(table,newTable);
            table = newTable;
        }
        Node eNode = table[i];
        table[i] = new Node(hashValue,key,value,eNode);
    }

    public void transfer (Node [] src, Node [] newTable) {
        int newCapacity = newTable.length;
        for (int j = 0; j <src.length; j ++) {
            Node e = src [j];
            if (e != null) {
                src [j] = null;
                do {
                    Node next = e.next;
                    int i = indexFor (e.hash, newCapacity);
                    e.next = newTable [i];
                    newTable [i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }


    public int indexFor(int hashValue,int length){
        return hashValue % length;
    }

    public int hash(Object key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static class Node implements ImplHashMapInterface.Entry{
        int hash;
        Object key;
        Object value;
        Node next;
        Node(int hash,Object key,Object value,Node next){
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }
    }
}
