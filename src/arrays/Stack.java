package arrays;

public interface Stack {
    public interface MyStack<E> {
        void push(E item);
        void remove();
        void clear();
        int size();
        E peek();
        E pop();
    }
}
