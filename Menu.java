
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	public static Scanner scan_input = new Scanner(System.in);

	public static void main(String[] args) {
		
	
	
		
		Members[] members = new Members[100]; // keeping the max no of members to 100 
		BookSearch[] books = new BookSearch[100]; // keeping the max no of books to 100 
		
		ArrayList <CheckoutBook> borrowedBooks = new ArrayList<CheckoutBook>();
		
		
		Members.readMembersData(members); // Read members Data
		BookSearch.readDataBase(books); // reads database
		
		boolean quit = false; // will control the main loop
		
		System.out.println("\n\t*****Library Management System*****");
		while(quit == false) {
			Members.members_detail();
			BookSearch.books_details();
			System.out.println("\nHere's what you can do: ");
			System.out.println("\n1. Become a library member. ");
			System.out.println("2. Checkout a Book. ");
			System.out.println("3. Search for a  Member. ");
			System.out.println("4. Show all members. ");
			System.out.println("5. Search for a Book. ");
			System.out.println("6. Show the list of all available books. ");
			System.out.println("7. Show the list of all borrowed books. ");
			System.out.println("8. Return a Book. ");
			System.out.println("0. Quit Program. ");
			int user_input = scan_input.nextInt();
			
			
			
			while(!(user_input >= 0 && user_input <= 8)) {
				System.out.println("Enter again: ");
				user_input = scan_input.nextInt();
			}
			
			
			if(user_input ==1) {
				members[Members.count_members] = new Members();
				
				members[Members.count_members-1].ask_details();
				
				Members.storeMemberData(members[Members.count_members-1]);
			}
			else if(user_input == 2) {
				System.out.println("\nEnter the Book ID: ");
				String bookID = scan_input.next();
				while(CheckoutBook.verify_book(books, bookID) != true) {
					System.out.println("\nThe entered book id is not available, enter again: ");
					bookID = scan_input.next();
				}
				
				System.out.println("Enter the member ID: ");
				String mem_id = scan_input.next();
				
				while(CheckoutBook.verify_member(members, mem_id) != true) {
					System.out.println("\nThe entered member id is not valid, enter again:");
					mem_id = scan_input.next();
				}
				
				System.out.println("\nThe Book with ID "+books[CheckoutBook.book_index].getBookId()+" has been loaned to the member with ID "+members[CheckoutBook.member_index].getId()+".");
				CheckoutBook.store_borrow_history(members, books);
				
				
				CheckoutBook checkedBook = new CheckoutBook();
				borrowedBooks.add(CheckoutBook.countBorrowedBooks-1,checkedBook);
				
				System.out.println(borrowedBooks.get(CheckoutBook.countBorrowedBooks-1));
				
				
				
				System.out.println("The checkout book arraylist size: "+ borrowedBooks.size());
				BookSearch.countBooks--;
			}
			else if(user_input ==3) {
				System.out.println("\nEnter the member ID: ");
				String  input_scan_id = scan_input.next();
				
				while(Members.validMember(input_scan_id, members ) != true) {
					System.out.println("\nMember ID not Found. Enter again : ");
					input_scan_id = scan_input.next();
				}
				System.out.println("\nMember found.");
				members[Members.count_members-1].member_profile();

			}else if(user_input == 4) {
				Members.show_all_members(members);
			}
			else if(user_input == 5) {
				System.out.println("\nEnter the Book Name: ");
				String user_entered_bookname = scan_input.next();
				
				while(BookSearch.book_available(user_entered_bookname, books) != true) {
					System.out.println("\nNo book found with that name, enter again: ");
					user_entered_bookname = scan_input.next();
				}
				
				BookSearch.display_searched_book(user_entered_bookname, books);
				
				
			}
			else if(user_input == 6) {
				BookSearch.display_all_books(books);
			}
			else if(user_input == 7) {
				CheckoutBook.dispaly_checkedOutBooks_index(borrowedBooks, books);
			}
			else if(user_input == 8) {
				System.out.println("\nEnter the book ID: ");
				String toVerify_bookID = scan_input.next();
				
				while(ReturnBook.verify_return_book(books, toVerify_bookID) != true) {
					System.out.println("\nThe entered book id is not available, enter again: ");
					toVerify_bookID = scan_input.next();
				}
				
				System.out.println("\nEnter the Member ID: ");
				String to_verify_mem = scan_input.next();
				
				while(ReturnBook.verify_return_member(members, to_verify_mem) != true) {
					System.out.println("\nThe entered member id is not valid, enter again:");
					to_verify_mem = scan_input.next();
				}
				
				System.out.println("\nThe Book with ID "+books[ReturnBook.return_book_index].getBookId()+" has been returned by the member with ID "+members[ReturnBook.return_mem_index].getId()+".");
				ReturnBook.store_return_history(members, books);
				
				BookSearch.countBooks++;
				

				
				
				
				
			}
			else if(user_input == 0) {
				quit = true;
			}
		}
		
		System.out.println("\nProgram Ended.");
		
		
	}

}
