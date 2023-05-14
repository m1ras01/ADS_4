public class MyHashTable<K, V> {
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
            hash = key.hashCode() % M;
        }
        return hash;
    }

    public void put(K key, V value){
        int index = hash(key);
        HashNode<K,V> node = new HashNode<>(key,value);
        if (chainArray[index]==null) chainArray[index] = node;
        else{
            HashNode<K,V> temp = chainArray[index];
            while (temp.getNext() != null){
                if(temp.getKey().equals(key)){
                    temp.setValue(value);
                    return;
                }
                temp = temp.getNext();
            }
            if (temp.getKey().equals(key)) {
                temp.setValue(value);
            }else {
                temp.setNext(node);
            }
        }
        size++;
    }

    public V get(K key){
        int index = hash(key);
        HashNode<K, V> temp = chainArray[index];
        while(temp != null){
            if(temp.getKey().equals(key)){
                return temp.getValue();
            }
            temp = temp.getNext();
        }
        return null;
    }

    public V remove(K key){
        int index = hash(key);
        HashNode<K, V> temp = chainArray[index];
        HashNode<K, V> prev = null;
        while(temp != null){
            if(temp.getKey().equals(key)){
                if(prev == null){
                    chainArray[index] = temp.getNext();
                } else {
                    prev.setNext(temp.getNext());
                }
                size--;
                return temp.getValue();
            }
            prev = temp;
            temp = temp.getNext();
        }
        return null;
    }

    public boolean contains(V value){
        for(int i = 0 ; i < M ; i++){
            HashNode<K,V> temp = chainArray[i];
            while(temp != null){
                if (temp.getValue().equals(value)) return true;
                temp = temp.getNext();
            }
        }
        return false;
    }

    public K getKey(V value){
        for (int i = 0 ; i < M ;i++){
            HashNode<K,V> temp = chainArray[i];
            while (temp != null){
                if (temp.getValue().equals(value)) return temp.getKey();
                temp = temp.getNext();
            }
        }
        return null;
    }


}
