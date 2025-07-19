import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFileLineByLine {
	public static void main(String[] args) {
		
		//Provide the path to your file
		String filePath = "ReadFileLineByLine.java";
		
		try {
			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println("An error occurred while reading the file:");
			e.printStackTrace();
		}
	}
}