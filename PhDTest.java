import static org.junit.Assert.*;

import org.junit.Test;

public class PhDTest {

	@Test
	public void testConstructor1() {
		PhD Gries = new PhD("Gries", 4, 1920, 'b');
		assertEquals(Gries.name(), "Gries");
		assertEquals(Gries.month(), 4); 
		assertEquals(Gries.year(), 1920); 
		assertEquals(Gries.isMale(), true);
		assertEquals(Gries.advisor1(), null);
		assertEquals(Gries.advisor2(), null);
		assertEquals(Gries.advisees(), 0);
		
		PhD Bowen = new PhD("Bowen", 1, 1995, 'b');
		PhD Lily = new PhD("Lily", 3, 1996, 'g');
		
		Gries.setName("Lin");
		assertEquals(Gries.name(), "Lin");
		Gries.setMonth(6);
		assertEquals(Gries.month(), 6);
		Gries.setYear(1969);
		assertEquals(Gries.year(), 1969);
		Gries.setGender('g');
		assertEquals(Gries.isMale(), false);
		Gries.addAdvisor1(Bowen);
		assertEquals(Gries.advisor1(), Bowen);
		Gries.addAdvisor2(Lily);
		assertEquals(Gries.advisor2(), Lily);
		assertEquals(Lily.advisees(), 1);
	}
	
	@Test
	public void testConstructor2() {
		PhD Bowen = new PhD("Bowen", 1, 1995, 'b');
		PhD Gries = new PhD("Gries", 4, 1920, 'b',Bowen);
		assertEquals(Gries.name(), "Gries");
		assertEquals(Gries.month(), 4); 
		assertEquals(Gries.year(), 1920); 
		assertEquals(Gries.isMale(), true);
		assertEquals(Gries.advisor1(), Bowen);
		assertEquals(Gries.advisor2(), null);
		assertEquals(Bowen.advisees(), 1);
	}
	
	@Test
	public void testConstructor3() {
		PhD Bowen = new PhD("Bowen", 1, 1995, 'b');
		PhD Lily = new PhD("Lily", 3, 1996, 'g');
		PhD Gries = new PhD("Gries", 4, 1920, 'b', Bowen, Lily);
		assertEquals(Gries.name(), "Gries");
		assertEquals(Gries.month(), 4); 
		assertEquals(Gries.year(), 1920); 
		assertEquals(Gries.isMale(), true);
		assertEquals(Gries.advisor1(), Bowen);
		assertEquals(Gries.advisor2(), Lily);
		assertEquals(Bowen.advisees(), 1);
		assertEquals(Lily.advisees(),1);
	}
	
	@Test
	public void testGetFirst() {
		PhD Bowen = new PhD("Bowen", 5, 1996, 'b');
		PhD Lily = new PhD("Lily", 3, 1996, 'g');
		assertEquals(Bowen.gotFirst(Lily), true);
		PhD Bowen2 = new PhD("Bowen", 5, 1997, 'b');
		PhD Lily2 = new PhD("Lily", 3, 1996, 'g');
		assertEquals(Bowen2.gotFirst(Lily2), true);
		PhD Bowen3 = new PhD("Bowen", 3, 1996, 'b');
		PhD Lily3 = new PhD("Lily", 3, 1996, 'g');
		assertEquals(Bowen3.gotFirst(Lily3), false);
	}
	
	@Test
	public void testSiblings() {
		PhD Kevin = new PhD("Kevin", 3, 1999, 'b');
		PhD Bob = new PhD("Bob", 3, 1999, 'b');
		PhD Lily = new PhD("Lily", 3, 1996, 'g', Bob, Kevin);
		PhD Gries = new PhD("Gries", 4, 1920, 'b',Bob, Kevin);
		assertEquals(Lily.arePhDSiblings(Gries),true);
	}
	
	@Test
	public void testAssert() {
		try {new PhD("Bowen", 4, 1969, 'h'); fail("no exception thrown");}
		catch (AssertionError e) {if (e.getMessage() != null) fail();}
		try {new PhD("", 4, 1969, 'b'); fail("no exception thrown");}
		catch (AssertionError e) {if (e.getMessage() != null) fail();}
		try {new PhD("Jingyu", 13, 1969, 'b'); fail("no exception thrown");}
		catch (AssertionError e) {if (e.getMessage() != null) fail();}
	}
}
