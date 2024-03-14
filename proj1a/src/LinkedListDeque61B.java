import java.util.LinkedList;
import java.util.List;



public class LinkedListDeque61B<T> implements Deque61B<T> {
    public static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;
        Node(T in){
            this.value = in;
        }
        Node(){}
    }

    private int size = 0;

    public Node<T> head;
    public LinkedListDeque61B(){
        head = new Node<T>();
        head.prev = head;
        head.next = head;
    }

    // PASS
    @Override
    public void addFirst(T x) {
        Node<T> newNode = new Node<T>(x);
        if(head.next == head){
            head.next = newNode;
            newNode.prev =  head;
            head.prev = newNode;
            newNode.next = head;
            size+= 1;
            return;
        }
        newNode.next = head.next;
        head.next = newNode;
        newNode.prev = head;
        size += 1;
    }
    // PASS
    @Override
    public void addLast(T x) {
        Node<T> newNode = new Node<T>(x);
        Node<T> pos = head;
        if(head.next == head){
            head.next = newNode;
            newNode.prev =  head;
            head.prev = newNode;
            newNode.next = head;
            size += 1;
            return;
        }
        while(pos.next != head && pos.next != pos){
            pos = pos.next;
        }
        pos.next = newNode;
        newNode.prev = pos;
        newNode.next = head;
        head.prev = newNode;
        size+=1;
    }

    @Override
    public List<T> toList() {
        return null;
    }


    // PASS
    @Override
    public boolean isEmpty() {
        return head.next == head;
    }

    @Override
    public int size() {
        return size;
    }
 // PASS
    @Override
    public T removeFirst() {
        Node<T> n = head.next;
        if(n.next == head) {
            head.next = head;
            head.prev = head;
            return n.value;
        }
        head.next = n.next;
        n.next.prev = head;
        size-=1;
        return n.value;
    }

    @Override
    public T removeLast() {
        Node<T> pos = head.prev;
        if(pos.prev == head) {
            head.next = head;
            head.prev = head;
            return pos.value;
        }
        T val = pos.value;
        pos.prev.next = head;
        head.prev = pos.prev;
        size -= 1;
        return val;

    }

    @Override
    public T get(int index) {
        Node<T> n = head.next;
        for(int i = 0; i < index; i++)
            n = n.next;

        return n.value;
    }
    @Override
    public T getRecursive(int index) {
        Node<T> n = head.next;
        for(int i = 0; i < index; i++){
            n = n.next;
        }
        Node<T> origin = n;
        System.out.println(n.value);
        n = n.next;
        while(n != origin){
            if(n != head)
                System.out.println(n.value);
            n = n.next;
        }


        return null;
    }
}
