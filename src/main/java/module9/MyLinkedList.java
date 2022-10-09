package module9;
import java.util.*;

public class MyLinkedList <T> {
    private int size = 0;
    private transient Node<T> first;
    private transient Node<T> last;
    private transient Node<T> linkFirst;
    private transient Node<T> linkLast;

    public void add(T elem) {
        if (size == 0) {

            first = new Node<>(first, elem, last);
            linkFirst(first);
        } else {

            Node<T> nextNode = new Node<>(first, elem, null);
            last = nextNode;
            first.setNext(last);
            first = nextNode;
            linkLast(last);
        }
        size++;
    }

    public void clear() {
        if (size != 0) {
            Node<T> elem = linkFirst;
            Node<T> elem2;
            for (int buff = 0; buff < size; buff++) {
                elem2 = elem.getNext();
                elem.prev = null;
                elem.next = null;
                elem.item = null;
                elem = elem2;
            }
            size = 0;
            linkFirst = null;
            linkLast = null;
            System.out.println("Все элементы успешно удалены");
        } else {
            System.out.println("Нет элементов в коллекции");
        }
    }

     public void size() {
        System.out.println("На текущий момент создано " + size + " элементов");
    }

     private void linkFirst(Node<T> firstLink) {
        linkFirst = firstLink;
    }

    private void linkLast(Node<T> lastLink) {
        linkLast = lastLink;
    }

    @SuppressWarnings({"ConstantConditions"})
    public void get(int index) {
        int buff = size;
        Node<T> item;
        do {
            if (index < 0) {
                System.out.println("Вы указали отрицательный индекс, так быть не может!");
                break;
            }

            if (buff / 2 >= index) {
                item = linkFirst;
                for (buff = 0; buff != index; buff++) {
                    item = item.getNext();
                }
                System.out.println(item.getItem().toString());
                break;
            }

            if (buff / 2 < index && index <= size) {
                item = linkLast;
                for (; buff - 1 != index; buff--) {
                    item = item.getPrev();
                }
                System.out.println(item.getItem().toString());
            } else {
                System.out.println("Вы вышли за границы коллекции");
            }

        } while (false);
    }

    public void remove(int index) {
        Node<T> prevNode;  // буфферная нода
        Node<T> nextNode;  // буфферная нода
        if (index < size && index >= 0) {   // первая глобальная проверка - попадает ли индекс в массив объектов
            if (index > size / 2) { // вторая проверка показывает начинаем мы обход с первого элемента или последнего
                if (index != size - 1) { // выясняем - является ли элемент самым последним в коллекции
                    Node<T> lastNode = linkLast;
                    for (int buff = size; index != (buff - 1); buff--) {
                        lastNode = lastNode.getPrev();
                    }
                    prevNode = lastNode.getPrev();
                    nextNode = lastNode.getNext();
                    prevNode.setNext(nextNode);
                    nextNode.setPrev(prevNode);
                    lastNode.allToNull();
                    size--;
                } else {
                    prevNode = linkLast.getPrev();
                    linkLast.allToNull();
                    prevNode.setNext(null);
                    linkLast = prevNode;
                    size--;
                }

            } else {
                if (index != 0) {
                    Node<T> firstNode = linkFirst;
                    for (int buff = 0; index != buff; buff++) {
                        firstNode = firstNode.getNext();
                    }
                    prevNode = firstNode.getPrev();
                    nextNode = firstNode.getNext();
                    prevNode.setNext(nextNode);
                    nextNode.setPrev(prevNode);
                    firstNode.allToNull();
                    size--;
                } else {
                    if (index != size - 1) {
                        nextNode = linkFirst.getNext();
                        nextNode.setPrev(null);
                        linkFirst = nextNode;
                        size--;
                    } else {
                        linkFirst.allToNull();
                        size--;
                    }
                }

            }
        } else {

            System.out.println("Вы вышли за границу коллекции");

        }
    }


    private static class Node<E> {

        private E item;
        private Node<E> next;
        private Node<E> prev;

        private Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        private void setNext(Node<E> next) {
            this.next = next;
        }

        private void allToNull() {
            this.item = null;
            this.next = null;
            this.prev = null;
        }

        private void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        private Node<E> getPrev() {
            return prev;
        }

        private Node<E> getNext() {
            return next;
        }

        private E getItem() {
            return item;
        }
    }
}
