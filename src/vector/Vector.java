/**
 * 
 */
package vector;

/**
 * This vector calculator receives user data to do vector calculations with operations
 * Vector Class
 * @author Vinojan Veluppilai
 * @author Hargun Bedi
 * @author Yash Kamath
 * @version 1.7
 * @since   2018-03-18
 */

public class Vector {
	
	/**
	 * @param args
	 */
	private double xComp, yComp, zComp;
	
	/**
	 * Initializes components as a 0 vector if unknown
	 */
	public Vector(){
		this.xComp = 0;
		this.yComp = 0;
		this.zComp = 0;
	}
	
	/**
	 * Initializes user requested components
	 * @param xComp is the vector's x component
	 * @param yComp is the vector's y component
	 * @param zComp is the vector's z component
	 */
	public Vector(double xComp, double yComp, double zComp){
		this.xComp = xComp;
		this.yComp = yComp;
		this.zComp = zComp;
	}
	
	/**
	 * @return the xComp
	 */
	public double getxComp() {
		return xComp;
	}
	
	/**
	 * @param xComp the xComp to set
	 */
	public void setxComp (double xComp) {
		this.xComp = xComp;
	}
	
	/**
	 * @return the yComp
	 */
	public double getyComp() {
		return yComp;
	}

	/**
	 * @param yComp the yComp to set
	 */
	public void setyComp(double yComp) {
		this.yComp = yComp;
	}

	/**
	 * @return the zComp
	 */
	public double getzComp() {
		return zComp;
	}

	/**
	 * @param zComp the zComp to set
	 */
	public void setzComp(double zComp) {
		this.zComp = zComp;
	}
	
	/* TODO ADD THESE METHODS TO THE VECTOR SUBCLASSES*/
	
	/**
	 * 
	 * @param magnitude gives the method the magnitude of the vector that needs to be converted to Cartesian
	 * @param angle in degrees  
	 * @return conversion of Geometric vector to 1D Cartesian vector using angles
	 */
	public Vector convertGeometricToCartesian1D(double magnitude, double angle) {
		double angle1 = (angle * Math.PI)/180;
		Vector A = new Vector(magnitude*Math.cos(angle1), 0, 0);
		return A;
	}
	
	/**
	 * 
	 * @param magnitude gives the method the magnitude of the vector that needs to be converted to cartesian
	 * @param angle in degrees  
	 * @return conversion of Geometric vector to 2D Cartesian vector using angles
	 */
	public Vector convertGeometricToCartesian2D(double magnitude, double angle) {
		double angle1 = (angle * Math.PI)/180;
		Vector A = new Vector(magnitude*Math.cos(angle1), magnitude*Math.sin(angle1), 0);
		return A;
	}
	
	/**
	 * 
	 * @param magnitude gives the method the magnitude of the vector that needs to be converted to cartesian
	 * @param alpha in degrees relative to x axis
	 * @param beta in degrees relative to y axis
	 * @param gamma in degrees relative to z axis
	 * @return conversion of Geometric vector to 3D Cartesian vector using angles
	 */
	public Vector convertGeometricToCartesian3D(double magnitude, double alpha, double beta, double gamma) {
		double alpha1 = Math.toRadians(alpha);
		double beta1 = Math.toRadians(beta);
		double gamma1 = Math.toRadians(gamma);
		Vector A = new Vector(magnitude*Math.cos(alpha1), magnitude*Math.cos(beta1), magnitude*Math.cos(gamma1));
		
		return A;
	}
	
	/**
	 * 
	 * @param vector1 the vector that needs to be converted 
	 * @param type 1D, 2D or 3D
	 * @param mag1 gives the maginitude of the vector being converted
	 * @return formatted conversion of Cartesian vector to Geometric vector for 1D, 2D, 3D 
	 */
	public static String Geometric(Vector vector1, String type, double mag1) {
		String answer = "";
		double mag = Double.NaN;
		if (type == "1D" || type == "2D") {
			 mag = VectorCalculations.magnitude(vector1);
			}
			if (type == "3D") {
				mag = mag1;
			}
		double angle1 = Double.NaN;
		double angle2 = Double.NaN;
		double angle3x = Double.NaN;
		double angle3y = Double.NaN;
		double angle3z = Double.NaN;
		if (type == "1D") {
			if (vector1.getxComp() < 0) {
				angle1 = 180;
			} 
			
			if (vector1.getxComp() >= 0) {
				angle1 = 0;
			}
			answer = String.format("%.2f", mag) + " at " + angle1 + "\u00b0";
		}
		
		if (type == "2D") {
			angle2 = Math.toDegrees(Math.atan(vector1.getyComp()/vector1.getxComp()));
			answer = String.format("%.2f", mag) + " at " + String.format("%.2f", angle2) + "\u00b0";
		}
		
		if (type == "3D") {
			angle3x = Math.toDegrees(Math.acos(vector1.getxComp()/mag));
			angle3y = Math.toDegrees(Math.acos(vector1.getyComp()/mag));
			angle3z = Math.toDegrees(Math.acos(vector1.getzComp()/mag));
			answer = String.format("%.2f", mag) + " at " + " (" + String.format("%.2f", angle3x)  + ", " 
			+ String.format("%.2f", angle3y)  + ", " + String.format("%.2f", angle3z)  + ") "+ "\u00b0";
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
