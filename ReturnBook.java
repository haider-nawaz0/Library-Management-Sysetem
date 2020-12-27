import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReturnBook {
	
	public static int return_mem_index, return_book_index;
	
	public static boolean verify_return_member(Members[] members,String input_mem) {
		for(int i=0; i<Members.count_members; i++) {
			if(input_mem.equalsIgnoreCase(members[i].getId())) {
				return_mem_index = i;
				return true;
			}
		}
		return false;
	}
	public static boolean verify_return_book(BookSearch[] books,String input_book) {
		for(int i=0; i<BookSearch.countBooks; i++) {
			if(input_book.equalsIgnoreCase(books[i].getBookId())) {
				return_book_index = i;
				
				return true;
			}
		}
		return false;
		
	}

	
	public static void store_return_history(Members[] members, BookSearch[] books) {

		LocalTime time = java.time.LocalTime.now();
		LocalDate date = java.time.LocalDate.now();
		try {
			FileWriter writeBorrow = new FileWriter("E:\\3rdSemester\\DSA LAB\\Library Management System\\191370110 - Library Management System\\src\\logfile.txt", true);
			String towrite = "\nMember named "+members[return_mem_index].getName()+" with ID "+members[return_mem_index].getId()+" returned a book named "+books[return_book_index].getBookName()+" with ID "+books[return_book_index].getBookId()+" on "+date+" at "+time ;
			writeBorrow.write(towrite);
			
			writeBorrow.close();
			
		}
		
		catch(IOException e) {
			System.out.println("\nLog file not found");
		}
	}
}
