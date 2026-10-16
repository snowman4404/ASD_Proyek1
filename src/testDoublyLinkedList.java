import java.util.Arrays;
public class testDoublyLinkedList {

    public static void main(String[] args) {
      DoublyLinkedList linkedList = new DoublyLinkedList();
      linkedList.addFirst(1);
      linkedList.addFirst(2);
      linkedList.addFirst(3);
      linkedList.addFirst(4);
      linkedList.addFirst(5);
      linkedList.addFirst(6);
      System.out.println(linkedList.get(2));
      System.out.println(linkedList.get(12));
      System.out.println(linkedList.indexOf(4));
      System.out.println(linkedList.indexOf(10));
      linkedList.printReverse();
      System.out.println(linkedList.remove(3));
      System.out.println(linkedList.remove(8));
      System.out.println(Arrays.toString(linkedList.toArray()));
    }
}