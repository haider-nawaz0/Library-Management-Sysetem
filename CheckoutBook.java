import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class CheckoutBook {
	public static int member_index, book_index, countBorrowedBooks=0;
	private int checked_out_bookIndex=0;
	
	public void setCheckedOutBooks(int checked_out_book) {
		this.checked_out_bookIndex = checked_out_book;
	}
	public int getCheckedOutBook() {
		return checked_out_bookIndex;
	}
	
	public CheckoutBook() {
		countBorrowedBooks++;
		System.out.println("\nIm in the constructor of Checkout Book Class");
	}
	
	
	public static boolean verify_member(Members[] members,String input_mem) {
		for(int i=0; i<Members.count_members; i++) {
			if(input_mem.equalsIgnoreCase(members[i].getId())) {
				member_index = i;
				return true;
			}
		}
		return false;
	}
	public static boolean verify_book(BookSearch[] books,String input_book) {
		for(int i=0; i<BookSearch.countBooks; i++) {
			if(input_book.equalsIgnoreCase(books[i].getBookId())) {
				book_index = i;
				
				return true;
			}
		}
		return false;
		
	}
	
	public static void store_borrow_history(Members[] members, BookSearch[] books) {

		LocalTime time = java.time.LocalTime.now();
		LocalDate date = java.time.LocalDate.now();
		try {
			FileWriter writeBorrow = new FileWriter("E:\\3rdSemester\\DSA LAB\\Library Management System\\191370110 - Library Management System\\src\\logfile.txt", true);
			String towrite = "\nMember named "+members[member_index].getName()+" with ID "+members[member_index].getId()+" borrowed a book named "+books[book_index].getBookName()+" with ID "+books[book_index].getBookId()+" on "+date+" at "+time ;
			writeBorrow.write(towrite);
			
			writeBorrow.close();
			
		}
		
		catch(IOException e) {
			System.out.println("\nLog file not found");
		}
	}
	
	public static void dispaly_checkedOutBooks_index(ArrayList<CheckoutBook> borrowedBooks, BookSearch[] books) {
		if(borrowedBooks.isEmpty()) {
			System.out.println("\nNo book is currently borrowed.");
			return;
		}
		System.out.println("\nList of Borrowed Books:");
		
		for(int i=0; i<countBorrowedBooks; i++) {
			int ind  = borrowedBooks.get(i).getCheckedOutBook();
			System.out.println("Book Name: "+books[ind].getBookName());
		}
	}
	@Override
	public String toString() {
		return "\nBorrowed Book Index: "+book_index;
		
	}
}
