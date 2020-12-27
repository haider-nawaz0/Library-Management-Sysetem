import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class BookSearch {
	public static int countBooks = 0;
	private String bookId, isbn, author, purchaseDate, memberID, bookName;

	public void setName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookName() {
		return bookName;
	}
	
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BookSearch() {
		countBooks++;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	
	public static  void readDataBase(BookSearch[] book) {
		try {
			FileReader bookReader = new FileReader("E:\\\\3rdSemester\\\\DSA LAB\\\\Library Management System\\\\191370110 - Library Management System\\\\src\\\\database.txt");
			Scanner scan_database = new Scanner(bookReader);
			
			while(scan_database.hasNext()) {
				String temp_book_id = scan_database.next();
				String temp_isbn = scan_database.next();
				String temp_name = scan_database.next();
				String temp_author = scan_database.next();
				String temp_purshaseDate = scan_database.next();
				String temp_memberId = scan_database.next();
				
				book[countBooks] =  new BookSearch();

				
				book[countBooks-1].setBookId(temp_book_id);
				book[countBooks-1].setIsbn(temp_isbn);
				book[countBooks-1].setName(temp_name);
				book[countBooks-1].setAuthor(temp_author);
				book[countBooks-1].setPurchaseDate(temp_purshaseDate);
				book[countBooks-1].setMemberID(temp_memberId);
				
				
			}
		}catch(FileNotFoundException e) {
			System.out.println("Database file not found.");
		}
	}
	public void display_book() {
		
		System.out.println("\n"+this.getBookId()+"\t"+this.getIsbn()+"\t"+this.getBookName()+"\t\t"+this.getAuthor()+"\t"+this.getPurchaseDate()+"\t"+this.getMemberID());
	}
	
	public static void display_all_books(BookSearch[] books) {
		System.out.println("\n\t-----List of all available books-----");
		System.out.println("\nBook ID\t\tISBN\tBook Name\tAuthor\t\tPurchase Date\tAllocated Members");
		for(int i=0; i<countBooks; i++) {
			books[i].display_book();
		}
	}
	
	public static void books_details() {
		System.out.println("\t-----Total available books: "+ countBooks+" -----");
	}
	
	public static boolean book_available(String user_entered_bookname, BookSearch [] books) {
		
		for(int i=0; i<countBooks; i++) {
			if(user_entered_bookname.equalsIgnoreCase(books[i].getBookName())) {
				return true;
			}
		}
		return false;
	}
	
	public static void display_searched_book(String user_entered_bookname, BookSearch [] books)
	{
		for(int i=0; i<countBooks; i++) {
			if(user_entered_bookname.equalsIgnoreCase(books[i].getBookName())) {
				books[i].display_book();
			}
		}
	}
	
	
}
