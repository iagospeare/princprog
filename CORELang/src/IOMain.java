import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

public class IOMain {
	public static void main(String args[]){
		String filename = args[1];		
		try {
			System.out.println("Scanner initialization");
			Scanner scan = new Scanner(filename); //build scanner
			Scanner.nextToken();//load token
			Out out = new Out(); //start by parsing out
			System.out.println("Parse");
			out.parse();
			System.out.println("Pretty print");
			out.print();
			System.out.println("Execution");
			int result = out.exec();
			System.out.print("The result is " + result);
		} catch (FileNotFoundException e) {
			System.out.print("Generic FNF Error");
			e.printStackTrace(); //DELETE THIS LATER
		} catch (IOException e) {
			System.out.print("Generic IO error");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.print("Parser found an error");
			e.printStackTrace();
		}
	}
		
}
