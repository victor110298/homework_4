package arrays;

class MyLinkedList implements MyList {
    public static MyLinkedList myLinkedList;

    private static int counter;
    private Node head;

    public void add(Object data) {
        if (head == null) {
            head = new Node(data);
        }

        Node temp = new Node(data);
        Node current = head;
        if (current != null) {
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(temp);
        }
        counter++;
    }


    public void add(Object data, int index) {
        Node temp = new Node(data);
        Node current = head;
        if (current != null) {
            for (int i = 0; i < index && current.getNext() != null; i++) {
                current = current.getNext();
            }
        }
        temp.setNext(current.getNext());
        current.setNext(temp);

        counter++;
    }

    public Object get(int index) {
        if (index < 0)
            return null;
        Node current = null;
        if (head != null) {
            current = head.getNext();
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return null;

                current = current.getNext();
            }
            return current.getData();
        }
        return current;

    }

    public Object remove(int index) {
        Node current = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return false;

                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());

            counter--;
            return true;

        }
        return false;
    }

    public boolean clear(){
        Node current = head;
        if (head != null) {
            for (int i = 0; i < counter; i++) {
                if (current.getNext() == null)
                    return false;
                current.setNext(current.getNext().getNext());
            }
            return true;
        }
        return false;

    }

    public int size() {
        return counter;
    }

    public String toString() {
        String output = "";

        if (head != null) {
            Node current = head.getNext();
            while (current != null) {
                output += "[" + current.getData().toString() + "]";
                current = current.getNext();
            }

        }
        return output;
    }

    private class Node {
        Node next;
        Object data;

        public Node(Object dataValue) {
            next = null;
            data = dataValue;
        }
//        public Node(Object dataValue, Node nextValue) {
//            next = nextValue;
//            data = dataValue;
//        }

        public Object getData() {
            return data;
        }

        public void setData(Object dataValue) {
            data = dataValue;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextValue) {
            next = nextValue;
        }
    }

    public static void main(String[] args) {
        myLinkedList = new MyLinkedList();
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");
        myLinkedList.add("4");
        myLinkedList.add("5");

        System.out.println("Print: myLinkedList:" + myLinkedList);
        System.out.println(".size(): " + myLinkedList.size());
        System.out.println(".get(3): " + myLinkedList.get(3) + " (get element at index:3 - list starts from 0)");
        System.out.println(".remove(2): " + myLinkedList.remove(2) + " (element removed)");
        System.out.println(myLinkedList);
        System.out.println("Remove all");
        myLinkedList.clear();
        myLinkedList.add("6");
        System.out.println(myLinkedList);
    }
}