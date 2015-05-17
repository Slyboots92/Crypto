package aes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileMaintenance {
	
	public static String loadContentString(String filePath){
		
		File file = new File(filePath);
		String result="";
		if(!file.exists()){
			throw new NullPointerException();
		}
		else{
			Scanner scanner;
			try {
				scanner = new Scanner(file);
				while(scanner.hasNextLine()){
					result+=scanner.nextLine();
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}
	
public static ArrayList<String> loadContentList(String filePath){
		
		File file = new File(filePath);
		ArrayList<String> result = new ArrayList<String>();
		if(!file.exists()){
			throw new NullPointerException();
		}
		else{
			Scanner scanner;
			try {
				scanner = new Scanner(file);
				while(scanner.hasNextLine()){
					result.add(scanner.nextLine());
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}

}
