package A2;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class Main {
	
	//member list, used throughout method
	public static ArrayList<Member> member_list = new ArrayList<>();
	
	//getter for member list
	public static ArrayList<Member> getmemberList() {
		return member_list;
	}
	
	//book list, used throughout method
	public static ArrayList<Book> book_list = new ArrayList<>();
	
	//getter for book list
	public static ArrayList<Book> getbookList() {
		return book_list;
	}

	public static void main(String[] args) throws Exception {

		//connect to and read files
		String file1 = "src/a2/members";
		String file2 = "src/a2/books";
		
		try {
			//load file reader
			BufferedReader reader = new BufferedReader(new FileReader(file1));
			
			String line = reader.readLine();
			
			//while line is not empty
			while (line != null) {
				
				String[] values = line.split(",");
				
				//member object
				Member member = new Member(values[0],values[1],values[2],Integer.parseInt(values[3]));
				member_list.add(member);
				
				//read next line
				line = reader.readLine();
			}
			
			reader.close();
			System.out.println("Member File read successfully.\n");
			
		} catch (Exception e) {
			System.out.println("Error, file not accessed.");
		}
		
		try {
			//load file reader
			BufferedReader reader = new BufferedReader(new FileReader(file2));
			
			String line = reader.readLine();
			
			//while line is not empty
			while (line != null) {
				
				String[] values = line.split(",");
				
				//book object
				Book book = new Book(values[0],values[1],values[2],values[3],values[4],values[5],Integer.parseInt(values[6]),Integer.parseInt(values[7]));
				book_list.add(book);
				
				//read next line
				line = reader.readLine();
			}
			
			reader.close();
			System.out.println("Book File read successfully.\n");
			
		} catch (Exception e) {
			System.out.println("Error, file not accessed.");
		}
		
		
		
		
		//menu loop
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("1) Book Management");
			System.out.println("2) Member Management");
			System.out.println("3) Loan Management");
			System.out.println("4) Search");
			System.out.println("5) Exit");
			System.out.println("Please select an option:");
			
			//scanner for menu choice
			int menu_choice = scanner.nextInt();
			
			switch(menu_choice) {
			
			case 1:
				//book management
				System.out.println("\nBook Management\n");
				
				System.out.println("1) Display all books");
				System.out.println("2) Display borrowed books");
				System.out.println("3) Display unborrowed books");
				System.out.println("4) Add a new book");
				System.out.println("5) Return");
				System.out.println("Please select an option:");
				
				int submenu1_choice = scanner.nextInt();
				
				switch(submenu1_choice) {
				
				case 1:
					//display all books
					Book.displayAllBooks();
					break;
					
				case 2:
					//display borrowed books
					Book.displayBorrowedBooks();
					break;
					
				case 3:
					//display unborrowed books
					Book.displayUnborrowedBooks();
					break;
				
				case 4:
					//add new book
					Book.writeNewBookFile();
					break;
					
				case 5:
					//return
					break;
					
				default:
					//error message for invalid selection
					System.out.println("Invalid option, please select another.\n");
					break;
					
				}
				break;
				
			case 2:
				//member management
				System.out.println("\nMember Management\n");
				System.out.println("1) Display all members");
				System.out.println("2) Add a new member");
				System.out.println("3) Return");
				System.out.println("Please select an option:");
				
				int submenu2_choice = scanner.nextInt();
				
				switch(submenu2_choice) {
				
				case 1:
					//display all members
					Member.displayAllMembers();
					break;
					
				case 2:
					//add new member
					Member.writeNewMemberFile();
					break;
					
				case 3:
					//return
					break;
					
				default:
					//error message for invalid selection
					System.out.println("Invalid option, please select another.\n");
					break;
				
				}
				
				break;
				
			case 3:
				//loan management
				System.out.println("\nLoan Management\n");
				System.out.println("1) Check out a book");
				System.out.println("2) Check in a book");
				System.out.println("3) Return");
				System.out.println("Please select an option:");
				
				int submenu3_choice = scanner.nextInt();
				
				switch(submenu3_choice) {
				
				case 1:
					//check out book
					Book.checkoutBook();
					break;
					
				case 2:
					//check in book
					Book.checkinBook();
					break;
					
				case 3:
					//return
					break;
					
				default:
					//error message for invalid selection
					System.out.println("Invalid option, please select another.\n");
					break;
				
				}
				
				break;
				
			case 4:
				//search
				System.out.println("\nSearch\n");
				System.out.println("1) Find a member");
				System.out.println("2) Find a book");
				System.out.println("3) Return");
				System.out.println("Please select an option:");
				
				int submenu4_choice = scanner.nextInt();
				
				switch(submenu4_choice) {
				
				case 1:
					//find a member
					Member.findMember();
					break;
					
				case 2:
					//find a book
					Book.findBook();
					break;
					
				case 3:
					//return
					break;
					
				default:
					//error message for invalid selection
					System.out.println("Invalid option, please select another.\n");
					break;
				
				}
				
				break;
				
			case 5:
				//exit
				scanner.close();
				break;
				
			default:
				//error message for invalid selection
				System.out.println("Invalid option, please select another.\n");
				break;
			}
		
		
		}
		
		
	}

}
