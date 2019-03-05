package arrays;

import java.util.Stack;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.DEFAULT_CAPACITY;

public class MyStack<E> {
    private Object[] array;
    private int size = 0;
    private static final int DEFAUlT_CAPACITY = 10;
    private static final int CUT_RATE = 10;

    public void push(E item) {
        if (size == array.length - 1) {
            resizeArray(array.length * 2);
        }
        array[size++] = item;
    }

    public void remove() {
        if (!isEmpty()) {
            array[size--] = null;
            if (array.length > DEFAULT_CAPACITY && size < array.length / CUT_RATE) {
                resizeArray(array.length / 2);
            }
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return (E) array[size - 1];
    }

    public E pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return (E) array[--size];
    }

    private void resizeArray(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");
        stack.push("fourth");

        System.out.println(stack.size());

        System.out.println(stack.peek());
        System.out.println(stack.size());

        stack.remove();
        System.out.println(stack.size());

        System.out.println(stack.pop());
        System.out.println(stack.size());
        stack.clear();
        System.out.println(stack.size());
    }
}

