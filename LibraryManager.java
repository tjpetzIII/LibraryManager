
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Manages the library using the classes of Catalog, Title, Book, and Periodical
 * @author Thomas Petz
 * @version 1.0
 * Date October 4, 2020
 *
 */
public class LibraryManager {
	public static void main(String[] args) {
		Catalog myLibary = new Catalog();
		myLibary.loadFromFile("titles.txt");
		Scanner keyboard = new Scanner(System.in);
		int operation = 0;
		String callNumSearch;
		String titleSearch;
		int searchYear;
		int yearCount = 0;
		int titleCount = 0;
		
		do {
			printMenu();
			operation = keyboard.nextInt();
			switch(operation) {
			case 1: //find title
				try {
				System.out.println("Enter Call Number: ");
				keyboard.nextLine();
				callNumSearch = keyboard.nextLine();
				checkCallNumber(callNumSearch);
				Title foundCallNumber = myLibary.searchCallNumber(callNumSearch);
				if(foundCallNumber.getCallNumber() != null) {
					System.out.println(foundCallNumber.formattedToString());
				}
				else {
					System.out.println("Title not found");
				}
				
				}
				catch(InvalidCallNumber e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 2: //search by title
				try {
					System.out.println("Enter a title:");
					keyboard.nextLine();
					titleSearch = keyboard.nextLine();
					if(myLibary.searchTitle(titleSearch).length != 0) {
						Title[] foundTitle = myLibary.searchTitle(titleSearch);
						System.out.println("List of titles found: " + foundTitle.length);
						printTitle(foundTitle);
					}
					
				}
				catch(InputMismatchException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3: //search by year
				try {
					System.out.println("Enter a year: ");
					keyboard.nextLine();
					searchYear = keyboard.nextInt();
					checkDate(searchYear);
					Title[] foundYear = myLibary.searchyear(searchYear);
					printTitle(foundYear);
					
				}
				catch(InvalidDate e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4: //add title
				try {
					System.out.println("Enter the title:");
					keyboard.nextLine();
					String title = keyboard.nextLine();
					System.out.println("Enter the publisher: ");
					String publisher = keyboard.nextLine();
					System.out.println("Enter year of publication:");
					int year = keyboard.nextInt();
					System.out.println("Enter the number of copies:");
					int copies = keyboard.nextInt();
					System.out.println("Enter type of title (book/periodical):");
					keyboard.nextLine();
					String type = keyboard.nextLine();
					if(type.equals("book")) {
						System.out.println("Enter the call number (B-ddd-ddd-ddd):");
						String callNum = keyboard.nextLine();
						checkCallNumber(callNum);
						System.out.println("Enter the author:");
						String author = keyboard.nextLine();
		 				System.out.println("Enter ISBN (10 digits):");
						String isbn = keyboard.nextLine();
						Book newBook = new Book(callNum,title,publisher,year,copies,author,isbn);
						myLibary.addItem(newBook);
						
					}
					else if(type.equals("periodical")) {
						System.out.println("Enter the call number (P-ddd-ddd-ddd):");
						String callNum = keyboard.nextLine();
						checkCallNumber(callNum);
						System.out.println("Enter the issue: ");
						int issue = keyboard.nextInt();
						System.out.println("Enter the month:");
						int month = keyboard.nextInt();
						checkMonth(month);
						Periodical newPeriod = new Periodical(callNum, title, publisher, year, copies, issue, month);
						myLibary.addItem(newPeriod);
					}
				}
				catch(InvalidCallNumber e) {
					System.out.println(e.getMessage());
				}
				catch(InvalidDate e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 5: //remove title
				try {
					System.out.println("Enter the call number (B-ddd-ddd-ddd)");
					keyboard.nextLine();
					String callNum = keyboard.nextLine();
					checkCallNumber(callNum);
					myLibary.removeItem(callNum);
					
				}
				catch(InvalidCallNumber e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6: //view all titles
				myLibary.viewAll();
				break;
			case 7: //exit
				myLibary.saveToFile("titles.txt");
				break;	
			}
		}while(operation !=7);
		}
	
	/**
	 * Prints the menu of options
	 */
	public static void printMenu() {
		System.out.println("\nSelect an Operation");
		System.out.println("1: Find Title");
		System.out.println("2: Search by Title");
		System.out.println("3: Search by Year");
		System.out.println("4: Add Title");
		System.out.println("5: Remove Title");
		System.out.println("6: View All Titles");
		System.out.println("7: Exit");
	}
	
	/**
	 * Checks the call number that the user entered
	 * @param callNum: the entered call number
	 * @throws InvalidCallNumber: the exception for an invalid call number
	 */
	public static void checkCallNumber(String callNum) throws InvalidCallNumber {
		if(!(callNum.matches("B-\\d{3}-\\d{3}-\\d{3}")) && !(callNum.matches("P-\\d{3}-\\d{3}-\\d{3}"))) {
			throw new InvalidCallNumber("Invalid Call Number. Must be B-ddd-ddd-ddd or P-ddd-ddd-ddd");
		}
	}
	
	/**
	 * Prints the list of titles
	 * @param titles: the list of titles
	 */
	public static void printTitle(Title[] titles) {
		if(titles.length != 0) {
		System.out.println("Call Number\tTitle\t\t\t\t\t\tPublisher\tYear");
		for(int i =0; i<titles.length; i++) {
			System.out.println(String.format("%-15s\t%-40s\t%-15s\t%-5d\t", titles[i].getCallNumber(), titles[i].getTitle(), titles[i].getPublisher(), titles[i].getYear()));
		}
		}
	}
	
	/**
	 * checks the year the user enter
	 * @param year: the entered year
	 * @throws InvalidDate: the exception for an invalid date
	 */
	public static void checkDate(int year) throws InvalidDate {
		if(year < 1900 || year > 2020) {
			throw new InvalidDate("Invalid year. Must be between 1900 and 2020.");
		}
	}
	
	/**
	 * Checks for a valid month entered
	 * @param month: the entered month
	 * @throws InvalidDate: the exception for an invalid date
	 */
	public static void checkMonth(int month) throws InvalidDate{
		if(month < 1 || month > 12) {
			throw new InvalidDate("Invalid month. Must be between 1 and 12");
		}
	}
	
	
			


		
		
		
		

}

