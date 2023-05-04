import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int n = 5;
        int k = 15;
        int measurements = 5;

        long average_doubly;
        long average_singly;
        long sum_doubly = 0;
        long sum_singly = 0;
        Random rnd = new Random();

        DoublyLinkedList doubly_list = new DoublyLinkedList();
        LinkedList singly_list = new LinkedList();

        for (int mes = 0; mes < measurements; mes++) {

            DoublyLinkedList.Node[] doubly_array = new DoublyLinkedList.Node[n];
            LinkedList.Node[] singly_array = new LinkedList.Node[n];

            int[] sequence = new int[k];
            for(int i = 0; i < k; i++){
                sequence[i] = rnd.nextInt(n);
            }

            sum_doubly = 0;
            sum_singly = 0;

            for (int l = 0; l < 1000; l++) {

                doubly_list = new DoublyLinkedList();
                singly_list = new LinkedList();

                for (int i = 0; i < n; i++){
                    doubly_array[i] = doubly_list.insert_doubly(i);
                    singly_array[i] = singly_list.insert_singly(i);
                }

                long t0_doubly = System.nanoTime();
                for (int op = 0; op < k; op++) {
                    doubly_list.delete_d(doubly_array[sequence[op]]);
                    doubly_array[sequence[op]] = doubly_list.insert_doubly_first(sequence[op]);
            }
                long t1_doubly = System.nanoTime();
                sum_doubly += (t1_doubly - t0_doubly);


                long t0_singly = System.nanoTime();
                for (int op = 0; op < k; op++) {
                    singly_list.delete_s(singly_array[sequence[op]]);
                    singly_array[sequence[op]] = singly_list.insert_singly_first(sequence[op]);
            }
                long t1_singly = System.nanoTime();
                sum_singly += (t1_singly - t0_singly);

            }


            //n += 5;
            n *= 2;
            //System.out.println(n);

            int[] dlist_array = doubly_list.toArray();
            System.out.println("Doubly List : " + Arrays.toString(dlist_array));
            int[] slist_array = singly_list.toArray();
            System.out.println("Singly List : " + Arrays.toString(slist_array));

           /* average_doubly = sum_doubly / 1000;
            average_singly = sum_singly / 1000;
            System.out.println((average_singly)+"        "+(average_doubly));*/
        }
    }
}
