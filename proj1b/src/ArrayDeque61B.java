import org.knowm.xchart.style.markers.Plus;

import java.util.List;
import java.lang.Math;

public class ArrayDeque61B<T> implements Deque61B<T> {

    final int N = 8;
    T[] elements = (T[])new Object[N];

    int head;
    int tail;

    int size;
    public ArrayDeque61B() {
        size = 0;
        head = 0;
        tail = 1;
    }

//    PASS
    @Override
    public void addFirst(T x) {
        if(x == null)
            throw new NullPointerException();
        resize();
        elements[head] = x;
        size++;
        head = minusOne(head);
    }

    // PASS
    @Override
    public void addLast(T x) {
        resize();
        elements[tail] = x;
        size++;
        tail = plusOne(tail);
    }

    @Override
    public List<T> toList() {
        return null;
    }

    @Override
    public boolean isEmpty() {
       return size == 0  ;

    }

    @Override
    public int size() {
        return size;
    }

//    PASS
    @Override
    public T removeFirst() {
        T removeItem = elements[plusOne(head)];
        head = plusOne(head);
        elements[head] = null;
        size --;
        return removeItem;
    }

//     PASS
    @Override
    public T removeLast() {
        T removeItem = elements[minusOne(tail)];
        tail = minusOne(tail);
        elements[tail] = null;
        size--;
        return removeItem;
    }

//     PASS
    @Override
    public T get(int index) {
        if(index < 0 || index >= size || isEmpty())
            return null;
        index = Math.floorMod(plusOne(head) + index, elements.length);
        return elements[index];
    }

    @Override
    public void getRecursive(int index) {

    }

    private int plusOne(int index){
        return Math.floorMod(index+1, elements.length);
    }

    private int plusOne(int index, int length) {
        return Math.floorMod(index + 1, length);
    }

    private int minusOne(int index){
        return Math.floorMod(index - 1, elements.length);
    }

    // PASS

    public void printDeque() {
        for (int index = plusOne(head); index != tail; index = plusOne(index)) {
            System.out.print(elements[index] + " ");
        }
        System.out.println();
    }


    /* Designing resize() method */
    private void resize() {
        if (size == elements.length) {
            expand();
        }
        if (size < (elements.length) * 0.25 && elements.length > 8) {
            reduce();
        }
    }

    private void expand() {
        resizeHelper(elements.length * 2);
    }

    private void reduce() {
        resizeHelper(elements.length / 2);
    }

    private void resizeHelper(int capacity) {
        T[] tempArr = elements;
        int begin = plusOne(head);
        int end = minusOne(tail);
        elements = (T[]) new Object[capacity];
        head = 0;
        tail = 1;
        for (int i = begin; i != end; i = plusOne(i, tempArr.length)) {
            elements[tail] = tempArr[i];
            tail = plusOne(tail);
        }
        elements[tail] = tempArr[end];
        tail = plusOne(tail);
    }

}
