package arrays;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
    private Object[] myStore;
    private int actSize = 0;
    private static final int DEFAUlT_CAPACITY = 10;

    public MyArrayList() {
        myStore = new Object[DEFAUlT_CAPACITY];
    }

    public T get(int index) {
        if (index < 0 || index < actSize) {
            return (T) myStore[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void add(Object obj) {
        if (myStore.length - actSize <= 5) {
            increaseListSize();
        }
        myStore[actSize++] = obj;
    }

    public T remove(int index) {
        if (index<0 || index < actSize) {
            T t= (T) myStore[index];
            myStore[index] = null;
            int tmp = index;
            while (tmp < actSize) {
                myStore[tmp] = myStore[tmp + 1];
                myStore[tmp + 1] = null;
                tmp++;
            }
            actSize--;
            return t;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void clear() {
        for (int i = 0; i < actSize; i++) {
            myStore[i] = null;
        }
        actSize = 0;
    }

    public int size() {
        return actSize;
    }

    private void increaseListSize() {
        myStore = Arrays.copyOf(myStore, myStore.length * 2);
    }

    public static void main(String a[]) {
        MyArrayList mal = new MyArrayList();
        mal.add(new Integer(2));
        mal.add(new Integer(5));
        mal.add(new Integer(1));
        mal.add(new Integer(23));
        mal.add(new Integer(14));
        for (int i = 0; i < mal.size(); i++) {
            System.out.print(mal.get(i) + " ");
        }
        System.out.println("\nMy Array after clear");
        mal.clear();
        mal.add(new Integer(29));
        mal.add(new Integer(43));
        mal.add(new Integer(52));
        System.out.println("Element at Index 1: " + mal.get(1));
        System.out.println("MyList size: " + mal.size());
        System.out.println("Removing element at index 2: " + mal.remove(1));
        for (int i = 0; i < mal.size(); i++) {
            System.out.print(mal.get(i) + " ");
        }
    }
}


