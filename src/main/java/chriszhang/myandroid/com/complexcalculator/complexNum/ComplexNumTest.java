package complexNum;

public class ComplexNumTest {
	
	public static void main(String[] args){
		ComplexN a = new ComplexN(13,7);
		ComplexN b = new ComplexN(5,11);
		ComplexN c = Arithmetic.addition(a, b);
		System.out.println(c);
		ComplexN d = Arithmetic.division(a, b);
		System.out.println(d);
		String test = "6.1 + 3.2i";
		String test1 = "1.2 + 2.0i";
		System.out.println(Arithmetic.parseExpression(test));
		System.out.println(Arithmetic.parseExpression(test1));
		System.out.println(Arithmetic.addition(Arithmetic.parseExpression(test), Arithmetic.parseExpression(test1)));
	}
}
