/** Bowen Zhang Assignment 1 /// block comments starts on next line
 * An instance maintains infor about the PhD of a person.
 * @author bowenzhang
 *
 */
/// dont use tabs, set convert tab to spaces in your editor
public class PhD {
	//Name of the person with a phD, String of length >0 /// space after double slash
	private String name;
	//In range 12 with 1 as Januar
	private int month; /// java have native date time and calendar classes, prefer built-in functionality when possible
	//Year PhD was awarded
	private int year;
	//Gender of person. 'g' for girl and 'b' for boy
	private char gender; // prefer creating an enum
	/// prefer having a List<PhD> advisors; rather than hard coding each
	/// also, it looks like you are trying to create a double edged graph of advisors, might want to look at
	/// how graphs are implemented in general
	//First PhD advisor of this person
	private PhD advisor1;
	//Second PhD advisor of this person
	private PhD advisor2;
	//Number of PhD advisees of this person
	private int advisees; /// tracking a list of PhD advisee instance would be better than the raw number
	
	/** Constructor: an instance for a person with name n, PhD month m, PhD year
	and gender g. Its advisors are unknown, and it has no advisees. 
	Precondition: n has at least 1 char. m is in 1..12. g is 'g'' for girl
	or 'b' for boy. */
	public PhD(String n, int m, int y, char g) { /// dont use single letter variable names
		assert n.length() > 0 && n != null; 
		assert m > 0 && m < 13;
		assert g == 'b' | g == 'g'; /// a single | is not 'or' but a 'bit-wise or'
		name = n;
		month = m;
		year = y;
		gender = g;
		advisor1 = null; /// these can be initialized inline
		advisor2 = null;
		advisees = 0;
		/// remove new line
	}
	
	/** Return the name of this person */
	public String name() { /// java bean convention prefers getName, getMonth, etc
		return this.name;
	}
	
	/** Return the month this person got their PhD */
	public int month() {
		return this.month;
	}
	
	/** Return the year this person got their PhD */
	public int year() {
		return this.year;
	}
	
	/** Return the year this person got their PhD */  /// copy paste error
	public boolean isMale() {
		return this.gender == 'b';
	}
	
	/** Return the value of the sentence "This person is male." */
	public PhD advisor1() {
		return this.advisor1;
	}
	
	/** Return the first advisor of this PhD (null if unknown) */
	public PhD advisor2() {
		return this.advisor2;
	}
	
	/** Return the number of PhD advisees of this person */
	public int advisees() {
		return this.advisees;
	} /// new line
	/** Set person's name to newName 
	 * Precondition: newName has at least one char */
	public void setName(String newName) {
		assert newName.length() > 0 && newName != null; /// null assertions should come before member method access
		this.name = newName;
	}
	
	/** Set person's PhD month to newMonth
	 * Precondition: newMonth is in 1..12 with 1 as January */
	public void setMonth(int newMonth) {
		assert month > 0 && month < 13;
		this.month = newMonth;
	}
	
	/** Set PhD year to newYear */
	public void setYear(int newYear) {
		this.year = newYear;
	}/// new line
	/** Set gender to newGender
	 * Precondition: newGender is a character 'b' for male and 'g' for female */
	public void setGender(char newGender) {
		assert newGender == 'b' | newGender == 'g';
		this.gender = newGender; 
	}
	
	/** Add p as the first advisor of this person. 
	 * Precondition: the first advisor is unknown and p is not null */
	public void addAdvisor1(PhD p) {
		assert this.advisor1 == null && p != null;
		this.advisor1 = p;
		p.advisees = p.advisees + 1; /// directly modifying private member of another object of the same class is frowned upon
	}
	
	/** Add p as the second advisor of this person. 
	 * Precondition: The first advisor of this person is known, the second 
	 * advisor is unknown, p is not null, and p is different from the first
	 * advisor */
	public void addAdvisor2(PhD p) {
		assert this.advisor1 != null && this.advisor2 == null 
				&& p != null && p != this;
		this.advisor2 = p; 
		p.advisees = p.advisees + 1; 
	}
	/// group constructors together
	/** Constructor: a PhD with name n, PhD month m, PhD year y, gender g, first
	 * advisor adv, and no second advisor
	 * Precondition: n has at least 1 char, m is in 1..12, g is 'g' for girl or
	 * 'b' for boy, and adv is not null. */
	public PhD(String n, int m, int y, char g, PhD adv) {
		assert n.length() > 0 && n != null; 
		assert m > 0 && m < 13;
		assert g == 'b' | g == 'g';
		assert adv != null; 
		name = n;
		month = m;
		year = y;
		gender = g;
		advisor1 = adv;
		advisor2 = null;
		advisees = 0; 
		adv.advisees = adv.advisees + 1;
	}
	
	/** Constructor: a PhD with name n, PhD month m, PhD year y, gender g, first
	 * advisor adv1, and second advisor adv2
	 * Precondition: n has at least 1 char, m is in 1..12, g is 'g' for girl or
	 * 'b' for boy, adv1 and adv2 are not null, and adv1 and adv2 are different.
	 */
	public PhD(String n, int m, int y, char g, PhD adv1, PhD adv2) {
		assert n.length() > 0 && n != null; 
		assert m > 0 && m < 13;
		assert g == 'b' | g == 'g';
		assert adv1 != null && adv2 != null;
		assert adv1 != adv2; 
		name = n;
		month = m;
		year = y;
		gender = g;
		advisor1 = adv1;
		advisor2 = adv2;
		advisees = 0; 
		adv1.advisees = adv1.advisees + 1;
		adv2.advisees = adv2.advisees + 1;
	}
	
	/** Return value of "p is not null and p got the PhD before this person."
	 */
	public boolean gotFirst(PhD p) {
		assert p != null;
		return p.year() < this.year() 
				|| ((p.year() == this.year())
				&& (p.month < this.month()));
	}
	
	/** Return value of "this person and p are intellectual siblings
	 * Precondition: p is not null.
	 */
	public boolean arePhDSiblings(PhD p) {
		assert p != null;
		/// make a helper function so these arent so stacked, this is also not very scalable
		/// see comment about using a list
		return this != p && (
				(this.advisor1() == p.advisor1() 
				&& this.advisor1() != null
				&& p.advisor1() != null)
				||
				(this.advisor1() == p.advisor2()
				&& this.advisor1() != null
				&& p.advisor2() != null)
				||
				(this.advisor2() == p.advisor1()
				&& this.advisor2() != null
				&& p.advisor1() != null)
				||
				(this.advisor2() == p.advisor2()
				&& this.advisor2() != null
				&& p.advisor2() != null));
	}
	
}
