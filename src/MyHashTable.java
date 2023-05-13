public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

        private HashNode<K,V>[] chainArray;
        private int M = 11;
        private int size;



    public MyHashTable(){
        chainArray = new HashNode[M];
        size = 0;
    }

    public MyHashTable(int M){
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }

    private int hash(K key){
        int hash = 0;
        if(key!= null){
            hash = key.hashCode();
        }
        return hash;
    }

    public void put(K key, V value){
        int index = hash(key);
        HashNode<K,V> node = new HashNode<>(key,value);
        if (chainArray[index]==null) chainArray[index] = node;
        else{
            HashNode<K,V> temp = chainArray[index];
            while (temp.next != null){
                if(temp.key.equals(key)){
                    temp.value = value;
                    return;
                }
                temp = temp.next;
            }
            if (temp.key.equals(key)) {
                temp.value = value;
            }else {
                temp.next = node;
            }
        }
        size++;
    }

    public V get(K key){
        int index = hash(key);

    }

    public V remove(K key){}

    public boolean contains(V value){}

    public K getKey(V value){}



}
