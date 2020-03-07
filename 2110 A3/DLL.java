package LinkedList;
/* Time spent on a3:  03 hours and 20 minutes.
 *
 * When you change the above, please do it carefully. Change hh to
 * the hours and mm to the minutes and leave everything else as is.
 * If the minutes are 0, change mm to 0. This will help us in
 * extracting times and giving you the average and max.
 * 
 * Name: Bowen Zhang
 * Netid: 
 * What I thought about this assignment: Neat
 *
 *
 */

/** An instance is a doubly linked list. */
public class DLL<E> {
    private int size;   // Number of values in the linked list.
    private Node first; // first node of linked list (null if none)
    private Node last;  // last node of linked list (null if none)
    
    /** Constructor: an empty linked list. */
    public DLL() {
    }

    /** Return the number of values in this list.
     *  This function takes constant time. */
    public int size() {
        return size;
    }

    /** Return the first node of the list (null if the list is empty). */
    public Node getFirst() {
        return first;
    }

    /** Return the last node of the list (null if the list is empty). */
    public Node getLast() {
        return last;
    }

    /** Return the value of node n of this list.
     * Precondition: n is a node of this list; it may not be null. */
    public E valueOf(Node n) {
        assert n != null;
        return n.val;
    }
    
    /** Return a representation of this list: its values, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * Takes time proportional to the length of this list.<br>
     * E.g. for the list containing 6 3 8 in that order, the result it "[6, 3, 8]". */
    public String toString() {
        String res= "[";
        Node n= first;
        // inv: res contains values of nodes before node n (all of them if n = null),
        //      with ", " after each (except for the last value)
        while (n != null) {
            res= res + n.val;
            n= n.next;
            if (n != null) {
                res= res + ", ";
            }
        }

        return res + "]";
    }

    /** Return a representation of this list: its values in reverse, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * Takes time proportional to the length of this list.
     * E.g. for the list containing 6 3 8 in that order, the result is "[8, 3, 6]".
     * E.g. for the list containing ""  "" in that order, the result is "[ , ]". */
    public String toStringRev() {
        //TODO 1. Look at toString to see how that was written.
        //        Use the same sort of scheme. Extreme case to watch out for:
        //        E is String and value are the empty string.
        //        You can't test this fully until #2, append, is written.
    	String res = "["; 
    	Node n = last;
    	//inv: res contains values of nodes after node n (all of them if n = null),
    	//		with ", " after each (except for the last value)
    	while (n != null) {
    		res = res + n.val;
    		n = n.prev;
    		if (n != null) {
    			res = res + ", ";
    		}
    	}
        return res + "]";
    }

    /** add value v in a new node at the end of the list.
     *  This operation takes constant time. */
    public void append(E v) {
        //TODO 2. After writing this method, test this method and
        //        toStringRev thoroughly before starting on the next
        //        method. These two must be correct in order to be
        //        able to write and test all the others.
    	//If DLL has one node, set onlyNode as both the first and last node 
    	// with value v
    	if (last == null) {
    		first = new Node(null, null, v); 
    		last = first; 
        	}
    	else {
    		last.next = new Node(last, null, v);
    		last = last.next; 
    	}
    	size++; 
    }

	/** Add value v in a new node at the beginning of the list.
     * This operation takes constant time. */
    public void prepend(E v) {
        //TODO 3. 
    	if (first == null) {
        	first = new Node(null, null, v);
        	last = first; 
        }
        else {
        	first.prev = new Node(null, first, v);
        	first = first.prev;
        }
        size ++;
    }
    
    /** Return node number k. 
     *  Precondition: 0 <= k < size of the list.
     *  Example. Suppose list is [8, 6, 7].
     *  If k is 0, return first node; if k = 1, return second node, ... */
    public Node getNode(int k) {
        //TODO 4. This method should take time proportional to min(k, size-k).
        // For example, if k <= size/2, search from the beginning of the
        // list, otherwise search from the end of the list.
        assert k >= 0 && k < this.size;
        if (k <= this.size/2) {
        	Node nodeK = this.getFirst();
        	//set nodeK equal to the next node starting from node first
        	for (int i = 0; i < k; i++) {
        		nodeK = nodeK.next;
        	}
        	return nodeK;
        }
        else {
        	Node nodeK = this.getLast();
        	//set nodeK equal to the previous node starting from node last
        	for (int i = 0; i < this.size - k-1; i++) {
        		nodeK = nodeK.prev;
        	}
        	return nodeK;
        }
    }

    /** Insert value v in a new node after node n.
     * This operation takes constant time.
     * Precondition: n must be a node of this list; it may not be null. */
    public void insertAfter(E v, Node n) {
        //TODO 5. Make sure this method takes constant time. 
    	assert (n!= null) && (this.size > 0);
    	if (n == last) {
    		this.append(v);
    	}
    	else {
    		Node nodeV = new Node(n, n.next, v);
    		n.next().prev = nodeV;
    		n.next = nodeV;
    		size++;
    	}   
    }
    
    /** Insert value v in a new node before node n.
     * This operation takes constant time.
     * Precondition: n must be a node of this list; it may not be null. */
    public void insertBefore(E v, Node n) {
        //TODO 6. Make sure this method takes constant time. 
    	assert (n!= null) && (this.size > 0);
    	if (n == first) {
    		this.prepend(v);
    	}
    	else {
    		Node nodeV = new Node(n.prev, n, v);
    		n.prev().next = nodeV;
    		n.prev = nodeV;
    		size++;
    	}   
    
    }

    /** Remove node n from this list.
     * This operation must take constant time.
     * Precondition: n must be a node of this list; it may not be null. */
    public void remove(Node n) {
        //TODO 7. Make sure this method takes constant time. 
    	assert (n!= null) && (this.size> 0);
    	if (this.size() == 1) {
    		first = null;
    		last = null;
    	}
    	else if (n == first) {
    		first = n.next;
    		first.prev = null;
    	}
    	else if (n == last) {
    		last = n.prev;
    		last.next = null; 
    	}
    	else {
    		n.next().prev = n.prev(); 
    		n.prev().next = n.next();
    	}
    	n = null; 
    	size--;
    } 
    
    /*********************/

    /** An instance is a node of this list. */
    public class Node {
        private Node prev; // Previous node on list (null if this is first node)
        private E val;   // The value of this element
        private Node next; // Next node on list. (null if this is last node)

        /** Constructor: an instance with previous node p (can be null),
         * next node n (can be null), and value v. */
        Node(Node p, Node n, E v) {
            prev= p;
            next= n;
            val= v;
        }

        /** Return the value of this node. */
        public E getValue() {
            return val;
        }
        
        /** Return the node previous to this one (null if this is the
         * first node of the list). */
        public Node prev() {
            return prev;
        }

        /** Return the next node in this list (null if this is the
         * last node of this list). */
        public Node next() {
            return next;
        }
    }

}
