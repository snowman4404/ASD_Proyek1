
public class testSinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        linkedList.addFirst(6);
        System.out.println(linkedList.get(2));      // menghasilkan nilai 4
        try {
            System.out.println(linkedList.get(12)); // Terjadi exception error
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index tidak valid");
        }
        System.out.println(linkedList.indexOf(4));// menghasilkan 5
        System.out.println(linkedList.indexOf(10));// menghasilkan -1
        linkedList.printReverse(); // Menghasilkan 6,5,4,3,2,1
        System.out.println(linkedList.remove(3)); // Menghasilkan True
        System.out.println(linkedList.remove(8)); // Menghasilkan False
        Object[] hasil = linkedList.toArray(); //Menghasilkan [6,5,4,3,2,1]
        System.out.print("[");
        for (int i = 0; i < hasil.length; i++) {
            System.out.print(hasil[i]);
            if (i < hasil.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");
    }
}