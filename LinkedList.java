public class LinkedList {

    public class Node {

        private int value;
        private Node nxt;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public Node insert_singly_first(int item) {
        Node node = new Node(item);

            node.nxt = first;
            first = node;

        size++;
        return node;
    }


    public Node insert_singly(int item) {
        Node node = new Node(item);
        if (last == null) {
            first = last = node;
        }
        else {
            last.nxt = node;
            last = node;
        }
        size++;
        return node;
    }

    public void delete_s(Node node){
        Node temp = first;
        if(first == node){
            first = temp.nxt;
        }
        else{
            Node previous = getPrevious(node);
            if(previous.nxt == last) {
                previous.nxt.nxt= null;
                last = previous;
            }
            previous.nxt = node.nxt;
        }
        size--;
    }

    private Node getPrevious(Node node){
        Node current = first;

        while (current != null){

            if(current.nxt == node)
                return current;

            current = current.nxt;
        }
        return null;
    }

    public void append(LinkedList list) {
        Node node = new Node(list.first.value);

        node = list.first;
        last.nxt = node;

        for( int i = 0; i < list.size(); i++) {
            size++;
        }
    }

    public int size(){
        return size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        Node current = first;
        int index = 0;
        while (current != null){
            array[index] = current.value;
            index++;
            current = current.nxt;
        }
        return array;
    }

}
