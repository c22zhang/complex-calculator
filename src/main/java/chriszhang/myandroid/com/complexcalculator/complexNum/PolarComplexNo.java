package complexNum;

/**
 * Represents a complex number in phasor/polar form in the form Ae^pi, with A = amplitude and p = phase
 * @author Chris Zhang
 */
public class PolarComplexNo {
	
	/**
	 * represents the amplitude of the polar number
	 */
	private double amplitude;
	
	/**
	 * represents the phase of the polar number
	 */
	private double phase;
	
	public PolarComplexNo(double amplitude, double phase){
		this.amplitude = amplitude;
		this.phase = phase;
	}
	
	/**
	 * @return the value of the object's amplitude 
	 */
	public double getAmplitude() {
		return amplitude;
	}
	
	/**
	 * sets the amplitude of the object
	 * @param amplitude - the amplitude of the object
	 */
	public void setAmplitude(double amplitude) {
		this.amplitude = amplitude;
	}
	
	/**
	 * returns the value of the object's phase
	 * @return value of the object's phase
	 */
	public double getPhase() {
		return phase;
	}
	
	/**
	 * returns value of the object's phase
	 * @param phase - phase of the the object
	 */
	public void setPhase(double phase) {
		this.phase = phase;
	}
	
	/**
	 * converts the polar complex number to a rectangular complex number of form a + bi
	 * @return the complex number object equivalent of the polar object
	 */
	public ComplexN toRectangular(){
		double real = Arithmetic.roundDouble(getAmplitude() * Math.cos(getPhase()));
		double imag = Arithmetic.roundDouble(getAmplitude() * Math.sin(getPhase()));
		ComplexN converted = new ComplexN(real, imag);
		return converted;
	}
	
	/**
	 * returns a string representation of the polar complex number
	 * @returns representation in form Ae^(ip)
	 */
	@Override
	public String toString(){
		if(getPhase() == 0)
			return "" + getAmplitude();
		if(getAmplitude() == 0)
			return "0";
		else
			return getAmplitude() + "e^(" + getPhase() + "i)";
	}
	
	/**
	 * @return true if the two polar complex numbers are equal
	 */
	@Override
	public boolean equals(Object o){
		if(o instanceof PolarComplexNo){
			PolarComplexNo compare = (PolarComplexNo) o;
			return (this.getAmplitude() == compare.getAmplitude() && this.getPhase() == compare.getPhase());
		}
		else{
			return false;
		}
	}
}
