public class DoublyLinkedList {

    public class Node {

        private int value;
        private Node nxt;
        private Node prv;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public Node insert_doubly_first(int item) {
        Node node = new Node(item);

            node.nxt = first;
            first.prv = node;
            first = node;

        size++;
        return node;
    }

    public Node insert_doubly(int item) {
        Node node = new Node(item);
        if (first == null) {
            first = last = node;
            first.prv = null;
            last.nxt = null;
        }
        else {
            last.nxt = node;
            node.prv = last;
            last = node;
            last.nxt  = null;
        }
        size++;
        return node;
    }

    public void delete_d(Node node){

        if(first == node)
            first = node.nxt;

        if(last == node)
            last = node.prv;

        if(node.nxt != null)
            node.nxt.prv = node.prv;

        if(node.prv != null)
            node.prv.nxt = node.nxt;

        size--;
    }

    public int[] toArray(){
        int[] array = new int[size];
        DoublyLinkedList.Node current = first;
        int index = 0;
        while (current != null){
            array[index] = current.value;
            index++;
            current = current.nxt;
        }
        return array;
    }

}
