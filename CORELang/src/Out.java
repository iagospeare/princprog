import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Out {
		private Expr exp;
		public Out(){
			exp = null;
		}
		void parse() throws Exception{
			if(Scanner.currentToken == "output"){
				Scanner.nextToken(); //consume output					
				exp = new Expr(); ///start parsing expression
				exp.parse();				
			}
			else{
				System.out.println("does not start with output");
				throw new Exception();
			}
			if(Scanner.currentToken == ";"){
				Scanner.nextToken(); //consume semicolon
			}else{
				System.out.println("No semicolon");
				throw new Exception();
			}
		}
		void print(){
			System.out.println("output");
			exp.print();
			System.out.println(";");
		}
		public int exec(){
			return exp.exec(); //return value of expression
		}
		public Expr getExp(){
			return exp;
		}
}
