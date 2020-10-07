import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author Thomas Petz
 *
 */
public class Catalog {
	//data members
	private Title[] titles;
	private int count;
	public String callNum;
	private String title;
	private String publisher;
	private int year;
	private int copies;
	private String author;
	private String ISBN;
	private int issue;
	private int month;
	
	//constructor
	/**
	 * constructor
	 */
	public Catalog() {
		titles = new Title[1000];
		count = 0;
	}
	
	/**
	 * loads the data of the library from a file
	 * @param filename: The name of the file.
	 */
	public void loadFromFile(String filename) {
		File file = new File(filename);
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("File found. Opening file...");
		while(readFile.hasNext()) {
			callNum = readFile.nextLine();
			title = readFile.nextLine();
			publisher = readFile.nextLine();
			year = Integer.parseInt(readFile.nextLine());
			copies = Integer.parseInt(readFile.nextLine());
			
			char letter = callNum.charAt(0);
			if(letter == 'B') {
				author = readFile.nextLine();
				ISBN = readFile.nextLine();
				Book b = new Book(callNum, title, publisher, year, copies, author, ISBN);
				titles[count] = b;
				count++;
			}
			
			else if(letter == 'P') {
				issue = Integer.parseInt(readFile.nextLine());
				month = Integer.parseInt(readFile.nextLine());
				Periodical p = new Periodical(callNum, title, publisher, year, copies, issue, month);
				titles[count] = p;
				count++;
			}
			
			
			
			
		}
		System.out.println("File successfully opened.");
		readFile.close();
		
	}
	
	/**
	 * saves the data from the library to the file
	 * @param filename: The name of the file
	 */
	public void saveToFile(String filename) {
		File file = new File(filename);
		PrintWriter writeFile = null;
		try {
			writeFile = new PrintWriter(file);
		}
		catch(FileNotFoundException e) {
			
		}
		for(int i = 0; i<count;i++) {
			writeFile.println(titles[i].getCallNumber());
			writeFile.println(titles[i].getTitle());
			writeFile.println(titles[i].getPublisher());
			writeFile.println(titles[i].getYear());
			writeFile.println(titles[i].getCopies());
			char letter = titles[i].getCallNumber().charAt(0);
			if(letter == 'B') { //checking if the title is a book
				writeFile.println(((Book) titles[i]).getAuthor());
				writeFile.println(((Book)titles[i]).getISBN());
			}
			else if(letter == 'P') { //checking if the title is a periodical
				writeFile.println(((Periodical)titles[i]).getIssue());
				writeFile.println(((Periodical)titles[i]).getMonth());
			}
			
		}
		writeFile.close(); //closes the file
		
		
	}
	
	/**
	 * adds a new title to the list of the titles in the library
	 * @param t: the new title
	 */
	public void addItem(Title t) {
		titles[count] = t;
		count++;
	}
	
	/**
	 * removes a title from the list of titles
	 * @param callNumber: the call number of the title to be removed
	 */
	public void removeItem(String callNumber) {
		for(int i = 0; i<count;i++) {
			if(titles[i].getCallNumber().equals(callNumber)) {
				for(int y = i; i<count; i++) {
					titles[y]=titles[y+1];
				}
				titles[i] = new Title();
				count--;
			}
		}
		
	}
	
	/**
	 * Searches from a title
	 * @param title: the title being searches
	 * @return: the list of titles with the matching title
	 */
	public Title[] searchTitle(String title) {
		int y = 0;
		int searchCount = 0;
		for(int i = 0; i<count;i++) {
			if(titles[i].getTitle().equals(title)){
				searchCount++;
			}
		}
		
		Title[] foundTitles = new Title[searchCount];
		for(int i = 0; i<count;i++) {
			if(titles[i].getTitle().equals(title)){
				foundTitles[y] = titles[i];
				y++;
			}
		}
		if(searchCount == 0) {
			System.out.println("No titles found");
		}
		
			return foundTitles;
		
	}
	
	/**
	 * Searches the list for a title with a given call number
	 * @param cn: the call number from the user
	 * @return: the title with the call number
	 */
	public Title searchCallNumber(String cn) {
	
		for(int i = 0; i < count; i++)
			if(titles[i].getCallNumber().equals(cn)) {
				Title foundTitles = titles[i];
				return foundTitles;
			}
		Title noFoundTitle = new Title();
		return noFoundTitle;
	
		
	}
	
	/**
	 * Searches for titles published in the given year
	 * @param year: The year from the user
	 * @return: the list of titles published in the given year
	 */
	public Title[] searchyear(int year) {
		int y = 0;
		int searchCount = 0;
		for(int i = 0; i<count;i++) {
			if(titles[i].getYear() == year){
				searchCount++;
			}
		}
		
		Title[] foundTitles = new Title[searchCount];
		for(int i = 0; i<count;i++) {
			if(titles[i].getYear() == year){
				foundTitles[y] = titles[i];
				y++;
			}
		}
		if(searchCount == 0) {
			System.out.println("No titles found");
		}
		
			return foundTitles;
	}
	
	/*
	 * Prints the completed list of titles
	 */
	public void viewAll() {
		System.out.println("Call Number\tTitle\t\t\t\t\t\tPublisher\tYear");
		for(int i =0; i<count; i++) {
			System.out.println(String.format("%-15s\t%-40s\t%-15s\t%-5d\t", titles[i].getCallNumber(), titles[i].getTitle(), titles[i].getPublisher(), titles[i].getYear()));
		}
		
	}

	
	

}
