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
        HashNode<K, V> temp = chainArray[index];
        while(temp != null){
            if(temp.key.equals(key)){
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public V remove(K key){
        int index = hash(key);
        HashNode<K, V> temp = chainArray[index];
        HashNode<K, V> prev = null;
        while(temp != null){
            if(temp.key.equals(key)){
                if(prev == null){
                    chainArray[index] = temp.next;
                } else {
                    prev.next = temp.next;
                }
                size--;
                return temp.value;
            }
            prev = temp;
            temp = temp.next;
        }
        return null;
    }

    public boolean contains(V value){
        for(int i = 0 ; i < M ; i++){
            HashNode<K,V> temp = chainArray[i];
            while(temp != null){
                if (temp.value.equals(value)) return true;
                temp = temp.next;
            }
        }
        return false;
    }



}
