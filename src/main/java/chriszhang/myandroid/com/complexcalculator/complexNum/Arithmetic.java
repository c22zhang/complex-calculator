/**
 * Does arithmetic (addition, subtraction, multiplication, division) with real and complex numbers
 * @author Chris Zhang
 */

package complexNum;

import java.text.*;

public class Arithmetic{
	
	public static double roundDouble(double input){
		DecimalFormat formatD = new DecimalFormat("#.######");
		return Double.valueOf(formatD.format(input));
	}
  
  /**
   * adds two complex/real/integer/etc numbers together
   * @param a The first number to be added.
   * @param b The second number to be added.
   * @return The sum of the two numbers. The type of this sum is determined by the types of the inputs.
   */
  public static ComplexN addition (ComplexN a, ComplexN b){
    if(a.getImaginaryPart() + b.getImaginaryPart()!=0){
      return new ComplexN(roundDouble(a.getRealPart() + b.getRealPart()), roundDouble(a.getImaginaryPart() + b.getImaginaryPart()));
    }
    else if (a instanceof IntegerN && b instanceof IntegerN){
      return new IntegerN((int)a.getRealPart() + (int)b.getRealPart());
    }
    else if (a instanceof RationalN && b instanceof RationalN){
      return new RationalN((int)a.getNumerator() * b.getDenominator() + b.getNumerator() * a.getDenominator(), a.getDenominator() * b.getDenominator());
    }
    else{
      return new RealN(roundDouble((a.getRealPart() + b.getRealPart())));
    }
  }
  
  /**
   * subtract two complex/real/integer/etc numbers together
   * @param a The first number.
   * @param b The number subtracted from the first number.
   * @return The difference of the two numbers. The type of this difference is determined by the types of the inputs.
   * @exception ArithmeticException if the two inputs are of type NaturalN and the difference is negative.
   */  
  public static ComplexN subtraction (ComplexN a, ComplexN b) throws ArithmeticException{
    if(a.getImaginaryPart() - b.getImaginaryPart()!=0){
      return new ComplexN(roundDouble(a.getRealPart() - b.getRealPart()), roundDouble(a.getImaginaryPart() - b.getImaginaryPart()));
    }
    else if (a instanceof IntegerN && b instanceof IntegerN){
      if(a instanceof NaturalN && b instanceof NaturalN && a.getRealPart() - b.getRealPart() <0)
        throw new ArithmeticException("NaturalN cannot be less than zero");
      else{
        return new IntegerN((int)a.getRealPart() - (int)b.getRealPart());
      }
    }
    else if (a instanceof RationalN && b instanceof RationalN){
      return new RationalN((int)a.getNumerator() * b.getDenominator() - b.getNumerator() * a.getDenominator(), a.getDenominator() * b.getDenominator());
    }
    else{
      return new RealN(roundDouble((a.getRealPart() - b.getRealPart())));
    }
  }
  
  /**
   * multiplies two complex/real/integer/etc numbers together
   * @param a The first number to be multiplied.
   * @param b The second number to be multiplied.
   * @return The product of the two numbers. The type of this product is determined by the types of the inputs.
   */
  public static ComplexN multiplication (ComplexN a, ComplexN b){
    if(a.getImaginaryPart()!=0 || b.getImaginaryPart()!=0){
      double imaginaryN = roundDouble(a.getImaginaryPart() * b.getRealPart() + b.getImaginaryPart() * a.getRealPart()); //stores the imaginary part of the number while FOILing the complex polynomial
      return new ComplexN((roundDouble(a.getRealPart() * b.getRealPart()) - (a.getImaginaryPart() * b.getImaginaryPart())), imaginaryN);
    }
    else if (a instanceof IntegerN && b instanceof IntegerN){
      return new IntegerN((int)a.getRealPart() * (int)b.getRealPart());
    }
    else if (a instanceof RationalN && b instanceof RationalN){
      return new RationalN((int)a.getNumerator() * b.getNumerator(), a.getDenominator() * b.getDenominator());
    }
    else{
      return new RealN(roundDouble((a.getRealPart() * b.getRealPart())));
    }
  }
  
  /**
   * divides two complex/real/integer/etc numbers together
   * @param a The first number.
   * @param b The number that is divided from the first number.
   * @return The quotient of the two numbers. The type of this quotient is determined by the types of the inputs.
   * @exception ArithmeticException if input b is 0.
   */
  public static ComplexN division (ComplexN a, ComplexN b) throws ArithmeticException{
    if (b.getRealPart() == 0 && b.getImaginaryPart() ==0){
      throw new ArithmeticException("Divide by zero");
    }
    else if(a.getImaginaryPart()!=0 || b.getImaginaryPart()!=0){
      ComplexN conjugate = new ComplexN(b.getRealPart(), -b.getImaginaryPart());                              //represents the conjugate of the denominator -- i.e. the conjugate of a + bi is a - bi
      double bottomSquared = b.getRealPart() * b.getRealPart() + b.getImaginaryPart() * b.getImaginaryPart(); //stores the value of a^2 + b^2 aka the the bottom complex number times its conjugate for the input parameter b
      ComplexN topProduct = Arithmetic.multiplication(a, conjugate);                                          //represents the product between the numerator and the conjugate
      return new ComplexN(roundDouble(topProduct.getRealPart() / bottomSquared), roundDouble(topProduct.getImaginaryPart() / bottomSquared));
    }
    else if (a instanceof IntegerN && b instanceof IntegerN){
      return new IntegerN((int)a.getRealPart() / (int)b.getRealPart());
    }
    else if (a instanceof RationalN && b instanceof RationalN){
      return new RationalN((int)a.getNumerator() * b.getDenominator(), a.getDenominator() * b.getNumerator());
    }
    else{
      return new RealN(roundDouble((a.getRealPart() / b.getRealPart())));
    }
  }  
  
  /**
   * checks if a character is a plus or minus sign
   * @param operator The character to check.
   * @return Whether it's a plus or a minus sign.
   */
  public static boolean isAdder(char operator){
	  return (operator == '+' || operator == '-');
  }
  
  /**
   * Converts a String to a complex number object.
   * @param input The String to be converted.
   * @return The ComplexN object conversion.
   */
  public static ComplexN parseExpression(String input){
	  int spaceCnt = 0;
	  StringBuilder firstNum = new StringBuilder();
	  StringBuilder secondNum = new StringBuilder();
	  char operator = ' ';
	  for(int i = 0; i<input.length(); i++){
		  if(input.charAt(i) == ' ')
			  spaceCnt++;
		  if(spaceCnt == 0)
			  firstNum.append(input.charAt(i));
		  if(isAdder(input.charAt(i)))
			  operator = input.charAt(i);
		  if(spaceCnt == 2 && input.charAt(i) != 'i')
			  secondNum.append(input.charAt(i));
	  }
	  double firstNumber = Double.parseDouble(firstNum.toString());
	  double secondNumber = Double.parseDouble(secondNum.toString());
	  if(operator == '+')
		  return new ComplexN(firstNumber, secondNumber);
	  if(operator == '-')
		  return new ComplexN(firstNumber, -1 * secondNumber);
	  else
		  return new ComplexN(0,0);
  }
}