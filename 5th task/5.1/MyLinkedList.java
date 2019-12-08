import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ILinkedList<E> {

    private int size = 0;

    private Node<E> head;

    private Node<E> tail;

    private final String OUT_OF_BOUNDS_MSG = "Index must be in List range";

    public MyLinkedList() {}

    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.value = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException(OUT_OF_BOUNDS_MSG);
    }

    private Node<E> getNode(int index) {
        checkElementIndex(index);
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public void add(E element) {
        final Node<E> t = tail;
        final Node<E> temp = new Node<>(t, element, null);
        tail = temp;
        if (t == null)
            head = temp;
        else
            t.next = temp;
        size++;
    }

    @Override
    public void add(int index, E element) {
        Node<E> cur = getNode(index);
        Node<E> temp = new Node<>(cur.prev, element, cur);
        if (cur == head) {
            head = temp;
        } else {
            cur.prev.next = temp;
        }
        cur.prev = temp;
        size++;
    }

    @Override
    public void clear() {
        for (Node<E> temp = head; temp != null; ) {
            Node<E> next = temp.next;
            temp.value = null;
            temp.prev = null;
            temp.next = null;
            temp = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        Node<E> cur = getNode(index);
        return cur.value;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        Node<E> temp = head;
        while (temp != null) {
            if (element.equals(temp.value)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        throw new NoSuchElementException();
    }

    @Override
    public E remove(int index) {
        Node<E> cur = getNode(index);
        E element = cur.value;
        if (cur == head) {
            head = cur.next;
            cur.next.prev = null;
        } else if (cur == tail) {
            tail = cur.prev;
            cur.prev.next = null;
        } else {
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }
        cur.value = null;
        cur.prev = null;
        cur.next = null;
        size--;
        return element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> cur = getNode(index);
        E changed = cur.value;
        cur.value = element;
        return changed;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray(E[] array) {
        if (array.length < size) {
            array = (E[]) java.lang.reflect.Array.newInstance(
                    array.getClass().getComponentType(), size);
        }

        int i = 0;
        Object[] result = array;
        for (Node<E> temp = head; temp != null; temp = temp.next) {
            result[i++] = temp.value;
        }

        if (array.length > size) {
            array[size] = null;
        }

        return array;
    }
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for(Node<E> temp = head; temp != null; temp = temp.next) {
            array[i++] = temp.value;
        }

        return array;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {

            Node<E> cur = head;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    E value = cur.value;
                    cur = cur.next;
                    return value;
                }
                return null;
            }
        };
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "size=" + size +
                ", head=" + head.value +
                ", tail=" + tail.value +
                '}';
    }
}
