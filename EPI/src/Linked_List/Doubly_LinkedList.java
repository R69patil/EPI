package Linked_List;

public class Doubly_LinkedList {

    private Node head;
    public void insertFirst(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        newNode.prev=null;
        // check null if head is null then its will not work
        if(head!=null){
            head.prev=newNode;
        }
        head=newNode;
    }
    public void display(){
        Node node=head;
        Node last=null;
        while(node!=null){
            System.out.print(node.val+"->");
            last=node;
            node=node.next;
        }
        System.out.println("End");

        while(last!=null){
            System.out.print(last.val+"->");
            last=last.prev;
        }
        System.out.println("START");
    }
    public void insertLast(int val){
        Node newNode = new Node(val);
        Node last=head;
        newNode.next=null;

        //if head is null not move forward stop
        if(head==null){
            newNode.prev=null;
            head=newNode;
            return;
        }

        //we find the last elements
        while(last.next!=null){
            last=last.next;
        }

        last.next=newNode;
        newNode.prev=last;

    }

    public Node Find(int data) {
         Node node=head;
        while(node!=null){
            if(node.val==data){
                return node;
            }
            node=node.next;

        }
        return null;
    }
    public void insert(int after, int val){
        Node p= Find(after);
        if(p==null){
            System.out.println("Element not found");
            return;
        }
        Node newNode = new Node(val);
        newNode.next=p.next;
        p.next=newNode;
        newNode.prev=p;
        if(newNode!=null){
            newNode.prev.next=newNode;
        }
    System.out.print("HEAD");
    }


    private class Node
    {
        int val;
        Node next;
        Node prev;
        public Node(int val){
            this.val = val;
        }
        public Node(int val, Node next, Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

    }
}
