/**
 * represents a complex number of form a + bi, where a and b are doubles and i is the imaginary number
 * @author Chris Zhang
 */
package complexNum;

public class ComplexN {
  
  /**
   * represents the real number a of any complex number
   */
  private double realPart;
  
  /**
   * represents the imaginary number b of any complex number
   */
  private double imaginaryPart;
  
  /**
   * initializes object of type ComplexN
   * @param realPart  the real number a
   * @param imaginaryPart  the imaginary number b
   */
  public ComplexN(double realPart, double imaginaryPart){
    this.realPart = realPart;
    this.imaginaryPart = imaginaryPart;
  }
  
  /**
   * returns the value of the real part b for this object
   * @return the value of the real part of this complex number
   */
  public double getRealPart(){
    return this.realPart;
  }
  
  /**
   * returns the value of the imaginary part a for this object
   * @return the value of the imaginary part of this complex number
   */
  public double getImaginaryPart(){
    return this.imaginaryPart;
  }
  
  public PolarComplexNo toPolar(){
	  if(getRealPart() == 0 && getImaginaryPart() == 0)
		  return new PolarComplexNo(0, 0);
	  double amplitude = Arithmetic.roundDouble(Math.sqrt(getRealPart() * getRealPart() + getImaginaryPart() * getImaginaryPart()));
	  double phase;
	  if(getRealPart() == 0)
		  phase = Arithmetic.roundDouble(Math.PI / 2);
	  else
		  phase = Arithmetic.roundDouble(Math.atan(getImaginaryPart()/getRealPart()));
	  return new PolarComplexNo(amplitude, phase);
  }
  /**
   * returns String representation of a +/- bi of this object
   * @return String in form of a + bi if b is positive or a - bi if b is negative
   */
  @Override
  public String toString(){
    if (getImaginaryPart() >=0){
      return getRealPart() + " + " + getImaginaryPart() +"i";
    }
    else{
      return getRealPart() + " - " + -(getImaginaryPart()) + "i";
    }               
  }
  
  /**
   * @param o  the object to be compared
   * @return true if the two ComplexN objects are equal or false if they aren't
   */
  @Override
  public boolean equals(Object o){
    if(o instanceof ComplexN){
      ComplexN newNumber = (ComplexN) o; //stores the typecasted value of Object o as a ComplexN object
      return(this.getRealPart() == newNumber.getRealPart() && this.getImaginaryPart() == newNumber.getImaginaryPart());
    }     
    else{
      return false;
    }
  }
  
  /**
   * I put this method here at the top of the hierarchy so that fractional operations would work in the Arithmetic class
   * This won't actually do anything important at the top of the hierarchy since a complex number
   * doesn't specifically have a numerator or a denominator, so I'll override this in the RationalN class so it will do 
   * something useful.
   * @returns 1 because the numerator can't be determined here
   */
  public int getNumerator(){
    return 1;
  }
  
  /**
   * I put this method here at the top of the hierarchy so that fractional operations would work in the Arithmetic class
   * This won't actually do anything important at the top of the hierarchy since a complex number
   * doesn't specifically have a numerator or a denominator, so I'll override this in the RationalN class so it will do 
   * something useful.
   * @returns 1 because the denominator can't be determined here
   */
  public int getDenominator(){
    return 1;
  }
}