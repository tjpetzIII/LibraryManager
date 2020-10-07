/**
 * Class of Periodical extends Title
 * @author Thomas Petz
 * @version 1.0
 * Date October 4, 2020
 */
public class Periodical extends Title{
	//data members
	private int issue;
	private int month;
	
	//constructors
	/**
	 * default constructor
	 */
	public Periodical() {
		super();
	}
	
	/**
	 * constructor
	 * @param cNum: call number
	 * @param t: title
	 * @param pub: publisher
	 * @param y: year
	 * @param c: copies
	 * @param i: issue
	 * @param m: month
	 */
	public Periodical(String cNum, String t, String pub, int y, int c, int i, int m) {
		super(cNum, t, pub, y, c);
		issue = i;
		month = m;
	}
	
	//getters
	/**
	 * gets the issue of the periodical
	 * @return: issue
	 */
	public int getIssue() {
		return issue;
	}
	
	/**
	 * gets the month of the periodical
	 * @return: month
	 */
	public int getMonth() {
		return month;
	}
	
	//setters
	/**
	 * sets the issue number for the periodical
	 * @param i: issue
	 */
	public void setIssue(int i) {
		issue = i;
	}
	
	/**
	 * sets the month of the periodical
	 * @param m: month
	 */
	public void setMonth(int m) {
		month = m;
	}
	
	/**
	 * returns the data members in a string
	 */
	@Override
	public String toString() {
		return getCallNumber() + "\t" + getTitle() + "\t" + getPublisher() + "\t" + getYear() + "\t" + getCopies() + "\t" + issue + "\t" + month;
	}
	
	/**
	 * returns a formatted string of the data members
	 */
	public String formattedToString() {
		return "Call Number: " +getCallNumber() +"\nTitle: " + getTitle() + "\nPublisher: " + getPublisher() + "\nYear: " + getYear() + "\nCopies: " + getCopies() + "\nIssue: " + issue + "\nMonth: " + month;
	}

}
