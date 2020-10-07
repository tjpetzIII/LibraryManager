/**
 * class of books while extends title
 * @author Thomas Petz
 * @version 1.0
 * Date; October 2, 2020
 */
public class Book extends Title{
	//data members
	private String author;
	private String ISBN;
	
	//constructors
	/**
	 * default constructor
	 */
	public Book() {
		super();
	}
	
	/**
	 * constructor
	 * @param cNum: call number
	 * @param t: title
	 * @param pub: publisher
	 * @param y: year
	 * @param c: copies
	 * @param a: author
	 * @param i: ISBN
	 */
	public Book(String cNum, String t, String pub, int y, int c, String a, String i) {
		super(cNum, t, pub, y, c);
		author = a;
		ISBN = i;
	}
	
	/**
	 * gets the author of the book
	 * @return: the author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Gets the ISBN of the book
	 * @return: the ISBN
	 */
	public String getISBN() {
		return ISBN;
	}
	
	/**
	 * sets the author of the book
	 * @param a: the Author
	 */
	public void setAuthor(String a) {
		author = a;
	}
	
	/**
	 * Sets the ISBN
	 * @param i: the ISBN
	 */
	public void setISBN(String i) {
		ISBN = i;
	}
	
	/**
	 * turns the data members of the book to a string
	 */
	@Override
	public String toString() {
		return getCallNumber() + "\t" + getTitle() + "\t" + getPublisher() + "\t" + getYear() + "\t" + getCopies() + "\t"+ author + "\t" + ISBN;
		
	}
	
	/**
	 * creates a formatted String of the book
	 */
	public String formattedToString() {
		return "Call Number: " +getCallNumber() +"\nTitle: " + getTitle() + "\nPublisher: " + getPublisher() + "\nYear: " + getYear() + "\nCopies: " + getCopies() + "\nAuthor: " + author + "\nISBN: " + ISBN;
	}
	
}