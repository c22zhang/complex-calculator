/**
 * This class represents a rational number that can be written as the ratio of two numbers such as a/b
 * @author Chris Zhang
 */

package complexNum;

public class RationalN extends RealN{
  
  /**
  /*represents the numerator of the rational number
   */
  private int numerator;
  
  /**
   * represents the denominator of the rational number
   */
  private int denominator;
  
  /**
   * initializes new RationalN class that represents a number that can be represented by a numerator divided by a denominator
   * @param numerator The numerator of the object.
   * @param denominator The deonominator of the object.
   * @exception ArithmeticException when denominator is set as zero.
   */
  public RationalN(int numerator, int denominator)throws ArithmeticException{
    super((double)numerator/denominator);
    this.numerator = numerator;
    this.denominator = denominator;
    if (this.denominator == 0)
      throw new ArithmeticException("Divide by zero");
  }
  
  /**
   * returns the numerator
   * @return numerator
   */
  @Override
  public int getNumerator(){
    return this.numerator;
  }
  
  /**
   * returns the denominator
   * @return denominator
   */
  @Override
  public int getDenominator(){
    return this.denominator;
  }
  
  /**
   * method for finding the greatest common denominator between the numerator and the denominator
   * @return gcd Returns the eventual greatest common denominator
   */
  public int gcd (){
    int num = getNumerator(); // stores the numerator into a local variable num
    int gcd = getDenominator();// stores te denominator into a local variable gcd -- after the loop has finished iterating, this value will store the value of the greatest common denominator
    /*
     * this loop represents Euclid's algorithm for the greatest common denominator between two numbers
     * if the remainder between num and gcd is 0, gcd is the greatest common denominator
     * this loop will iterate, finding the remainder between the two numbers until it is 0
     */
    while (num % gcd !=0){
      int oldNum = num; //oldNum1 stores the previous value of Num1 
      num = gcd;
      gcd = oldNum % gcd;
    }
    return Math.abs(gcd);
  }
  
  /**
   * returns the String representation of the rational number in fractional form a/b
   * @return A string representation of the rational number as a fraction.
   */
  @Override
  public String toString (){
    if (getNumerator() !=0)
      return (getNumerator() / Math.abs(this.gcd())) + "/" + (getDenominator() / Math.abs(this.gcd()));
    else
      return "0";
  }
  
}