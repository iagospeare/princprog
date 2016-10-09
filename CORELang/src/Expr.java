import java.io.IOException;

public class Expr {
	private Term term;
	private Expr expr;
	private boolean plus  = false;
	private boolean minus  = false; //not necessary in project 1
	String op = ""; //not necessary in project 1
	public Expr(){
		term = new Term();
		expr = null;
	}
	public void parse() throws Exception{
		term.parse(); //always parsing a term
		if(Scanner.currentToken == "+"){ //if terminal follows term
			Scanner.nextToken(); //consume terminal
			expr = new Expr();
			expr.parse(); //parse following expression
			setPlus(true);
		}else if(Scanner.currentToken == "-"){
			Scanner.nextToken(); //consume terminal
			expr = new Expr();
			expr.parse(); //parse following expression
			setMinus(true);
		}
	}
	void print(){
		term.print();
		if(expr != null){ //if there was an expression, execute it too
			expr.print(); 
		}
		
	}
	public int exec() {
		int result = term.exec(); //execute the term and produce it's integer result
		if(expr != null){ //if there was an expression, execute it too
			
			if(plus){
				result += expr.exec();  
			}else{
				result -= expr.exec(); 
			}
		}
		return result;
	}
	public boolean isMinus() {
		return minus;
	}
	public void setMinus(boolean minus) {
		this.minus = minus;
	}
	public boolean isPlus() {
		return plus;
	}
	public void setPlus(boolean plus) {
		this.plus = plus;
	}
}
