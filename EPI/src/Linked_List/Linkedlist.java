package Linked_List;

public class Linkedlist {

    private Node head;
    private Node tail;

    private int size;
    public Linkedlist() {
        this.size = 0;
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

        if(tail == null) {
            tail=head;
        }
        size+=1;
    }
    public void insertLast(int data) {
        if(tail == null) {
            insertFirst(data);
        }
        Node newNode = new Node(data);
        tail.next = newNode;
        tail = newNode;
        size++;
    }


    public void insertAt(int index, int data) {
        if(index==0){
            insertFirst(data);
            return;
        }
        if(index==size){
            insertLast(data);
            return;
        }
        Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;

        }
        Node newNode = new Node(data,temp.next);
        temp.next=newNode;
        size+=1;
    }

    public int deleteFirst() {
        int value = head.data;
        head = head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return value;
    }

    public int deleteLast() {
        if(size<=1){
            return deleteFirst();
        }
        Node seondLast=get(size - 2);
        int value=tail.data;
        tail=seondLast;
        tail.next=null;
        return value;
    }
    // get the elements you want ddelete from back one
    public int delete(int index) {
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteLast();
        }
        Node prev=get(index-1);
        int value =prev.next.data;
        prev.next=prev.next.next;
        return value;
    }



    public Node get(int index) {
        Node node=head;
        for(int i=0;i<index;i++){
            node=node.next;
        }
        return node;
    }

    public Node find(int data) {
        Node node=head;
        while(node!=null){
            if(node.data==data){
             return node;
            }
            node=node.next;

        }
        return null;
    }





    public  void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("End");
    }


    private class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}
