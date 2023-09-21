package Ex1;


public class Program {

	public static void main(String[] args) {
		double res = 0;
		double num1;
		double num2;
		
		for(String i : args) {
			System.out.print(i);
		}
		
		try {
			num1 = Double.parseDouble(args[0]);
			num2 = Double.parseDouble(args[2]);
			
			if(args[1].compareTo("+")==0) {
				res = num1 + num2;
			}
			else if(args[1].compareTo("-")==0) {
				res = num1 - num2;
			}
			else if(args[1].compareTo("*")==0) {
				res = num1 * num2;
			}
			else if(args[1].compareTo("/")==0) {
				res = num1 / num2;
			}
			else if(args[1].compareTo("^")==0) {
				res = Math.pow(num1, num2);
			}
			
			if(args[1].compareTo("*")!=0 && args[1].compareTo("/")!=0 && args[1].compareTo("+")!=0 && args[1].compareTo("-")!=0 && args[1].compareTo("^")!=0){
				System.out.print("Unsupported operator");
			}else {
				System.out.print(res);
			}
			
		}
		catch(Exception e) {
			System.out.print("Invalid expression");
		}
		
		
		
	}
}
