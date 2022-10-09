package module9;

public interface ImplHashMapInterface<k,v>{
    //Добавить пару ключ + значение
    Object put(Object key,Object value);
    //Удалить пару по ключу
    void remove(Object key);
    //Очистить колекцию
    void clear();
    // размер
    int size();
    //Получить элементы на основе ключа
    Object get(Object key);

    // Внутренний интерфейс
    interface Entry<k,v>{
        k getKey();
        v getValue();
    }

}
