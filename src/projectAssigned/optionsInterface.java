package projectAssigned;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class optionsInterface {
	
	public static void mainOptions() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Please Select one of the following options");
    	System.out.println(" -Option 1- Return the current file names in ascending order");
    	System.out.println(" -Option 2- Return the details of the user interface");
    	System.out.println(" -Option 3- Close the Application");
    	Scanner optionplaced=new Scanner(System.in);
    	int option = optionplaced.nextInt();
    	optionsInterface pickedoption=new optionsInterface();
    	switch(option) {
    	case 1:pickedoption.option1();
    	case 2:pickedoption.option2();
    	case 3:pickedoption.option3();
		
	}
	}
	
	public void option1() throws IOException {
		
		String[] pathnames;
		File directory = new File("C://Users//Public//ProjectFile");
	      
		// Populates the array with names of files and directories
	        pathnames = directory.list();

	        // For each pathname in the pathnames array
	        for (String pathname : pathnames) {
	            // Print the names of files and directories
	            System.out.println(pathname);
	}
	        System.out.println("Do you want to try other options?");
	        System.out.println("Yes-Try another option");
	        System.out.println("No-Exit the application");
	        Scanner choice=new Scanner(System.in);
			String choicepicked = choice.next();
	    	if(choicepicked.equalsIgnoreCase("No")) {
	    	     System.exit(0);
	    	     System.out.println("Goodbye");
	    	     }
	    		
	    			else if(choicepicked.equalsIgnoreCase("Yes")) {
	    				mainOptions();
	    				
	    				
	    			}
	}
	
	public static void option2() throws IOException {
		System.out.println("Pick one of the following options:");
		System.out.println("Option 1 : Add a file to the existing directory list");
		System.out.println("Option 2 : Delete a user specified file from the existing directory list");
		System.out.println("Option 3 : Search a user specified file from the main directory");
		System.out.println("Option 4 : Navigate to the main options window");
		
		Scanner op=new Scanner(System.in);
		int option2 = op.nextInt();
		switch(option2) {
    	case 1:optionAdd();
    	case 2:optionDelete();
    	case 3:optionSearch();
    	case 4:mainOptions();
    	}
	}
		
	
private static void optionSearch() throws IOException {
		// TODO Auto-generated method stub
	 String fileSpecified;
	 System.out.println("Enter the file you want to search for");
	 Scanner textFile=new Scanner(System.in);
	 
	 fileSpecified = textFile.next();
     File directory = new File("C://Users//Public//ProjectFile");  // this is used to create the file
     String[] pathnames = directory.list();
     
     if(Arrays.asList(pathnames).contains(fileSpecified))
     {
    	 System.out.println("The file is found");
     }
     else {
    	 System.out.println("The file is not found");
    	 
     }
     System.out.println("Do you want to search for more files?");
     System.out.println("Yes-Search for more files");
     System.out.println("Try-Try another option");
     System.out.println("No-Exit the Application");
     Scanner choiceSearch=new Scanner(System.in);
		String choicepicked = choiceSearch.next();
		if(choicepicked.equalsIgnoreCase("No")) {
			System.out.println("Goodbye");
			System.exit(0);
     }
		else if(choicepicked.equalsIgnoreCase("Try")) {
			
			option2();
		
		}
		else if(choicepicked.equalsIgnoreCase("Yes")) {
			optionSearch();
		}
    
	}
private static void optionDelete() throws IOException {
	String fileD;
	
	 
	 Scanner filedelete=new Scanner(System.in);
	 System.out.println("Enter the name of the file you want to delete");
	 fileD = filedelete.next();
      File directory = new File("C://Users//Public//ProjectFile");
      File filedeleted=new File(directory,fileD);
	String[] pathlist = directory.list();
	
	 if(Arrays.asList(pathlist).contains(fileD))
	{
      	filedeleted.delete();
		System.out.println("File Deleted !!");
		
			
		}
	else  {
		System.out.println("File Not Found!!");
			
		}
		

	 
	 System.out.println("Do you want to delete more files?");
	 System.out.println("Yes-Delete more files");
     System.out.println("Try-Try another option");
     System.out.println("No-Exit the Application");
     Scanner choice=new Scanner(System.in);
		String choicepicked = choice.next();
		if(choicepicked.equalsIgnoreCase("No")) {
			System.out.println("Goodbye");
			System.exit(0);
     
     }
		else if(choicepicked.equalsIgnoreCase("Try")) {
			
			option2();
		
		}
		else if(choicepicked.equalsIgnoreCase("Yes")) {
			optionDelete();
		}
	}
		// TODO Auto-generated method stub
		

private static void optionAdd() {
		// TODO Auto-generated method stub
	try {  
	
		String filename;
		Scanner filetext=new Scanner(System.in);
		System.out.println("Add a file");
		filename = filetext.next();
        File directory = new File("C://Users//Public//ProjectFile");  // this is used to create the file
        File file=new File(directory,filename);
        if (file.createNewFile()) {  
            System.out.println("New File is created!");  
        } else {                   
            if(file.exists())
            {
                System.out.println("File already exists.");	
                System.out.println("File path:" + file.getAbsolutePath());
                System.out.println("File name:  " + file.getName());
                System.out.println("File length: " + file.length());
                System.out.println("File list:   " + file.list());
                
            }
        }
        System.out.println("Do you want to continue adding files?");
        System.out.println("Yes-Add more files");
        System.out.println("Try-Try another option");
        System.out.println("No-Exit the Application");
        Scanner choiceAdd=new Scanner(System.in);
		String choicepickedAdd = choiceAdd.next();
		if(choicepickedAdd.equalsIgnoreCase("No")) {
			System.out.println("Goodbye");
            System.exit(0);
        
        }
		else if(choicepickedAdd.equalsIgnoreCase("Try")) {
			
			option2();
		
		}
		else if(choicepickedAdd.equalsIgnoreCase("Yes")) {
			optionAdd();
		}
	}catch (IOException e) {  
        e.printStackTrace();
	}
	
    }

public void option3() {
	// TODO Auto-generated method stub
	System.exit(0);
	System.out.println("Goodbye");
	
}
            
        	}
	



