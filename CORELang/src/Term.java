import java.io.IOException;

public class Term {
	Factor factor;
	Term term;
	String mult =  ""; //not necessary in project 1
	public Term(){
		term = null;
		factor = new Factor();
	}
	public void parse() throws Exception{
		
		factor.parse();
		if(Scanner.currentToken == "*"){
			Scanner.nextToken(); //consume terminal
			term = new Term(); //parse the following term
			term.parse(); 
		}
	}
	public int exec() {
		int result = factor.exec(); //determine factor value
		if(term != null){
			result *= term.exec(); //multiply by other term if necessary
			
		}
		return result;
	}
	public void print() {
		factor.print();
		if(term != null){
			term.print();
		}
		
	}
}
