//THOMAS DEMKOWSKI
//44610483

package comp125;

import psksvp.GraphPlotting.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SemesterResultClient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] m1 = new double[4];
		Random r = new Random();
		for(int i=0; i < m1.length; i++) {
			m1[i] = (100 + r.nextInt(300)) * 0.25;
		}
		SemesterResult sr1 = new SemesterResult(m1); 
		System.out.println(sr1);
		
        new SemesterResultVisualizer(sr1);
        
    	SemesterResult myResult;
		double[] arr = {40, 80, 95.6, 61.4};
		myResult = new SemesterResult(arr);
		
		System.out.println(myResult.getGpa());
		System.out.println(myResult.getBestMark());
		System.out.println(myResult.getBestGrade());
		System.out.println("Grades: ");
		for(int i = 0;i < 4;i++) {
		System.out.println(myResult.getGrades()[i]);
		}

        /*
         * Create a SemesterResult object myResult with the marks
         * 40, 80, 95.6, 61.4
         *          * 
         * invoke getGpa() and display the returned value
         * 
         * invoke getBestMark() and display the returned value
         * 
         * invoke getBestGrade() and display the returned value
         * 
         * invoke getGrades() and display the returned value
         */
	}

}
