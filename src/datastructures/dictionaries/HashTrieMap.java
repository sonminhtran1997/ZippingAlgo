package datastructures.dictionaries;

import java.security.Signature;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

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
		Iterator<A> it = key.iterator();
		HashTrieNode current = (HashTrieNode) this.root;
	
//		HashTrieNode addVal = new HashTrieNode(value);
		while (it.hasNext()) {
			A singleK =  it.next();
			if(!current.pointers.containsKey(singleK)) {
				current.pointers.put(singleK, new HashTrieNode());
			}
//			if (current.pointers.get(singleK) != null) {
//				current = current.pointers.get(singleK);
//			} else {
//				current.pointers.put(singleK, new HashTrieNode());
//				current = current.pointers.get(singleK);
//			}
			// keep looping down
			current = current.pointers.get(singleK);
		}
		V old = current.value;
		current.value = value;
	
		if(old==null)
			this.size++;
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
		if (key == null) {
			throw new IllegalArgumentException();
		}
		
		if (key.isEmpty() && this.root.value != null) {
			this.size--;
			this.root.value = null;
		} else {
			HashTrieNode current = (HashTrieNode) this.root;
			HashTrieNode prev = (HashTrieNode) this.root;
			A temp = null;
			Iterator<A> it = key.iterator();
			A singleK;
			while (it.hasNext()) {
				singleK = it.next();
				if (!current.pointers.containsKey(singleK)) {
					return;
				}
				if (current.value != null || current.pointers.size() > 1 || temp == null) {
					prev = current;
					temp = singleK;
				}
				current = current.pointers.get(singleK);
			}
			
			if (current.value == null) {
				return;
			}
			if (current.pointers.size() > 0) {
				current.value = null;
			} else if (current == prev) {
				current.value = null;
			} else {
				prev.pointers.remove(temp);
			}
			this.size--;
		}
	}

    @Override
    public void clear() {
        this.root = new HashTrieNode();
        this.size = 0;
    }
}
