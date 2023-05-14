import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>(100);
        Random rand = new Random();
        // giving random value for keys and then putting them into bucket
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(rand.nextInt(10000));
            table.put(key,Integer.toString(i));
        }
        // showing how many buckets we have, and how many elements their consist
        System.out.println("Bucket Sizes:");
        int[] bucketSizes = table.getBucketSizes();
        for (int i = 0; i < bucketSizes.length; i++) {
            System.out.println("Bucket " + i + ": " + bucketSizes[i] + " elements");
        }

        // example of showing the elements(keys and values), according to the index of bucket
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose the bucket index:");
        int index = sc.nextInt();
        if(index>=0 && index<100){
            System.out.println("Elements in Bucket " + index + ":");
            table.printBucket(index);
        }
        else {
            System.out.println("Index out of the range");
        }

        // testing the put() method
        table.put(new MyTestingClass(500), "testValue");
        System.out.println("Value of key 500: " + table.get(new MyTestingClass(500)));

        // testing the get() method
        System.out.println("Value of key 123: " + table.get(new MyTestingClass(123)));

        // testing the remove() method
        System.out.println("Removing key 123: " + table.remove(new MyTestingClass(123)));
        System.out.println("Value of key 123 after removal: " + table.get(new MyTestingClass(123)));

        // testing the contains() method
        System.out.println("Does table contain value \"testValue\": " + table.contains("testValue"));
        System.out.println("Does table contain value \"nonExistingValue\": " + table.contains("nonExistingValue"));

        // testing the getKey() method
        System.out.println("Key of value \"testValue\": " + table.getKey("testValue"));
        System.out.println("Key of value \"nonExistingValue\": " + table.getKey("nonExistingValue"));

        // example of toString
        HashNode<Integer, String> node = new HashNode<>(1, "hello");
        String nodeString = node.toString();
        System.out.println(nodeString);
    }
}