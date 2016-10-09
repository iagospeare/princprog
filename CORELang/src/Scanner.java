import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Scanner {
	private static BufferedReader in; //static input for object free access
	public static String currentToken = ""; //static current token same reason as above
	public Scanner(String filename) throws FileNotFoundException{
		in = new BufferedReader(new FileReader(filename));
		
	}
	
	
	
public static String nextToken() throws Exception{
		
		StringBuilder tokenize = new StringBuilder();		
		char c = (char) in.read();	
		while(Character.isWhitespace(c)){ //ignore whitespace
			c = (char) in.read();			
		}
		if(c == 'o'){ //check for "output"
			while(Character.isLetter(c)){				
				tokenize.append(c); //build the word "output"
				c = (char) in.read(); 
			}			
		}else if(Character.isDigit(c)){
			while(Character.isDigit(c)){				
				tokenize.append(c); //build the number
				c = (char) in.read(); 
			}	
		}else{ //otherwise it's a single character (like x, *, ( etc.			
			tokenize.append(c);
		}
		
		
		currentToken = tokenize.toString(); //set current token		
		
		return currentToken; //return token
		
	}
public static String currentToken() {
		return currentToken;	
	}
}
