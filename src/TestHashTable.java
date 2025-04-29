import java.util.Random;

public class TestHashTable {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(10000);
            String name = "Name" + random.nextInt(10000);
            MyTestingClass key = new MyTestingClass(id, name);
            table.put(key, i);
        }
        System.out.println();
        for (int i = 0; i < 11; i++) {
            int count = 0;
            MyHashTable<MyTestingClass, Integer>.HashNode<MyTestingClass, Integer> current = table.getChainArray()[i];
            while (current != null) {
                count++;
                current = current.next;
            }
            System.out.println( i + ": " + count + " elements");
        }

        BST<MyTestingClass, Integer> bst = new BST<>();
        int added = 0;
        for (int i = 0; i < 11 && added < 10; i++) {
            MyHashTable<MyTestingClass, Integer>.HashNode<MyTestingClass, Integer> current = table.getChainArray()[i];
            while (current != null && added < 10) {
                bst.put((MyTestingClass) current.key, current.value);
                added++;
                current = current.next;
            }
        }
        System.out.println("\n BST 10 elements:");
        for (var node : bst) {
            System.out.println("key: " + node.getKey() + " value:" + node.getValue());
        }
    }
}