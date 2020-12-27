import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class Members {
	public static int count_members = 0;
	private String name;
	private String id;
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public static void members_detail() {
		System.out.println("----------------------------------------------------------");
		System.out.println("\n\t------Current Library Members: "+ count_members+" -----");
	}
	
	
	public Members() {
		count_members++;
	}
	
	public void ask_details(){
		Random random = new Random();
		System.out.println("\nEnter your 1st name: ");
		String first_name = Menu.scan_input.next();
		System.out.println("Enter your last name: ");
		String sec_name = Menu.scan_input.next();
		
		setName(first_name+"_"+sec_name);
		String temp_id = "";
		String numbers = "0123456789";
		for(int i=0; i<4; i++) {
			 char temp_pos = numbers.charAt(random.nextInt(numbers.length()));
			 temp_id += temp_pos;
			}
		setId(temp_id);
		System.out.println("\nMember added.");
	}
	
	public void member_profile() {
		//System.out.println("\n\t-----Profiles-----");
		//System.out.println("\nName: "+ "\t\t\tID");
		//System.out.println("----------------------------");
		System.out.println("\n"+ this.getName()+"\t\t"+this.getId());
		
	}
	public static void show_all_members(Members[] mem) {
		System.out.println("\n\t-----Profiles-----");
		System.out.println("\nName: "+ "\t\t\tID");
		System.out.println("----------------------------");
		for(int k =0; k<count_members; k++) {
			mem[k].member_profile();
		}
		System.out.println("----------------------------------------------------------");
	}
	
	public static void storeMemberData(Members mem) {
		try {
			FileWriter filewriter = new FileWriter("E:\\3rdSemester\\DSA LAB\\Library Management System\\191370110 - Library Management System\\src\\members.txt", true);

				filewriter.write("\n"+mem.getName());
				filewriter.write(" "+mem.getId());
				filewriter.close();
		}
		catch(IOException exp) {
			System.out.println("For write File not Found.");
		}
	}
	
	public static void readMembersData(Members[] mem) {
		
		try {
			FileReader filereader = new FileReader("E:\\\\3rdSemester\\\\DSA LAB\\\\Library Management System\\\\191370110 - Library Management System\\\\src\\\\members.txt");

			Scanner read_scanner = new Scanner(filereader);
			if(read_scanner.hasNext()) {
				
				while(read_scanner.hasNext()) {
					String temp_name = read_scanner.next();
					String temp_id = read_scanner.next();
					
					
					mem[count_members] = new Members();
					
					mem[count_members-1].setName(temp_name);
					mem[count_members-1].setId(temp_id);
				}
				
				
				
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("For read file not found.");
		}
	}
	
	public static boolean validMember(String input_id, Members[] mem) {
		boolean idFound = false;
		for(int i=0; i<count_members; i++)
		{
			if(input_id.equals(mem[i].getId())) {
				idFound  = true;
				break;
			}
		}
		
		return idFound;
		
		
	}
	
	
}
