package hotel_Chatbot;
import java.util.Scanner;

public class hotel_bot {
	
	static boolean finishing = false; 
	
	static boolean lookForCheckInDate = false; 
	
	static boolean lookForNumberOfPeople = false; 
		
	static int numberOfPeople = 0; 
	
	static boolean numberOfAdults = false; 

	static boolean lookForTypeOfRoom = false; 

	static boolean askForSmoking = false;
	
	static boolean askForOceanView = false;
	
	static boolean askForBreakfast = false;
	
	static boolean askForPet = false;
	
	static boolean askForFirstName = false; 
	
	static boolean askForLastName = false; 
	
	static boolean askForPrice = false; 
	
	static boolean askForPhoneNumber = false; 
	
	static boolean askForPaymentType = false; 

	static boolean askForCardNumber = false; 
	
	static boolean askForCardHolder = false; 
	
	static boolean confirmation = false; 

	static final String[] numNames = {
		    "one",
		    "two",
		    "three",
		    "four",
		    "five",
		    "six",
		    "seven",
		    "eight",
		    "nine",
		    "ten",
		    "eleven",
		    "twelve",
		    "thirteen",
		    "fourteen",
		    "fifteen",
		    "sixteen",
		    "seventeen",
		    "eighteen",
		    "nineteen"
		  };
	
	static final int[] nums = {
			1,
			2,
			3,
			4,
			5,
			6,
			7,
			8,
			9,
			10,
			11,
			12,
			13,
			14,
			15,
			16,
			17,
			18,
			19
			
	};
	
	static final String[] months = {
			"jan",
			"feb",
			"mar",
			"apr",
			"may",
			"jun",
			"jul",
			"aug",
			"sep",
			"oct",
			"nov",
			"dec"
	};
	
	static final String[] monthNames = {
			"January",
			"February",
			"March",
			"April",
			"May",
			"June",
			"July",
			"August",
			"September",
			"October",
			"November",
			"December",
	}; 
	
	static String date = ""; 
	
	static int numOfBeds = 0;
	
	static String bedType = ""; 
	
	static String choiceOfRoom = ""; 
	
	static boolean smoking = false;
	
	static boolean oceanView = false;
	
	static boolean breakfast = false; 
	
	static boolean pet = false;
	
	static String name = ""; 
	
	static String phoneNumber = ""; 
	
	static int price = 279; 
	
	static final int[] numberOfBeds = {1, 2};
	
	static final String[] typeOfBeds = {"single", "double", "queen", "king"};
	

	public static String response(String s) {
		String[] tokens = parseString(s);
		String response = ""; 
		for (int i = 0; i < tokens.length; i++) {
			// if the client wants to make reservation/booking
			if (tokens[i].equals("reserve") || tokens[i].equals("reservation") || tokens[i].equals("book") || tokens[i].equals("booking")) {
				lookForCheckInDate = true; 
				return askDate(tokens); 

			}
			else if (lookForCheckInDate && !lookForNumberOfPeople && !numberOfAdults && !lookForTypeOfRoom && !askForSmoking && !askForOceanView && !askForBreakfast && !askForPet && !askForFirstName && !askForLastName && !askForPrice && !askForPhoneNumber && !askForPaymentType && !askForCardNumber && !askForCardHolder && !confirmation) {
				date += s; 
				date = date.substring(0,1).toUpperCase() + date.substring(1).toLowerCase();
				return checkInDate(tokens);
				
			}
			else if (lookForCheckInDate && lookForNumberOfPeople && !numberOfAdults && !lookForTypeOfRoom && !askForSmoking && !askForOceanView && !askForBreakfast && !askForPet && !askForFirstName && !askForLastName && !askForPrice && !askForPhoneNumber && !askForPaymentType && !askForCardNumber && !askForCardHolder && !confirmation) {
				return NumberOfPeople(tokens);				

			}
			else if (lookForCheckInDate && lookForNumberOfPeople && numberOfAdults && !lookForTypeOfRoom && !askForSmoking && !askForOceanView && !askForBreakfast && !askForPet && !askForFirstName && !askForLastName && !askForPrice && !askForPhoneNumber && !askForPaymentType && !askForCardNumber && !askForCardHolder && !confirmation) {
				numberOfPeople = howManyPeople(s); 
				if (numberOfPeople == 0) 
					response = errorMessage(); 
				return typeOfRoom(numberOfPeople);
				
			}
			else if (lookForCheckInDate && lookForNumberOfPeople && numberOfAdults && lookForTypeOfRoom && !askForSmoking && !askForOceanView && !askForBreakfast && !askForPet && !askForFirstName && !askForLastName && !askForPrice && !askForPhoneNumber && !askForPaymentType && !askForCardNumber && !askForCardHolder && !confirmation) {
				choiceOfRoom = roomChoice(tokens); 
				return askForSmoking(tokens); 
				
			}
			else if (lookForCheckInDate && lookForNumberOfPeople && numberOfAdults && lookForTypeOfRoom && askForSmoking && !askForOceanView && !askForBreakfast && !askForPet && !askForFirstName && !askForLastName && !askForPrice && !askForPhoneNumber && !askForPaymentType && !askForCardNumber && !askForCardHolder && !confirmation) {
				smoking = smokingChoice(tokens); 
				return askForOceanView(tokens); 
				
			}
			else if (lookForCheckInDate && lookForNumberOfPeople && numberOfAdults && lookForTypeOfRoom && askForSmoking && askForOceanView && !askForBreakfast && !askForPet && !askForFirstName && !askForLastName && !askForPrice && !askForPhoneNumber && !askForPaymentType && !askForCardNumber && !askForCardHolder && !confirmation) {
				oceanView = oceanViewChoice(tokens); 
				return askForBreakfast(tokens); 
				
			}
			else if (lookForCheckInDate && lookForNumberOfPeople && numberOfAdults && lookForTypeOfRoom && askForSmoking && askForOceanView && askForBreakfast && !askForPet && !askForFirstName && !askForLastName && !askForPrice && !askForPhoneNumber && !askForPaymentType && !askForCardNumber && !askForCardHolder && !confirmation) {
				breakfast = breakfastChoice(tokens); 
				return askForPet(tokens); 
				
			}
			else if (lookForCheckInDate && lookForNumberOfPeople && numberOfAdults && lookForTypeOfRoom && askForSmoking && askForOceanView && askForBreakfast && askForPet && !askForFirstName && !askForLastName && !askForPrice && !askForPhoneNumber && !askForPaymentType && !askForCardNumber && !askForCardHolder && !confirmation) {
				pet = petChoice(tokens); 
				return askForFirstName(tokens); 
				
			}
			else if (lookForCheckInDate && lookForNumberOfPeople && numberOfAdults && lookForTypeOfRoom && askForSmoking && askForOceanView && askForBreakfast && askForPet && askForFirstName && !askForLastName && !askForPrice && !askForPhoneNumber && !askForPaymentType && !askForCardNumber && !askForCardHolder && !confirmation) {
				
				return askForLastName(tokens); 
				
			}
			else if (lookForCheckInDate && lookForNumberOfPeople && numberOfAdults && lookForTypeOfRoom && askForSmoking && askForOceanView && askForBreakfast && askForPet && askForFirstName && askForLastName && !askForPrice && !askForPhoneNumber && !askForPaymentType && !askForCardNumber && !askForCardHolder && !confirmation) {
				name += s; 
				name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
				askForPhoneNumber = true;
				return "The rate of the room you reserved is $" + generatePrice(tokens) + "." + askForPhoneNumber(tokens);
				 
			}
			else if (lookForCheckInDate && lookForNumberOfPeople && numberOfAdults && lookForTypeOfRoom && askForSmoking && askForOceanView && askForBreakfast && askForPet && askForFirstName && askForLastName && askForPrice && askForPhoneNumber && !askForPaymentType && !askForCardNumber && !askForCardHolder && !confirmation) {
				return askForPaymentType(tokens); 
			}
			else if (lookForCheckInDate && lookForNumberOfPeople && numberOfAdults && lookForTypeOfRoom && askForSmoking && askForOceanView && askForBreakfast && askForPet && askForFirstName && askForLastName && askForPrice && askForPhoneNumber && askForPaymentType && !askForCardNumber && !askForCardHolder && !confirmation) {
				return askForCardNumber(tokens); 
			}
			else if (lookForCheckInDate && lookForNumberOfPeople && numberOfAdults && lookForTypeOfRoom && askForSmoking && askForOceanView && askForBreakfast && askForPet && askForFirstName && askForLastName && askForPrice && askForPhoneNumber && askForPaymentType && askForCardNumber && !askForCardHolder && !confirmation) {
				return askForCardHolder(tokens); 
			}
			else if (lookForCheckInDate && lookForNumberOfPeople && numberOfAdults && lookForTypeOfRoom && askForSmoking && askForOceanView && askForBreakfast && askForPet && askForFirstName && askForLastName && askForPrice && askForPhoneNumber && askForPaymentType && askForCardNumber && askForCardHolder && !confirmation) {
				return confirmReservation(tokens); 
			}
			else if (lookForCheckInDate && lookForNumberOfPeople && numberOfAdults && lookForTypeOfRoom && askForSmoking && askForOceanView && askForBreakfast && askForPet && askForFirstName && askForLastName && askForPrice && askForPhoneNumber && askForPaymentType && askForCardNumber && askForCardHolder && confirmation) {
				finishing = true; 
			}
			
		}
		return response; 
	}
	
	public static String askDate(String[] s) {
		String[] askText = {"What is your arriving date?", "What is your arriving date?"}; 
		return "I am glad to offer help. " + askText[randomIndex(askText)]; 
	}
	
	//ask for client's checkout date
	public static String checkInDate(String[] s) {
		//record guest arriving date later
		String[] checkInText = {"How long will you be staying?", "How many nights do you plan to stay?"}; 		
		lookForNumberOfPeople = true; 
		return "We do have some vacancies around that date. " + checkInText[randomIndex(checkInText)]; 
	}
	
	public static String dateChoice(String[] s) {
		for (int i = 0; i < s.length; i ++) {
			for (int j = 0; j < months.length; j++) {
				if (s[i].contains(months[j]) || s[i].equals(months[j])) {
					date += monthNames[j] + " "; 
				}
				else if (!(s[i].contains(months[j]) || s[i].equals(months[j])) && Integer.parseInt(s[i]) >=1 && Integer.parseInt(s[i])<=31) {
					date += s[i];
				}
			}
		}
		return date; 
	}
	
	//ask for client's number of people 
	public static String NumberOfPeople(String[] s) {
		String[] numberOfPeopleText = {"How many people is the reservation for?", "How many adults will be in the room?"}; 
		numberOfAdults = true; 
		return numberOfPeopleText[randomIndex(numberOfPeopleText)]; 
	}
	
	//number of people 
	public static int howManyPeople(String s) {
		String[] tokens = parseString(s);
			for (int i = 0; i < tokens.length; i++) {
				for (int j = 0; j < numNames.length; j++) {
					if (tokens[i].equals(numNames[j])) {
						numberOfPeople = nums[j]; 
						return numberOfPeople; 
					}
					else if (Integer.parseInt(tokens[i]) == nums[j]) {
						numberOfPeople = nums[j]; 
						return numberOfPeople; 
					}
				}
			}
		
		return numberOfPeople; 
	}
	
	//ask for type of room 
	public static String typeOfRoom(int numberOfPeople) {
		lookForTypeOfRoom = true; 
		String rep = "Since you would like to make a reservation for "; 
		if (numberOfPeople == 1) {
			rep += numberOfPeople + " person,";
			rep += " would you like " + numberOfBeds[0] + " " + typeOfBeds[0] + " bed or " + numberOfBeds[0] + " " + typeOfBeds[1] + " bed?";  
		}
			
		else {
			rep += numberOfPeople + " people,"; 
			if (numberOfPeople <= 2) {
				rep += " would you like " + numberOfBeds[1] + " " + typeOfBeds[0] + " beds or " + numberOfBeds[0] + " " + typeOfBeds[1] + " bed?";  
			}
			else if (numberOfPeople == 3) {
				rep += " would you like " + numberOfBeds[1] + " " + typeOfBeds[1] + " beds or " + numberOfBeds[0] + " " + typeOfBeds[3] + " bed?";  
			}
			else if (numberOfPeople == 4) {
				rep += " would you like " + numberOfBeds[1] + " " + typeOfBeds[1] + " beds or " + numberOfBeds[1] + " " + typeOfBeds[2] + " beds?";
			}
			//more number of guests case will be handled later 
		}
		return rep; 
	}
	
	//record guest's room choice
	public static String roomChoice(String[] s) {
		int num = 0; 
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < typeOfBeds.length; j++) {
				if (s[i].equals("1") || s[i].equals("2")) {
					choiceOfRoom = s[i] + " ";
					num = Integer.parseInt(s[i]);
					numOfBeds = num; 
				}
				else if (s[i].equals(typeOfBeds[j])) {
					choiceOfRoom += typeOfBeds[j] + " "; 
					bedType = typeOfBeds[j]; 
				}
			}
		}
		if (num == 1) choiceOfRoom += "bed";
		else choiceOfRoom += "beds";
		
		return choiceOfRoom; 
	}
	
	//ask for smoking or non-smoking
	public static String askForSmoking(String[] s) {
		askForSmoking = true; 
		String[] smokingOrNot = {"Do you prefer a smoking room?", "Would you like a smoking room?"}; 
		return "Great! " + smokingOrNot[randomIndex(smokingOrNot)];
	}
	
	//record guest's smoking choice
	public static boolean smokingChoice(String[] s) {
		for (int i = 0; i < s.length; i++) {
			if (s[i].equals("yes")) {
				smoking = true;
				price+=50; 
			}
			else if (s[i].equals("no") || s[i].equals("don't")){
				smoking = false; 
			}
		}
		return smoking; 
	}
	
	public static String askForOceanView (String[] s) {
		askForOceanView = true; 
		String[] oceanViewOrNot = {"Do you prefer a room where you can see the ocean view?", "And would you prefer to have a room with a view of the ocean?"}; 
		return "Perfect! " + oceanViewOrNot[randomIndex(oceanViewOrNot)];
	}
	
	public static boolean oceanViewChoice(String[] s) {
		for (int i = 0; i < s.length; i++) {
			if (s[i].equals("yes")) {
				oceanView = true;
				price+=100; 
			}
			else if (s[i].equals("no") || s[i].equals("don't")){
				oceanView = false; 
			}
		}
		return oceanView; 
	}
	
		public static String askForBreakfast (String[] s) {
		askForBreakfast = true; 
		String[] breakfastOrNot = {"Would you like the breakfast to be included or not?", "Would you like the breakfast service?"}; 
		return "Got that! " + breakfastOrNot[randomIndex(breakfastOrNot)];
	}
	
	public static boolean breakfastChoice(String[] s) {
		for (int i = 0; i < s.length; i++) {
			if (s[i].equals("yes")) {
				breakfast = true;
				price+=20; 
			}
			else if (s[i].equals("no") || s[i].equals("don't")){
				breakfast = false; 
			}
		}
		return breakfast; 
	}
	
	public static String askForPet (String[] s) {
		askForPet = true; 
		String[] petOrNot = {"Do you have any pets with you?", "Would you like to book a pet-friendly room?"}; 
		return "Awesome! " + petOrNot[randomIndex(petOrNot)];
	}
	
	public static boolean petChoice(String[] s) {
		for (int i = 0; i < s.length; i++) {
			if (s[i].equals("yes")) {
				pet = true;
				price+=50; 
			}
			else if (s[i].equals("no") || s[i].equals("don't")){
				pet = false; 
			}
		}
		return pet; 
	}
	
	public static String askForFirstName (String[] s) {
		askForFirstName = true; 
		String[] firstName = {"May I have your first name please?", "Could you give me your first name?"}; 
		return firstName[randomIndex(firstName)];
	}
	
	public static String askForLastName (String[] s) {
		askForLastName = true; 
		String[] lastName = {"May I have your last name please?", "Could you give me your last name?"}; 
		return lastName[randomIndex(lastName)];
	}
	
	public static int generatePrice (String[] s) {
			askForPrice = true; 
			if (bedType.equals("single")) {
				price+=20 * (numOfBeds-1);
			}
			else if (bedType.equals("double")) {
				price+=30 * (numOfBeds-1);
			}
			else if (bedType.equals("queen")) {
				price+=50 * (numOfBeds-1);
			}
			else if (bedType.equals("king")) {
				price+=60 * 1;
			}
		return price; 
	}
	
	public static String askForPhoneNumber (String[] s) {
		askForPhoneNumber = true; 
		String[] phoneNumber = {" May I have your phone number please?", " Is there a phone number where you can be contacted?"}; 
		return phoneNumber[randomIndex(phoneNumber)];
	}
	
	public static String askForPaymentType (String[] s) {
		askForPaymentType = true; 
		String[] paymentType = {"Would you like to pay by Visa or Mastercard?", "How would you like to pay? Visa or Mastercard"}; 
		return "Great. Now I'll need your credit card information to reserve the room for you. " + paymentType[randomIndex(paymentType)];
	}
	
	public static String askForCardNumber (String[] s) {
		askForCardNumber = true; 
		String[] cardNumber = {"May I have your card number please?", "Could you give me your card number please?"}; 
		return cardNumber[randomIndex(cardNumber)];
	}
	
	public static String askForCardHolder(String[] s) {
		askForCardHolder = true; 
		String[] cardHolder = {"And what is the name of the cardholder?", "And could you give me the name of the cardholder please?"}; 
		return cardHolder[randomIndex(cardHolder)];
	}
	
	public static String confirmReservation(String[] s) {
		confirmation = true; 
		String smk = "";
		if (smoking == false) smk = "non-smoking";
		else smk = "smoking-permitted"; 
		String pt = "";
		if (pet == false) pt = "pet-infriendly"; 
		else pt = "pet-friendly";
		String brkfst = "";
		if (breakfast == false) brkfst = "with breakfast";
		else brkfst = "with breakfast";
		String ov = "";
		if (oceanView == false) ov = "without ocean view";
		else ov = "with ocean view";
		String confirmation = "Alright, Ms./Mr. " + name.toString() + ", your reservation has been made on " + date.toString() + " for a " + smk + " and " + pt + " room with " + choiceOfRoom + " and " + ov + " and " + brkfst + ". Check-in is at 2 o'clock. If you have any other questions, please do not hesitate to call us. " ; 
		return confirmation; 
	}
	//prompt an error message
	public static String errorMessage() {
		return "Sorry, I don't understand your last message. Would you mind repeating that for me again?"; 
	}

	//generate a random index to make the dialogue more dynamic 
	public static int randomIndex (String[] s) {
	    return (int)Math.floor(Math.random()*(s.length-1-0+1)+0); 
	}
	
	public static String[] parseString(String s) {
		String[] tokens = s.split("\\s+");
		return tokens;
	}
	
	public static boolean finishDialogue(String s) {
		
		return finishing; 
	}
	
	public static void main(String[] args) {
		System.out.println("Ryan: Good morning. Welcome to Sunshine Hotel. This is Ryan speaking. How may I help you?"); 
		Scanner sc = new Scanner(System.in);
		System.out.print("You: ");
		String s = sc.nextLine().toLowerCase();
		while (true) {
			if (!s.contains("thank you")) {
				System.out.print("Ryan: ");
				System.out.println(response(s)); 
				System.out.print("You: ");
				s = sc.nextLine().toLowerCase();
			}
			else {
				String endMessage = "My pleasure. Ms./Mr. " + name + ". Have a nice day and I'm looking forward to seeing you soon.";
				System.out.print("Ryan: " + endMessage);
				break; 
			}
		}
	}

}
