package projectAssigned;
import projectAssigned.optionsInterface;
import java.awt.*;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class accountinterface {
	
	 



	public static void main(String[] args) throws Exception
	{
		int num=0;
		int width = 200;
        int height = 20;
        Scanner input=new Scanner(System.in);
        String h=null;
        accountinterface obj=new accountinterface();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("Sans Serif", Font.BOLD, 14));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString("COMPANY LOCKERS", 5, 15);

   
        for (int y = 0; y < height; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) {

                sb.append(image.getRGB(x, y) == -16777216 ? " " : "*");
               

            }
            

            if (sb.toString().trim().isEmpty()) {
                continue;
            }

            System.out.println(sb);
        }
       
     
		System.out.println("");
		System.out.println("");
		System.out.println("Press \"ENTER\" to continue...");
		
		promptEnterKey();
		System.out.println("                        ***********************************************************     ");
		System.out.println("                             ******************LockedMe.com*****************       ");
		System.out.println("                        ***********************************************************     ");
		System.out.println("Developed by: Elias Yacoub");
		System.out.println("");
		System.out.println("Please sign in through either of the following: ");
       	System.out.println("1. New User - Register");
       	System.out.println("2. Already Registered User - LOGIN");
       	System.out.println("If this your first time, Register");
       	System.out.println("Enter your choice:");
       	num = input.nextInt();
       	
       	
       	
       	Object loginInput;
		switch(num) {
    	case 1:	System.out.println("Register");
    	System.out.println("Please Enter Your Name");
    	String n=input.next();
    	System.out.println("Email Address:");
    	h=input.next();
    	
    	 while(true) {
    		if(isValidString(h)){
    	 
    	 break;
    		}
    		else {
    			System.out.println("Please enter a valid email:");
    			h=input.next();
    		}
    	 }
    		
    	 System.out.println("Enter Password");
    	 String pass = input.next();
    
    	 while (true) {
    		 if (validate(pass)){
    	break;
    	 }
 
         	else{
         	 System.out.println("Password should be minimum eight characters,at least one upper case letter,one number, and one special character");
         	 pass=input.next();
         	 
 		
         	}	 
    	 }
    	
    	 System.out.println("New Account Registered");
    	 
    	 try {
    		 String FiletoWrite;
    		 String FileDirectory;
    		 Scanner FileWritten=new Scanner(System.in);
    		 Scanner filedirec=new Scanner(System.in);
    		 System.out.println("Enter the directory you want to save your information in");
    		 
    		 FileDirectory=filedirec.next();
    		 System.out.println("Enter the name of textfile you want to store your account info");
    		 FiletoWrite = FileWritten.next();
    	      File directory = new File(FileDirectory);
    	      File filetowritedata=new File(directory,FiletoWrite);
		      // Step 1: Creates a Writer using FileWriter
		      FileWriter output = new FileWriter(filetowritedata);
		      
		      
		      output.write(h);
		      
		      output.write(pass);
		      
		      System.out.println("Data is stored to the database file");

		      // Step 3: Closes the writer
		      output.close();
		    }
		    catch (Exception e) {
		      e.getStackTrace();
		    }
    	 
    	 
    	 break;
		case 2:System.out.println("LOGIN");
				
				readFromFile_Login();
    			break;
   
       	}

       	System.out.println("Greetings!!");
       	optionsInterface themainoption=new optionsInterface();
       	themainoption.mainOptions();
    	
    	}
    	
    	
    	
	 

	private static void readFromFile_Login() throws IOException {
		
		System.out.println("Enter your email adress and password");
		Scanner logindetails=new Scanner(System.in);
		System.out.println("Email Address:");
		String loginEmailAddress=logindetails.next();
		System.out.println("Password:");
		String loginPassword = logindetails.next();
		try{
			char[] array = new char[26];
		
		// TODO Auto-generated method stub
			String FiletoRead;
   		 String FileDirectory;
   		 Scanner FileRead=new Scanner(System.in);
   		 Scanner filedirectory=new Scanner(System.in);
   		 System.out.println("Enter the directory you saved your account in");
   		 
   		 FileDirectory=filedirectory.next();
   		 System.out.println("Enter the name of textfile you saved your account info in");
   		 FiletoRead = FileRead.next();
   	      File directory = new File(FileDirectory);
   	      File filetoreaddata=new File(directory,FiletoRead);
		      // Step 1: Creates a reader using the FileReader
		      FileReader fileRead = new FileReader(filetoreaddata);

		      // Step 2: Reads characters
		     fileRead.read(array);
		    
		
		
		String loginConcat = loginEmailAddress.concat(loginPassword);
		char[] ch = new char[26];
		  
        // Copy character by character into array
        for (int i = 0; i < loginConcat.length(); i++) {
            ch[i] = loginConcat.charAt(i);
        }
		
		
		while(true) {
		
		if(Arrays.equals(array, ch)) {
			System.out.println("Found User");
			
			break;
		}
		else {
			System.out.println("Email address or Password don't match that in database");
			System.out.println("");
			System.out.println("Email address:");
			loginEmailAddress=logindetails.next();
			System.out.println("Password");
			loginPassword = logindetails.next();
			
		}
		
		}
		}catch (Exception e) {
		      e.getStackTrace();
		    }
		System.out.println("Logged in Successfully");
	}

	public static boolean isValidString (String emailAddress) {
	String regex = "([a-zA-Z0-9]*)@([a-zA-Z0-9]*).com";
	 
	Pattern pattern = Pattern.compile(regex);
	Matcher m = pattern.matcher(emailAddress);
	if(emailAddress == null) {
	 return false;
	}

    return m.matches();
	}
	
	public static boolean validate(String Password)
    {
        // Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
  
        // Compile the ReGex
        Pattern quest = Pattern.compile(regex);
        
     // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher match= quest.matcher(Password);
        
     
        	if(Password == null) {
       		 return false;
       		}
 
   
		return match.matches();
        
    }

  

	private static void promptEnterKey() {
		// TODO Auto-generated method stub
		 try {
             System.in.read();
         } 
         catch (IOException e) {
             e.printStackTrace();
         }
	}
	
	
	
}


		
