import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReadingWritingFile {
	
	static String fileName = "C:\\Users\\one\\Desktop\\TestingFile.txt";
	static String editedFileName = "C:\\Users\\one\\Desktop\\EditedFile.txt";
	static ArrayList<String> texts = new ArrayList<String>();
	
	public static void main(String args[]){
		
		//Reading the File
		try {
			// The name of the file to open.
	        //System.out.println(fileName);

	        // This will reference one line at a time
	        String line = null;

	        try {
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = new FileReader(fileName);
	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = new BufferedReader(fileReader);

	            while((line = bufferedReader.readLine()) != null) {
	                System.out.println(line);
	                texts.add(line);
	            }	
	            // Always close files.
	            bufferedReader.close();			
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" +fileName + "'");				
	        }
		}
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");					
            
        }
		
		//Writing the File:
		
		if(texts.size() > 0){
			try {
				FileWriter writer = new FileWriter(editedFileName);
				BufferedWriter bwriter = new BufferedWriter(writer);
				
				for(int i=0 ; i<texts.size() ; i++){
					bwriter.write("\""+texts.get(i)+"\"");
					bwriter.newLine();
				}
				
				bwriter.close();
				writer.close();
				System.out.println("File is Written");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
    }
}