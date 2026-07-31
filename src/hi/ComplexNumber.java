package hi;

import java.util.Objects;

public class ComplexNumber {
	double re;
	double im;
	
	public ComplexNumber(Double rere, Double imim) {
		// TODO Auto-generated constructor stub
		this.re = rere;
		this.im = imim;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ComplexNumber complexNumber = (ComplexNumber) o;
		return re == complexNumber.re && Objects.equals(im, complexNumber.im);
	}
	@Override
	public int hashCode() {
		return Objects.hash(re, im);
	}
	
}
