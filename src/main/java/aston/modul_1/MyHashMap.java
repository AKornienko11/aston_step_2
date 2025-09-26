//package aston.modul_1;
//
//import java.util.*;
//
//public class MyHashMap<K, V> implements MayMap<K, V> {
//    private Node<K, V>[] hashTable;
//    private int size = 0;
//    private float threshold;
//
//    public MyHashMap() {
//        hashTable = new Node[16];
//        threshold = hashTable.length * 0.75f;
//    }
//
//
//    @Override
//    public boolean put(K key, V value) {
//        if (size + 1 >= threshold) {
//            threshold *= 2;
//            arrayDoubling();
//        }
//
//        Node<K, V> newNode = new Node<>(key, value);
//        int index = (hashTable.length - 1) & newNode.hash();
//        if (hashTable[index] == null) {
//            return simpleAdd(index, newNode);
//        }
//
//        List<Node<K, V>> nodeList = hashTable[index].getNodes();
//        for (Node<K, V> node : nodeList) {
//            if (keyExistButValueNew(node, newNode) || collisionProcessing(node, newNode, nodeList)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    public void arrayDoubling() {
//        Node<K, V>[] oldTable = hashTable;
//        hashTable = new Node[oldTable.length * 2];
//        size = 0;
//        for (Node<K, V> node : oldTable) {
//            if (node != null) {
//                for (Node<K, V> n : node.nodes) {
//                    put(n.key, n.value);
//                }
//            }
//        }
//    }
//
//    private boolean simpleAdd(int index, Node<K, V> newNode) {
//        hashTable[index] = new Node<>(null, null);
//        hashTable[index].getNodes().add(newNode);
//        size++;
//        return true;
//    }
//
//    public boolean keyExistButValueNew(Node<K, V> fromList, Node<K, V> newNode) {
//        if (newNode.getKey().equals(fromList.getKey()) && !(newNode.getValue().equals(fromList.getValue()))) {
//            fromList.setValue(newNode.getValue());
//            return true;
//        }
//        return false;
//    }
//
//    public boolean collisionProcessing(Node<K, V> fromList, Node<K, V> newNode, List<Node<K, V>> nodes) {
//        if (fromList.hashCode() == newNode.hashCode() &&
//                !Objects.equals(fromList.getKey(), newNode.getKey())
//                && !Objects.equals(fromList.getValue(), newNode.getValue())
//        ) {
//            nodes.add(newNode);
//            size++;
//            return true;
//        }
//        return false;
//    }
//
//
//    @Override
//    public V remove(K key) {
//        V result = null;
//        int index = hash(key);
//        if (hashTable[index] == null)
//            throw new NoSuchElementException("В коллекции нет сопоставления по указанному ключу ");
//
//        List<Node<K, V>> list = hashTable[index].getNodes();
//        for (Node<K, V> node : list) {
//            if (key.equals(node.getKey())) {
//                result = node.getValue();
//                size--;
//                list.remove(node);
//            }
//        }
//        return result;
//    }
//
//
//    @Override
//    public V get(K key) {
//        int index = hash(key);
//        if (hashTable[index] == null)
//            throw new NoSuchElementException("В коллекции нет сопоставления по указанному ключу ");
//
//        if (index < hashTable.length && hashTable[index] != null) {
//            List<Node<K, V>> list = hashTable[index].getNodes();
//            for (Node<K, V> node : list) {
//                if (key.equals(node.getKey())) {
//                    return node.getValue();
//                }
//            }
//        }
//        return null;
//    }
//
//
//    public int hash(K key) {
//        int hash = 31;
//        hash = hash * 17 + key.hashCode();
//        return hash % hashTable.length;
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//    @Override
//    public Iterator<V> iterator() {
//        return new Iterator<>() {
//            int counterArray = 0;
//            int valuesCounter = 0;
//            Iterator<Node<K, V>> subIterator = null;
//
//            @Override
//            public boolean hasNext() {
//                if (valuesCounter == size)
//                    return false;
//
//
//                if (subIterator == null || !subIterator.hasNext()) {
//                    if (moveToNextCell()) {
//                        subIterator = hashTable[counterArray].getNodes().iterator();
//                    } else {
//                        return false;
//                    }
//                }
//                return subIterator.hasNext();
//
//            }
//
//            private boolean moveToNextCell() {
//                counterArray++;
//                while (hashTable[counterArray] == null) {
//                    counterArray++;
//                }
//                return hashTable[counterArray] != null;
//            }
//
//            @Override
//            public V next() {
//                valuesCounter++;
//                return subIterator.next().getValue();
//            }
//        };
//    }
//
//    private class Node<K, V> {
//
//        private List<Node<K, V>> nodes;
//        private K key;
//        private V value;
//
//
//        private Node(K key, V value) {
//            this.key = key;
//            this.value = value;
//            nodes = new LinkedList<>();
//        }
//
//        public List<Node<K, V>> getNodes() {
//            return nodes;
//        }
//
//        public K getKey() {
//            return key;
//        }
//
//        public V getValue() {
//            return value;
//        }
//
//        public void setValue(V value) {
//            this.value = value;
//        }
//
//        private int hash() {
//            return hashCode() % hashTable.length;
//        }
//
//
//        @Override
//        public final int hashCode() {
//            int hash = 31;
//            hash = hash * 17 + key.hashCode();
//            return hash % hashTable.length;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o != null && getClass() == o.getClass()) {
//                Node<K, V> node = (Node) o;
//                return Objects.equals(key, node.getKey()) && Objects.equals(value, node.getValue());
//            }
//            return false;
//        }
//    }
//
//}
//
