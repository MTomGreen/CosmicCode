package green.math;

public class Vector3Double {
	
	private double a, b, c;
	
	public Vector3Double(double x, double y, double z){
		a = x;
		b = y;
		c = z;
	}
	
	public Vector3Double(double[] doubles){
		a = doubles[0];
		b = doubles[1];
		c = doubles[2];
	}
	
	public double getX(){
		return a;
	}
	
	public double getY(){
		return b;
	}
	
	public double getZ(){
		return c;
	}
	
	@Override
	public String toString() {
		return "["+a+","+b+","+c+"]";
	}

}
