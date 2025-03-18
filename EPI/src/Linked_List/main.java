package Linked_List;

public class main {
    public static void main(String[] args) {
//        Linkedlist linkedlist = new Linkedlist();
//        linkedlist.insertFirst(6);
//        linkedlist.insertFirst(7);
//        linkedlist.insertFirst(8);
//        linkedlist.insertFirst(9);
//        linkedlist.insertLast(10);
//        linkedlist.insertAt(3,69);
//        linkedlist.display();
//        System.out.println(linkedlist.deleteFirst());
//        linkedlist.display();
//        System.out.println(linkedlist.deleteLast());
//        linkedlist.display();
//       System.out.println(linkedlist.delete(2));
//       linkedlist.display();
//       linkedlist.find(7);
//       linkedlist.display();
//        Doubly_LinkedList dd=new Doubly_LinkedList();
//        dd.insertFirst(9);
//        dd.insertFirst(7);
//        dd.insertFirst(5);
//        dd.insertFirst(4);
//        dd.insertLast(6);
//        dd.insert(5,6);
//        dd.display();
        Circular_linkedList cl=new Circular_linkedList();
        cl.insert(10);
        cl.insert(20);
        cl.insert(30);
        cl.insert(40);
        cl.delete(20);
        cl.display();
    }
}
