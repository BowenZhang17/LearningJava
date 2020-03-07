package LinkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DLLTest {
	@Test
	public void testRev() {
		DLL<Integer> methodTest1 = new DLL<Integer>();
		methodTest1.append(4);
		methodTest1.append(2);
		methodTest1.append(0);
		assertEquals("[4, 2, 0]", methodTest1.toString());
		
		DLL<Integer> b = new DLL<Integer>(); 
		assertEquals("[]", b.toString());
		assertEquals("[]", b.toStringRev());
		assertEquals(0,b.size());
	}
	
	@Test
	public void testAppend() {
		DLL<String>ll = new DLL<String>();
		ll.append("Bowen");
		assertEquals("[Bowen]", ll.toString());
		assertEquals("[Bowen]", ll.toStringRev());
		assertEquals(1,ll.size());
		
		ll.append("Lily");
		assertEquals("[Bowen, Lily]", ll.toString());
		assertEquals("[Lily, Bowen]", ll.toStringRev());
		assertEquals(2,ll.size());
		
		ll.append("Andrew");
		assertEquals("[Bowen, Lily, Andrew]", ll.toString());
		assertEquals("[Andrew, Lily, Bowen]", ll.toStringRev());
		assertEquals(3,ll.size());
	}
	
	@Test
	public void testPrepend() {
		DLL<String>ll = new DLL<String>();
		ll.prepend("Bowen");
		assertEquals("[Bowen]", ll.toString());
		assertEquals("[Bowen]", ll.toStringRev());
		assertEquals(1,ll.size());
		
		ll.prepend("Lily");
		assertEquals("[Lily, Bowen]", ll.toString());
		assertEquals("[Bowen, Lily]", ll.toStringRev());
		assertEquals(2,ll.size());
		
		ll.prepend("Andrew");
		assertEquals("[Andrew, Lily, Bowen]", ll.toString());
		assertEquals("[Bowen, Lily, Andrew]", ll.toStringRev());
		assertEquals(3,ll.size());
	}
	
	@Test
	public void testGetNode() {
		DLL<Integer> tgn = new DLL<Integer>();
		tgn.append(0);
		tgn.append(1);
		tgn.append(2);
		tgn.append(3);
		assertEquals("[0, 1, 2, 3]", tgn.toString());
		assertEquals(tgn.getNode(0).getValue(), 0);
		assertEquals(tgn.getNode(1).getValue(), 1);
		assertEquals(tgn.getNode(2).getValue(), 2);
		assertEquals(tgn.getNode(3).getValue(), 3);
	}
	
	@Test
	public void testInsertAfter() {
		DLL<Integer> tg = new DLL<Integer>();
		tg.append(0);
		DLL<Integer>.Node node1 = tg.getFirst();
		tg.insertAfter(2, node1);
		System.out.println(tg.size());
		assertEquals("[0, 2]", tg.toString());
		assertEquals("[2, 0]", tg.toStringRev());
		assertEquals(2,tg.size());
		
		tg.insertAfter(1, node1);
		assertEquals("[0, 1, 2]", tg.toString());
		assertEquals("[2, 1, 0]", tg.toStringRev());
		assertEquals(3,tg.size());
		
		DLL<Integer>.Node node2 = node1.next();
		assertEquals(node2.getValue(), 1);
		assertEquals(node2.next().getValue(), 2);
		assertEquals(node2.prev().getValue(), 0);
		assertEquals(node1.next().getValue(), 1);
		assertEquals(tg.getLast().prev(), node2);
	}
	
	@Test
	public void testInsertBefore() {
		DLL<Integer> tgn = new DLL<Integer>();
		tgn.append(2);
		DLL<Integer>.Node node1 = tgn.getLast();
		tgn.insertBefore(0, node1);
		assertEquals("[0, 2]", tgn.toString());
		assertEquals("[2, 0]", tgn.toStringRev());
		assertEquals(2,tgn.size());
		
		tgn.insertBefore(1, node1);
		assertEquals("[0, 1, 2]", tgn.toString());
		assertEquals("[2, 1, 0]", tgn.toStringRev());
		assertEquals(2,tgn.size());
		
		DLL<Integer>.Node node2 = node1.prev();
		assertEquals(node2.getValue(), 1);
		assertEquals(node2.next().getValue(), 2);
		assertEquals(node2.prev().getValue(), 0);
		assertEquals(node1.prev().getValue(), 1);
		assertEquals(tgn.getFirst().next(), node2);
	}
	
	@Test
	public void testRemove() {
		DLL<Integer> tgn = new DLL<Integer>();
		tgn.prepend(0);
		tgn.remove(tgn.getFirst());
		assertEquals(tgn.size(), 0);
		assertEquals(tgn.toString(),"[]");
		assertEquals(tgn.toStringRev(),"[]");
		
		tgn.append(0);
		tgn.append(1);
		tgn.append(2);
		tgn.append(3);
		tgn.remove(tgn.getLast());
		assertEquals(tgn.size(), 3);
		assertEquals(tgn.toString(),"[0, 1, 2]");
		assertEquals(tgn.toStringRev(),"[2, 1, 0]");
		
		tgn.remove(tgn.getLast());
		assertEquals(tgn.size(), 2);
		assertEquals(tgn.toString(),"[0, 1]");
		assertEquals(tgn.toStringRev(),"[1, 0]");
		
		tgn.append(2);
		tgn.append(3);
		tgn.remove(tgn.getFirst().next());
		assertEquals(tgn.size(), 3);
		assertEquals(tgn.toString(),"[0, 2, 3]");
		assertEquals(tgn.toStringRev(),"[3, 2, 0]");
	}
}
