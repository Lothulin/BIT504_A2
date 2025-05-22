package A2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Member {
	
	private String id;
	private String fname;
	private String lname;
	private int age;
	
	
	public Member(String id, String fname, String lname, int age) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}


	//getters and setters
	//ID
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	//first name
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	//last name
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	//age
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Member [id=" + id + ", fname=" + fname + ", lname=" + lname + ", age=" + age + "]";
	}

	
	//methods
	
	//member table header
	public static void memberTableHeader() {
		String memberHeader = "ID\tName\t\tAge";
		System.out.println(memberHeader);
	}
	
	//displaying all members
	public static void displayAllMembers() {
		
		ArrayList<Member> member_list = Main.getmemberList();
		System.out.println("\nAll Members\n");
		Member.memberTableHeader();
		
		for (Member member : member_list) {
			String row = "\n " + member.getId() + "\t" + member.getFname() + " " + member.getLname() + "\t" + member.getAge();
			System.out.println(row);
		}
		
	}
	
	
	//add new member
	public static void writeNewMemberFile() throws Exception{
		String file = "src/a2/members";
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			
			System.out.println("Please enter a new member ID");
			Scanner scanner = new Scanner(System.in);
			String id_member_entry = scanner.next();
			//rewrite to automatically assign id?
			
			System.out.println("Please enter the first name");
			String fname_entry = scanner.next();
			
			System.out.println("Please enter the last name");
			String lname_entry = scanner.next();
			
			System.out.println("Please enter an age");
			String age_entry = scanner.next();
			
			String newMember = String.join(",", id_member_entry, fname_entry, lname_entry, age_entry) ;
			writer.newLine();
			writer.write(newMember);
			
			writer.close();
			scanner.close();
			
			
		} catch (Exception e) {
			System.out.println("No file found");
		}
	}
	
	
	//find a member
	
	public static void findMember() {
		
		String row = null;
		
		ArrayList<Member> member_list = Main.getmemberList();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a last name:");
		
		String entry = scanner.next();
			if (!Pattern.matches("[a-zA-Z]*", entry)) {
				System.out.println("Invalid entry, please use the alphabet.");
			}
		for (Member member : member_list) {
			if (member.getLname().contains(entry)) {
				row = member.getId() + "\t" + member.getFname() + " " + member.getLname() + "\t" + member.getAge();
				System.out.println(row);
			}

		}
	}
	
}
