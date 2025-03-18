package Linked_List;

public class Circular_linkedList {

    Node head;
    Node tail;
    public Circular_linkedList() {
       this.head = null;
       this.tail = null;
    }
    public void insert(int val){
        Node node = new Node(val);
        if(head==null){
            head = node;
            tail = node;
        }
        tail.next = node;
        node.next = head;
        tail=node;
    }
    public void display(){
        Node node = head;
        if(head!=null){
            do{
                System.out.print(node.val+"->");
                node = node.next;
            }while(node!=head);
        }
    }
    public void delete(int val){
        Node node = head;
        if(head==null){
            return;
        }
        if(head.val==val){
            head = head.next;
            tail.next=head;
            return;
        }
        do{
            Node n=node.next;
            if(n.val==val){
                node.next=n.next;
                break;
            }
            node = n.next;
        }while(node!=head);

    }
    private class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }
}
