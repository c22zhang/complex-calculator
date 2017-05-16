/**
 * This class represents real numbers (non-imaginary numbers) or complex numbers with an imaginary part of 0
 * @author Chris Zhang
 */

package complexNum;

public class RealN extends ComplexN{
  
  /**
   * Creates new object of class RealN
   * @param realNumber The real number that this object represents
   */
  public RealN(double realNumber){
    super(realNumber, 0);
  }
  
  /**
   * returns a String representation of the real number
   * @return a String representation of the real number
   */
  @Override
  public String toString(){
    return getRealPart() + "";
  }
  
}