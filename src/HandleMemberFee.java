import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class HandleMemberFee{	
	public static void showAllDeptors() throws FileNotFoundException{
		haveMemberMissedPayment(memberToList());
	}
	
			//	Remember, several of the arrays in these methods 
			//  use the member class. But, becourse the member 
			//  class is a public class.
			//	The member class can access them with no problems.
	
	//Early testing
	/*
	public static void loadFile() throws FileNotFoundException{
	File f = new File("C:\\Users\\MBEN\\workspace\\The Dolphin project\\src\\DolphinMemberSaveFile");
	Scanner console = new Scanner(f);
	}
	*/
	
			//Might need to change how the File path is found. Need to read up on that.
	public static ArrayList<Member> memberToList() throws FileNotFoundException
	{
		File memberFile = new File("C:\\Users\\MBEN\\workspace\\The Dolphin project\\src\\DolphinMemberSaveFile");
		@SuppressWarnings("resource")
		Scanner theDataFromFile = new Scanner(memberFile);
		ArrayList<Member> memberList = new ArrayList<Member>();
		
			while(theDataFromFile.hasNextLine()) {
				String[] arr = theDataFromFile.nextLine().split(" ");					//Splits the string at every space.
				
				int Id = Integer.parseInt(arr[0]); 										//birthyears String to int if possible.
				String name = arr[1];
				String birthday = arr[2];
				String registrationDate = arr[3];
				String hasPaidDate = arr[4];
				Boolean getType = Boolean.parseBoolean(arr[5]); 						//birthyears String to Boolean if possible.
				Member test = new Member(Id, name, birthday, registrationDate, hasPaidDate, getType);
				memberList.add(test);
			}
		
			// fileloader i made. Not tested. Need to test.
			// The problem with this fileloader is, that it deals with tokens. And that 
			// will become a problem, if the members in the member file at a later 
			// point had additional informations written to the file.
			// The fileloader above, takes in an entire string, chops it up, and destributes 
			// the tokens to the variables. And therefore the problem with the former 
			// fileloader, is not going to happen.
			
			/*
				while(theDataFromFile.hasNext()){ //While the save file has values, load the values into the variables.
				
				int Id = theDataFromFile.nextInt();
				String name = theDataFromFile.next();
				String birthday = theDataFromFile.next();
				String registrationDate = theDataFromFile.next();
				String hasPaidDate = theDataFromFile.next();
				boolean getType = theDataFromFile.nextBoolean();
				Member memberName = new Member(Id, name, birthday, registrationDate, hasPaidDate, getType);
				memberList.add(memberName);
				}
			*/
			return memberList;
	}
	
	//Collection of two methods. Is should change the two at a later point, to smooth out the process.
	public static void printAllMembers() throws FileNotFoundException{
	HandleMemberFee.printOutList(HandleMemberFee.memberToList());
	}
	
	static void haveMemberMissedPayment(ArrayList<Member> list)
	{
		ArrayList<Member> memberList = new ArrayList<>();								//List for full list of members.		
		ArrayList<Member> unpaidList = new ArrayList<>();								//List for sorting the members that has not paid-
			for(Member m : list){
				String regDate = m.getRegistrationDate(); 								//Gets the registration date, for comparison of the hasPaidDate.
				String[] arrRegistration = regDate.split("-"); 							//Splits the string up, and put the three values into the array.
				
				ArrayList<Integer> arrlistRegistrationInt = new ArrayList<Integer>();
				
				for(int i = 0; i < arrRegistration.length; i++){
					int birthyear = Integer.parseInt(arrRegistration[i]);					//Takes the string in the arrRegistration list and birthyears it to int.
					arrlistRegistrationInt.add(birthyear);

					System.out.print(arrlistRegistrationInt);
				}
			}
		}
	/*
	public static void printOutList(ArrayList<Member> list){
		/* Test method
		 * This method was used for examining if the correct data was loaded into the list.
		 * After testing, I learned that the informations was incorrect. And after several bug solving,
		 * the issues were corrected.
		 * 
		 * The method is not used for anything else in my usecase. But could be reused other places
		 */
		for(Member m : list){ 															//For every m object in the list.
			System.out.print(m.getName() + " ");
			System.out.print(m.getBirthday() + " ");
			System.out.print(m.getRegistrationDate() + " ");
			System.out.print(m.getHasPaidDate() + " ");
			
				if(m.getType = true){ 													//Gives another readout than true or false.
					System.out.print("Active");	
				} else {
					System.out.print("Inactive");
				}
			System.out.println();
		}
	}				
				
/*Pseudo code
 * 
 * Get the registration date
 * Parse the date into three tokens
 * Load the tokens into the date datatype
 * 
 * Do the same for the payment date.
 * 
 * Set a parameter stating, that if the payment date is more than a year after registration date, then return a true bool.
 * 
 * Bool value should be used to activate the method that gets information of that member, and calculates how much the member owes.
 * 
 * Return that value.
 * 
 * 
 * FUNDAMENTALY FLAWED DESIGN - If the date is more than one years after the registration date, the value will always return false.
 * SOLUTION - Extend the memberclass with a subclass that will contain a log for the payments for that member.
 * 
 */

	public static int calculateAge(int debtorId) throws FileNotFoundException{
		GregorianCalendar today = new GregorianCalendar(); 								//Used to get current date, year, era and so on.
		ArrayList<Member> memberList = new ArrayList<>();								//List for full list of members.
		memberList = HandleMemberFee.memberToList();
		
		int age = 0;
		for(Member m : memberList){ 													//For every m object in the list.
			int birthyear;

			if(debtorId == m.getMemberId()){
				String regDate = m.getBirthday(); 										//Gets the registration date, for comparison of the hasPaidDate.
				String[] arrRegistration = regDate.split("-"); 							//Splits the string up, and put the three values into the array.
				birthyear = Integer.parseInt(arrRegistration[2]);						//Takes the string in the arrRegistration list and birthyears it to int.
				age = (today.get(Calendar.YEAR) - birthyear);
			}
		}
		return age;		
	}
}