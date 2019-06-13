//THOMAS DEMKOWSKI 
//44610483
package comp125;

public class SemesterResult {
	private double[] marks;

	/**
	 * instantiates array marks to contain 4 values
	 */
	public SemesterResult() {
		marks = new double[4];
	}

	/**
	 * Set the mark at index i to the mark passed as the parameter
	 * @param idx (if idx is out of bounds, return)
	 * @param mark
	 */
	public void setMark(int idx, double mark) {
		if(idx < 0 || idx >= marks.length)
			return;
		marks[idx] = Math.max(0, Math.min(100, mark));
	}

	/**
	 * assigns as many values as possible from the array
	 * passed as the parameter. If the array passed has less 
	 * than 4 values (say 3), those 3 values are copied into
	 * the first 3 values of array marks.	 * 
	 * @param m
	 */
	public void setMarks(double[] m) {
		for(int i = 0; i< m.length; i++) {
			marks[i] = m[i];
		}
	}


	/**
	 * instantiates array marks to contain 4 values,
	 * and assigns as many values as possible from the array
	 * passed as the parameter. If the array passed has less 
	 * than 4 values (say 3), those 3 values are copied into
	 * the first 3 values of array marks. (You can do this by
	 * calling setMarks)
	 * @param m
	 */
	public SemesterResult(double[] m) {
		marks = new double[4];
		setMarks(m);
	}	

	/**
	 * @return the highest mark received this semester
	 */
	//WORKING
	public double getBestMark() {
		double bestMark = 0.0;
		for(int i = 0; i < marks.length; i++) {
			if(marks[i] > bestMark)
				bestMark = marks[i];
		}
		return bestMark;
	}

	/**
	 * @return the highest grade received this semester
	 */
	public String getBestGrade() {
		double bM = getBestMark();
		String bG = getGrade(bM);
		return bG;
	}

	/**
	 * 
	 * @param idx (if idx is out of bounds, return 0.0)
	 * @return marks at index passed as parameter
	 */
	//WORKING
	public double getMark(int idx) {
		if(idx < 0 || idx >= marks.length)
			return 0;
		return marks[idx];
	}

	/**
	 * 
	 * @param idx
	 * @return grade at index passed as parameter
	 */
	public String getGrade(int idx) {
		if(idx >= 0 && idx <= marks.length)
			return getGrade(marks[idx]);
		return "Index out of bounds";
	}

	/**
	 * 
	 * @return a ***deep*** copy of the array marks
	 */
	public double[] getMarks() {
		double[] arr = new double[marks.length];
		for(int i = 0;i<marks.length;i++) {
			arr[i] = marks[i];
		}
		return arr;
	}

	/**
	 * 
	 * @param mark
	 * @return the grade corresponding to the mark passed as the parameter
	 * The grade conditions are:
	 * marks less than 50: Grade is "F"
	 * marks more than or equal to 50 and less than 65: Grade is "P"
	 * marks more than or equal to 65 and less than 75: Grade is "Cr"
	 * marks more than or equal to 75 and less than 85: Grade is "D"
	 * marks more than or equal to 85: Grade is "HD"
	 */
	public String getGrade(double mark) {
		if(mark <50)
			return "F";
		if(mark >= 50 && mark < 65)
			return "P";
		if(mark >= 65 && mark < 75)
			return "Cr";
		if(mark >= 75 && mark < 85)
			return "D";
		if(mark >= 85)
			return "HD";
		return null;
	}

	/**
	 * 
	 * @return an array containing the grades this semester
	 * in the order of marks. For example, if marks = {76.2, 56, 67.9, 91.3},
	 * the method should return the array {"D", "F", "Cr", "HD"};
	 * (you can use getGrade to get each individual grade)
	 */
	public String[] getGrades() {
		String[] arr = new String[marks.length];
		for(int i = 0; i<marks.length; i++) {
			arr[i] = getGrade(marks[i]);
		}
		return arr;
	}

	/**
	 * HD: 10
	 * D: 8.5
	 * Cr: 7.5
	 * P: 5
	 * F: 0
	 * @return
	 */
	public double getGpa() {
		double total = 0;
		double[] weight = {0, 5, 7.5, 8.5, 10};
		String[] grades = getGrades(); //get grades corresponding to marks
		String[] possibleGrades = {"F", "P", "Cr", "D", "HD"};
		for(int i=0; i < grades.length; i++) { 
			/*
			 * we are trying to get the index of the current grade
			 * in the list of possible grades
			 */
			boolean found = false;
			//check all possible grades until you find your grade
			for(int k=0; !found && k < possibleGrades.length; k++) { 
				if(grades[i].equals(possibleGrades[k])) { //FOUND :)
					total+=weight[k]; 
					found = true; //don't look for current grade any more
				}
			}
		}
		return total / marks.length;
	}

	/**
	 * 
	 * @param other
	 * @return 1 if gpa of calling object is more than that of parameter object
	 * -1 if gpa of calling object is less than that of parameter object
	 * 0 if the gpas of calling object and parameter object are the same
	 */
	public int compareTo(SemesterResult other) {
		if(getGpa() > other.getGpa())
			return 1;
		if(getGpa() < other.getGpa())
			return -1;
		return 0;
	}

	/**
	 * 
	 * @param grade
	 * @return the number of instances of the grade passed as the parameter
	 */
	public int count(String grade) {
		int count = 0;
		for(int i = 0;i<getGrades().length;i++) {
			if(grade == getGrades()[i])
				count++;
		}
		return count;
	}

	/**
	 * 
	 * @param other
	 * @return true if, for each grade (not mark),
	 * the calling object and the parameter object have
	 * the same number of instances of that grade, and false otherwise
	 * (yes, i realize that might be a little unfair to students
	 * who get marks on the higher side of a grade)
	 */
	public boolean equals(SemesterResult other) {
		String[] possibleGrades = {"F", "P", "Cr", "D", "HD"};
		for(int i=0; i < possibleGrades.length; i++) 
			if(count(possibleGrades[i]) != other.count(possibleGrades[i]))
				return false;
		return true;
	}

	/**
	 * Copy constructor, to make a deep copy of the object passed 
	 * as the parameter
	 * @param other
	 */
	public SemesterResult(SemesterResult other) {
		marks = new double[4];
		for(int i=0; i < marks.length; i++)
			marks[i] = other.marks[i];
	}

	public String toString() {
		String result = "-------------------\nRESULT\n\n";
		String[] grades = getGrades();
		for(int i=0; i < marks.length; i++)
			result+=marks[i]+" ("+grades[i]+")\n";
		return result + "-------------------";
	}
}
