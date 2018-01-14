package datastructures.dictionaries;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.misc.BString;
import cse332.interfaces.trie.TrieMap;

/**
 * See cse332/interfaces/trie/TrieMap.java
 * and cse332/interfaces/misc/Dictionary.java
 * for method specifications.
 */
public class HashTrieMap<A extends Comparable<A>, K extends BString<A>, V> extends TrieMap<A, K, V> {
    public class HashTrieNode extends TrieNode<Map<A, HashTrieNode>, HashTrieNode> {
        public HashTrieNode() {
            this(null);
        }

        public HashTrieNode(V value) {
            this.pointers = new HashMap<A, HashTrieNode>();
            this.value = value;
        }

        @Override
        public Iterator<Entry<A, HashTrieMap<A, K, V>.HashTrieNode>> iterator() {
            return pointers.entrySet().iterator();
        }
    }

    public HashTrieMap(Class<K> KClass) {
        super(KClass);
        this.root = new HashTrieNode();
    }

    @Override
    public V insert(K key, V value) {
		if (key == null || value == null) {
			throw new IllegalArgumentException();
		}
		Iterator it = key.iterator();
		HashTrieNode current = (HashTrieNode) this.root;
		HashTrieNode addVal = new HashTrieNode(value);
		while (it.hasNext()) {
			A singleK = (A) it.next();
			if (current.pointers.get(singleK) != null) {
				current = current.pointers.get(singleK);
			} else {
				current.pointers.put(singleK, new HashTrieNode());
				current = current.pointers.get(singleK);
			}
		}
		V old = current.value;
		current.value = value;
		return old;
    }

    @Override
    public V find(K key) {
    	if (key == null) {
			throw new IllegalArgumentException();
		}
        Iterator it = key.iterator();
        HashTrieNode current = (HashTrieNode)this.root;
        while(it.hasNext()) {
        	A singleK = (A) it.next();
        	current = current.pointers.get(singleK);
			if(current ==null) {
				return null;
			}
        }
        return 	current.value;
    }

    @Override
    public boolean findPrefix(K key) {
        if(key == null) {
        	throw new IllegalArgumentException();
        }
        Iterator it = key.iterator();
        HashTrieNode current = (HashTrieNode)this.root;
        while(it.hasNext()) {
        	A singleK = (A) it.next();
        		
        	current = current.pointers.get(singleK);
			if(current ==null) {
				return false;
			}
        }
        if (current.pointers.isEmpty()) {
			if (current.value != null) {
				return true;
			}
			return false;
		}
        return true;
    }

    @Override
    public void delete(K key) {
//    	HashTrieNode current = (HashTrieNode)this.root;
//    	Iterator it = key.iterator();
//        while(it.hasNext()) {
//        	A singleK = (A) it.next();
//        	current = current.pointers.get(singleK);
//        }
    }

    @Override
    public void clear() {
        this.root = new HashTrieNode();
    }
}
