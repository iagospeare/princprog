import java.io.IOException;

public class Factor {
	Expr expr;
	private int termvalue;
	
	public Factor(){
		
	}
	void parse() throws Exception{
		String token = Scanner.currentToken;	
		String digits = "0123456789";
		CharSequence cs = String.valueOf(token);
		if(token == "y"){			
			Scanner.nextToken(); //consume ID terminal
			setTermvalue(2);
		}else if(token == "x"){
			Scanner.nextToken(); //consume ID terminal
			setTermvalue(1);
		}else if (token == "("){
			Scanner.nextToken(); //consume left paren
			expr = new Expr();
			expr.parse(); 
			Scanner.nextToken(); //consume right paren NOTE: UNSURE IF GOOD IDEA
		}else if (tryParseint(token)){ //integer literal?			
			Scanner.nextToken(); //consume digit
			setTermvalue(Integer.parseInt(token));
		}else{
			System.out.println("No valid terminal found");
			throw new Exception();
		}
	}
	public int exec() {
		if(expr != null){ //return value of expression
			return expr.exec();
		}
		return termvalue; //or return the value of the terminal
	}
	public void print() {
		System.out.print(Scanner.currentToken + "");
	}
	public int getTermvalue() { //exec performs this function
		return termvalue;
	}
	public void setTermvalue(int termvalue) { //suppress warning is for noobs
		this.termvalue = termvalue;
	}
	public boolean tryParseint(String value){ //why doesn't java have this
		try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
}
