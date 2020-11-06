public class LinkedList<E> implements List<E> {
    public int size = 0;
    Node<E> head = null;


    public class Node<E>{ //Node constructor to create LinkedList Nodes
        E data;
        Node<E> next;
        Node<E> prev;
        public Node(E val){
            data = val;
            next = null;
            prev = null;
        }
    }

    public E get(int pos){ //Get item from LinkedList
        Node<E> n = head;
        for(int i=0;i<pos;i++) {
            n = n.next;
        }
        return n.data;
    }


    public boolean add(E item){ //Add item to LinkedList
        if (head == null){
            head = new Node(item);
            ++size;
            return true;
        }

        Node<E> prev = head;

        for(int i=0;i<size-1;i++){
            prev = prev.next;
        }

        Node<E> n = new Node(item);
        prev.next = n;
        ++size;
        return true;
    }


    public void add(int pos, E item){ //Add item to LinkedList at index
        if(pos ==0) {
            Node<E> n = new Node(item);
            n.next = head;
            head = n;
            ++size;
        }
        else{
            Node<E> prev = head;
            for(int i=0;i<pos-1;i++){
                prev = prev.next;
            }
            Node<E> n = new Node(item);
            n.next = prev.next;
            prev.next = n;
            ++size;
        }

    }



    public E remove(int pos){ //Remove item from LinkedList at index
        if(pos == 0){
            Node<E> n = head;
            head = head.next;
            --size;
            return n.data;
        }
        else{
            Node prev = head;
            for(int i=0;i<pos-1;i++){
                prev = prev.next;
            }
            Node n = prev.next;
            prev.next = n.next;
            --size;
            return (E) n.data;
        }
    }




    public int size(){ //Return number of items in the LinkedList
        return size;
    }
}
