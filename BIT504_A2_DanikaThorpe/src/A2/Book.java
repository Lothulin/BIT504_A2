package A2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Book {

	private String id;
	private String isbn;
	private String title;
	private String author;
	private String pubdate;
	private String genre;
	private int agerate;
	private int borrowedby;

	
	public Book(String id, String isbn, String title, String author, String pubdate, String genre, int agerate, int borrowedby) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.pubdate = pubdate;
		this.genre = genre;
		this.agerate = agerate;
		this.borrowedby = borrowedby;
	}
	
	
	//getters and setters
	//id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	//ISBN
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	//book title
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	//book author
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	//publishing date
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	
	//genre
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	//age rating
	public int getAgerate() {
		return agerate;
	}
	public void setAgerate(int agerate) {
		this.agerate = agerate;
	}
	
	//borrowed by
	public int getBorrowedby() {
		return borrowedby;
	}

	public void setBorrowedby(int borrowedby) {
		this.borrowedby = borrowedby;
	}

	//toString method
	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", pubdate=" + pubdate
				+ ", genre=" + genre + ", agerate=" + agerate + ", borrowedby=" + borrowedby + "]";
	}

	
	//methods
	
	//books table header
	public static void bookTableHeader() {
		String bookHeader = "ID\tTitle\tAuthor\tISBN\tPublish Date\tGenre\tAge Rating\tBorrowed By";
		System.out.println(bookHeader);
	}
	
	//display all books
	public static void displayAllBooks() {
		
		ArrayList<Book> book_list = Main.getbookList();
		System.out.println("\nAll Books\n");
		Book.bookTableHeader();
		
		for (Book book : book_list) {
			String row = "\n " + book.getId() + "\t" + book.getTitle() + " " + book.getAuthor() + "\t" + book.getIsbn() + "\t" + book.getPubdate() + "\t" + book.getGenre() + "\t" + book.getAgerate() + "\t" + book.getBorrowedby();
			System.out.println(row);
		}
		
	}
	
	//display borrowed books
		//if borrowedby != null
	public static void displayBorrowedBooks() {
		
		ArrayList<Book> book_list = Main.getbookList();
		boolean bookPresent = false;
		System.out.println("\nBorrowed Books\n");
		Book.bookTableHeader();
		for (Book book : book_list) {
			String row = null;
			if (book.getBorrowedby() != 0) {
				bookPresent = true;
				row = "\n " + book.getId() + "\t" + book.getTitle() + "\t" + book.getAuthor() + "\t" + book.getIsbn() + "\t" + book.getPubdate() + "\t" + book.getGenre() + "\t" + book.getAgerate() + "\t" + book.getBorrowedby();
				System.out.println(row);
			}
			
		}
		
		if (bookPresent = false) {
			System.out.println("No books found.");
		}	
		
	}

	
	//display unborrowed books
		//if borrowedby == null
	public static void displayUnborrowedBooks() {
		
		ArrayList<Book> book_list = Main.getbookList();
		boolean bookPresent = false;
		System.out.println("\nUnborrowed Books\n");
		Book.bookTableHeader();
		for (Book book : book_list) {
			String row = null;
			if (book.getBorrowedby() == 0) {
				bookPresent = true;
				row = "\n " + book.getId() + "\t" + book.getTitle() + "\t" + book.getAuthor() + "\t" + book.getIsbn() + "\t" + book.getPubdate() + "\t" + book.getGenre() + "\t" + book.getAgerate() + "\t" + book.getBorrowedby();
				System.out.println(row);
			}
			
		}
		
		if (bookPresent = false) {
			System.out.println("No books found.");
		}	
	
	}
	
	///find a book
	public static void findBook() {
		
		String row = null;
		
		ArrayList<Book> book_list = Main.getbookList();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a title:");
		
		String entry = scanner.next();
			if (!Pattern.matches("[a-zA-Z]*", entry)) {
				System.out.println("Invalid entry, please use the alphabet.");
			}
		Book.bookTableHeader();
		for (Book book : book_list) {
			if (book.getTitle().contains(entry)) {
				row = book.getId() + "\t" + book.getIsbn() + "\t" + book.getTitle() + "\t" + book.getAuthor() + "\t" + book.getPubdate() + "\t" + book.getGenre() + "\t" + book.getAgerate() + "\t" + book.getBorrowedby();
				System.out.println(row);
			}

		}
	}
	
	//check in book
	public static void checkinBook() {
		ArrayList<Book> book_list = Main.getbookList();
		String file = "src/a2/books";
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			System.out.println("Please enter a book ID");
			Scanner scanner = new Scanner(System.in);
			String book_search = scanner.next();
			for (Book book : book_list) {
				if (book.getId() == book_search) {
					book.setBorrowedby(0);					
					//not correct code, actually write it to file
					System.out.println("Book successfully checked in.");
				}
				
			}
			
			
		} catch (Exception e) {
			System.out.println("No file found");
		}
		
	}
	
	
	//check out book
	
	public static void checkoutBook() {
		ArrayList<Book> book_list = Main.getbookList();
		String file = "src/a2/books";
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			System.out.println("Please enter a book ID");
			Scanner scanner = new Scanner(System.in);
			String book_search = scanner.next();
			for (Book book : book_list) {
				if (book.getId() == book_search) {
					System.out.println("Please enter the ID of the borrower:");
					int borrower = scanner.nextInt();
					book.setBorrowedby(borrower);					
					//not correct code, actually write it to file
					System.out.println("Book successfully checked out.");
				}
				
			}
			
			
		} catch (Exception e) {
			System.out.println("No file found");
		}
	}
	
	
	//write new book to file
	public static void writeNewBookFile() throws Exception{
		String file = "src/a2/books";
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			
			System.out.println("Please enter a new book ID");
			Scanner scanner = new Scanner(System.in);
			String id_entry = scanner.next();
				//rewrite to automatically assign id?
			
			System.out.println("Please enter an ISBN");
			String isbn_entry = scanner.next();
			
			System.out.println("Please enter a title");
			String title_entry = scanner.next();
			
			System.out.println("Please enter an author");
			String author_entry = scanner.next();
			
			System.out.println("Please enter a publishing date");
			String pubdate_entry = scanner.next();
			
			System.out.println("Please enter a genre");
			String genre_entry = scanner.next();
			
			System.out.println("Please enter an age rating");
			String agerate_entry = scanner.next();
			
			String newBook = String.join(",", id_entry, isbn_entry, title_entry, author_entry, pubdate_entry, genre_entry, agerate_entry, "null") ;
			writer.newLine();
			writer.write(newBook);
			
			writer.close();
			scanner.close();
			
			
		} catch (Exception e) {
			System.out.println("No file found");
		}
	}
}