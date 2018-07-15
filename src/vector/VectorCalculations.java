package vector;

import java.util.ArrayList;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 * This vector calculator receives user data to do vector calculations with operations
 * Vector Calculations Class
 * @author Vinojan Veluppilai
 * @author Hargun Bedi
 * @author Yash Kamath
 * @version 1.7
 * @since   2018-03-18
 */

public class VectorCalculations extends Vector {
	
	ArrayList <Vector> vectors = new ArrayList<Vector>();
	private static VectorCalculations vectorAnswerAdd = new VectorCalculations();
	private static VectorCalculations vectorAnswerSub = new VectorCalculations();
	private static VectorCalculations unitVector = new VectorCalculations();
	private static VectorCalculations crossAnswer = new VectorCalculations();

	/**
	 * Calls Vector class
	 */
	public VectorCalculations() {
		super();
	}
	/**
	 * @param vectors setting the arrayList from this class to one received from interface 
	 */
	public VectorCalculations(ArrayList<Vector> vectors) {
		this.vectors = vectors;
	}
	
	/**
	 * @return the vectors
	 */
	public ArrayList<Vector> getvectors() {
		return vectors;
	}

	/**
	 * @param newVectors vectors to set
	 */
	public void setvectors(ArrayList<Vector> newVectors) {
		vectors = newVectors;
	}
	
	/**
	 * @return a vector that has sum of all components from all the vectors in the arrayList
	 */
	public VectorCalculations addVector() {
		for (int index = 0; index < vectors.size(); index++) {
			
			if (index == 0) {
				vectorAnswerAdd.setxComp(vectors.get(index).getxComp());
				vectorAnswerAdd.setyComp(vectors.get(index).getyComp());
				vectorAnswerAdd.setzComp(vectors.get(index).getzComp());
			} else {
			vectorAnswerAdd.setxComp(vectorAnswerAdd.getxComp() + vectors.get(index).getxComp());
			vectorAnswerAdd.setyComp(vectorAnswerAdd.getyComp() + vectors.get(index).getyComp());
			vectorAnswerAdd.setzComp(vectorAnswerAdd.getzComp() + vectors.get(index).getzComp());
			}
		}
		return vectorAnswerAdd;
	}
	
	/**
	 * @return a vector that has difference of all components from all the vectors in the arrayList
	 */	
	public VectorCalculations subVector() {
		for (int index = 0; index < vectors.size(); index++) {
			if (index == 0) {
				vectorAnswerSub.setxComp(vectors.get(index).getxComp());
				vectorAnswerSub.setyComp(vectors.get(index).getyComp());
				vectorAnswerSub.setzComp(vectors.get(index).getzComp());
			} else {
				vectorAnswerSub.setxComp(vectorAnswerSub.getxComp() - 
						(vectors.get(index).getxComp()));
				vectorAnswerSub.setyComp(vectorAnswerSub.getyComp() - 
						(vectors.get(index).getyComp()));
				vectorAnswerSub.setzComp(vectorAnswerSub.getzComp() - 
						(vectors.get(index).getzComp()));
			}
		}
		return vectorAnswerSub;
	}
	
	/**
	 * 
	 * @param vector1 first vector 
	 * @param vector2 second vector
	 * @return a double value of the dot product between the first and second vector
	 */
	public double dotVector(Vector vector1, Vector vector2) {
		double dotAnswer;
		dotAnswer =	vector1.getxComp() * vector2.getxComp() +
					vector1.getyComp() * vector2.getyComp() +
					vector1.getzComp() * vector2.getzComp();
		return dotAnswer;
	}
	
	/**
	 * 
	 * @param vector1 first vector 
	 * @param vector2 second vector
	 * @return a vector given from cross product between the first and second vector
	 */
	public VectorCalculations crossProduct(Vector vector1, Vector vector2) {
		 crossAnswer.setxComp((vector1.getyComp() * vector2.getzComp())
				 - (vector1.getzComp()* vector2.getyComp()));
		 
		 crossAnswer.setyComp((vector1.getzComp() * vector2.getxComp()) 
				 - (vector1.getxComp()* vector2.getzComp()));
		 
		 crossAnswer.setzComp((vector1.getxComp() * vector2.getyComp()) 
				 - (vector1.getyComp()* vector2.getxComp()));
		 return crossAnswer;
	 }
	
	/**
	 * 
     * @param vector1 the vector that needs to be converted 
	 * @param type 1D, 2D or 3D
	 * @return formatted conversion of Cartesian vector to Geometric vector for 1D, 2D, 3D 
	 */
	public  String Geometric(VectorCalculations vector1, String type) {
		String answer = "";
		double mag = magnitude(vector1);
		
		
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
			
			if (Double.isNaN(angle2)) {
				angle2 = 0.0;
			}
			answer = String.format("%.2f", mag) + " at " + String.format("%.2f", angle2) + "\u00b0";
		}
		
		if (type == "3D") {
			angle3x = Math.toDegrees(Math.acos(vector1.getxComp()/mag));
			angle3y = Math.toDegrees(Math.acos(vector1.getyComp()/mag));
			angle3z = Math.toDegrees(Math.acos(vector1.getzComp()/mag));
			
			if(Double.isNaN(angle3x)) {
				angle3x = 0.0;
			}
			
			if (Double.isNaN(angle3y)) {
				angle3y = 0.0;
			}
			
			if(Double.isNaN(angle3z)) {
				angle3z = 0.0;
			}
			answer = String.format("%.2f", mag) + " at " + " (" + String.format("%.2f", angle3x)  + ", " 
			+ String.format("%.2f", angle3y)  + ", " + String.format("%.2f", angle3z)  + ") "+ "\u00b0";
			
		}
		return answer;		
	}
	
	/**
	 * @param vector1 a vector
	 * @return magnitude of vector1
	 */
	public static double magnitude(Vector vector1) {
		double magnitude1 = Math.sqrt((vector1.getxComp() * vector1.getxComp())
				+ (vector1.getyComp()*vector1.getyComp()) 
				+ (vector1.getzComp()*vector1.getzComp()));
		
		double magnitude = (double) Math.round(magnitude1 * 100)/100;
		return magnitude;
	}
	

	/**
	 * @param vector1 a vector
	 * @return unit vector of vector1
	 */
	public VectorCalculations unitVector(Vector vector1) {
		double mag = magnitude(vector1);
		double unitMag = 1/mag;
		unitVector.setxComp((unitMag * vector1.getxComp()));
		unitVector.setyComp((unitMag * vector1.getyComp()));
		unitVector.setzComp((unitMag * vector1.getzComp()));
		return unitVector;
	}
	
	/**
	 * @param vector1 the first vector
	 * @param vector2 the second vector
	 * @return angle between the first and second vector
	 */
	public double angleBetween(Vector vector1, Vector vector2) {
		double dot = dotVector(vector1, vector2);
		double mag1 = magnitude(vector1);
		double mag2 = magnitude(vector2);
		double answer = 0;
		answer = Math.toDegrees(((Math.acos((dot)/(mag1*mag2)))));
		return answer;
	}
	
	/**
	 * @param vector1 the first vector
	 * @param vector2 the second vector
	 * @return projection of vector1 on vector2
	 */

	public double projection(Vector vector1, Vector vector2) {
		
		double dotAnswer = dotVector(vector1, vector2);
		double mag = magnitude(vector2);
		double proj = dotAnswer/mag;
		return proj;
	}

	/**
	 * @param type 1D or 2D or 3D
	 * @return convert/compile added components to String value for addition method
	 */
	public String toString(String type) {
		String info = "";
		if (type == "1D") {		
			info = "[" + vectorAnswerAdd.getxComp() + "]";	
		} else if (type == "2D") {
			info = "[" + vectorAnswerAdd.getxComp() + ", " + vectorAnswerAdd.getyComp() + "]";
		} else if (type == "3D") {
			info = "[" + vectorAnswerAdd.getxComp() + ", " + vectorAnswerAdd.getyComp() + ", " 
					+ vectorAnswerAdd.getzComp() + "]";
		}
		return info;
	}
	
	/**
	 * @param type 1D or 2D or 3D
	 * @return convert/compile subtracted components to String value for subtraction method
	 */
	public String toString1(String type) {
		String info = "";	
		if (type == "1D") {		
			info = "[" + vectorAnswerSub.getxComp() + "]";
		} else if (type == "2D") {
			info = "[" + vectorAnswerSub.getxComp() + ", " + vectorAnswerSub.getyComp() + "]";
		} else if (type == "3D") {
			info = "[" + vectorAnswerSub.getxComp() + ", " + vectorAnswerSub.getyComp() 
					+ ", " + vectorAnswerSub.getzComp() + "]";
		}
		return info;
	}
	
	/**
	 * @param type 1D or 2D or 3D
	 * @return convert/compile cross product components to String value for cross product method
	 */
	public String toString2(String type) {
		String info = "";	
		if (type == "1D") {
			JOptionPane.showMessageDialog(null, "Error", "Cannot do cross product for 1D", 0);
		} else if (type == "2D") {	
			JOptionPane.showMessageDialog(null, "Error", "Cannot do cross product for 2D", 0);
		} else if (type == "3D") {
			info = "[" + crossAnswer.getxComp() + ", " + crossAnswer.getyComp() 
					+ ", " + crossAnswer.getzComp() + "]";
		}
		return info;
	}
	/**
	 * @param type 1D or 2D or 3D
	 * @return convert/compile unit vector components to String value for unit Vector method
	 */
	public String toString3(String type) {
		String info = "";
		if (type == "1D") {
			info = "[" + String.format("%.2f",unitVector.getxComp()) + "]";
		} else if (type == "2D") {
			info = "[" + String.format("%.2f",unitVector.getxComp()) + ", " 
					+ String.format("%.2f",unitVector.getyComp()) + "]";
		} else if (type == "3D") {
			info = "[" + String.format("%.2f",unitVector.getxComp()) + ", " 
					+ String.format("%.2f",unitVector.getyComp())
					+ ", " + String.format("%.2f",unitVector.getzComp()) + "]";
		}
		return info;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
