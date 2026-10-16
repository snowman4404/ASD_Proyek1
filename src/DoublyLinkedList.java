public class DoublyLinkedList implements LinkedList {
    private Node2P head, tail;
    int size = 0;

    public DoublyLinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void addFirst(Object inputData) {
        Node2P baru = new Node2P(inputData);
        if (isEmpty()) {
            head = baru;
            tail = baru;
            size++;
        } else {
            baru.next = head;
            head.prev = baru;
            head = baru;
            size++;
        }
    }

    public void addLast(Object inputData) {
        Node2P baru = new Node2P(inputData);
        if (isEmpty()) {
            head = baru;
            tail = baru;
            size++;
        } else {
            tail.next = baru;
            baru.prev = tail;
            tail = baru;
            size++;
        }
    }

    public void addAfter(int index, Object inputData) {
        if (index < 0 || index >= size) {
            System.out.println("Index di luar batas list!");
            return;
        }

        if (index == size - 1) {
            addLast(inputData);
            return;
        }

        Node2P baru = new Node2P(inputData);
        Node2P temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        baru.prev = temp;
        baru.next = temp.next;
        temp.next.prev = baru;
        temp.next = baru;
        size++;
    }

    public void deleteFirst() {
        if (!isEmpty()) {
            Node2P temp = head;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
                temp.next = null;
            }
            size--;
        } else {
            System.out.println("List kosong!");
        }
    }

    public void deleteLast() {
        if (!isEmpty()) {
            Node2P temp = tail;
            if (tail == head) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
                temp.prev = null; // Memutus referensi garbage collector
            }
            size--;
        } else {
            System.out.println("List kosong!");
        }
    }

    public void deleteAfter(int index) {
        if (index < 0 || index >= size - 1) {
            System.out.println("Index tidak valid atau tidak ada elemen setelah index tersebut");
            return;
        }

        if (index == size - 2) {
            this.deleteLast();
        } else {
            Node2P temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            Node2P nodeToDelete = temp.next;
            temp.next = nodeToDelete.next;
            nodeToDelete.next.prev = temp;
            nodeToDelete.next = null;
            nodeToDelete.prev = null;
            size--;
        }
    }

    public void print() {
        Node2P currentNode = head;
        for (int i = 0; i < size; i++) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node2P current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public int indexOf(Object targetData) {
        Node2P current = head;
        int index = 0;
        while (current != null) {
            if ((targetData == null && current.data == null) ||
                    (targetData != null && targetData.equals(current.data))) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public void printReverse() {
        Node2P currentNode = tail;
        while (currentNode != null) {
            System.out.print(currentNode.data);
            if (currentNode.prev != null) {
                System.out.print(", ");
            }
            currentNode = currentNode.prev;
        }
        System.out.println();
    }

    @Override
    public boolean remove(Object targetData) {
        if (isEmpty()) {
            return false;
        }

        Node2P current = head;
        while (current != null) {
            if ((targetData == null && current.data == null) ||
                    (targetData != null && targetData.equals(current.data))) {

                if (current == head) {
                    deleteFirst();
                } else if (current == tail) {
                    deleteLast();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    current.next = null;
                    current.prev = null;
                    size--;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node2P current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }
}