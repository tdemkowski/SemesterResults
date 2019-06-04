package comp125;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SemesterResultTest {

	private SemesterResult myResult, yourResult, herResult;
	
	@Before
	public void setup() {
		double[] m1 = {50.1, 49.9, 80, 90.1};
		double[] m2 = {40.1, 59.9, 99.9, 83};
		double[] m3 = {40, 66.1, 40, 50};
		myResult = new SemesterResult(m1);
		yourResult = new SemesterResult(m2);
		herResult = new SemesterResult(m3);
	}
	
	@Test
	public void testGetMark() {
		assertEquals(50.1, myResult.getMark(0), 0.01);
		assertEquals(49.9, myResult.getMark(1), 0.01);
		assertEquals(80, myResult.getMark(2), 0.01);
		assertEquals(90.1, myResult.getMark(3), 0.01);
	}
	
	@Test
	public void testGetMarks() {
		double[] result = myResult.getMarks();
		myResult.setMark(0, 0);
		assertEquals(50.1, result[0], 0.01);
		assertEquals(49.9, result[1], 0.01);
		assertEquals(80, result[2], 0.01);
		assertEquals(90.1, result[3], 0.01);
	}
	
	@Test
	public void testGetGrade() {
		assertEquals("P", myResult.getGrade(0));
		assertEquals("F", myResult.getGrade(1));
		assertEquals("D", myResult.getGrade(2));
		assertEquals("HD", myResult.getGrade(3));
	}
	
	@Test
	public void testSemesterResult() {
		myResult = new SemesterResult();
		assertEquals(4, myResult.getMarks().length);
	}

	@Test
	public void testSetMark() {
		myResult.setMark(0,  46.7);
		assertEquals(46.7, myResult.getMark(0), 0.01);
		myResult.setMark(1,  47.7);
		assertEquals(47.7, myResult.getMark(1), 0.01);
		myResult.setMark(2,  106.7);
		assertEquals(100, myResult.getMark(2), 0.01);
		myResult.setMark(3,  -46.7);
		assertEquals(0, myResult.getMark(3), 0.01);
		myResult.setMark(3,  46.7);
		myResult.setMark(4,  -43.7);
		assertEquals(46.7, myResult.getMark(3), 0.01);
		myResult.setMark(-1,  -43.7);
		assertEquals(46.7, myResult.getMark(0), 0.01);

	}

	@Test
	public void testSetMarks() {
		double[] m = {12.3, 45.6, 78.9, 90.1};
		myResult.setMarks(m);
		double[] n = myResult.getMarks();
		assertEquals(m.length, n.length);
		for(int i=0; i < n.length; i++)
			assertEquals(m[i], n[i], 0.01);
		
		double[] o = {81.4, 56.7, 65.5};
		myResult.setMarks(o);
		n = myResult.getMarks();
		assertEquals(4, n.length);
		for(int i=0; i < 3; i++)
			assertEquals(o[i], n[i], 0.01);
	}

	@Test
	public void testSemesterResultDoubleArray() {
		double[] m1 = {50.1, 49.9, 80, 90.1};
		double[] m2 = {40.1, 59.9, 99.9};
		double[] m3 = {40, 60.1, 40, 50};
		myResult = new SemesterResult(m1);
		yourResult = new SemesterResult(m2);
		herResult = new SemesterResult(m3);
		
		double[] a1 = myResult.getMarks();
		assertEquals(4, a1.length);
		double[] a2 = yourResult.getMarks();
		assertEquals(4, a2.length);
		double[] a3 = herResult.getMarks();
		assertEquals(4, a3.length);
		
		for(int i=0; i < a1.length; i++)
			assertEquals(m1[i], a1[i], 0.01);

		for(int i=0; i < m2.length; i++)
			assertEquals(m2[i], a2[i], 0.01);
		
		for(int i=0; i < a3.length; i++)
			assertEquals(m3[i], a3[i], 0.01);		
	}

	@Test
	public void testGetBestMark() {
		assertEquals(90.1, myResult.getBestMark(), 0.01);
		assertEquals(99.9, yourResult.getBestMark(), 0.01);
		assertEquals(66.1, herResult.getBestMark(), 0.01);
	}

	@Test
	public void testGetBestGrade() {
		assertEquals("HD", myResult.getBestGrade());
		assertEquals("HD", yourResult.getBestGrade());
		assertEquals("Cr", herResult.getBestGrade());
		
		double[] m = {0.1, 0.1, 0.1, 0.1};
		SemesterResult hisResult = new SemesterResult(m);
		assertEquals("F", hisResult.getBestGrade());
	}

	@Test
	public void testGetGradeDouble() {
		assertEquals("F", myResult.getGrade(0.1));
		assertEquals("F", myResult.getGrade(49.9));
		assertEquals("P", myResult.getGrade(50.1));
		assertEquals("P", myResult.getGrade(64.9));
		assertEquals("Cr", myResult.getGrade(65.1));
		assertEquals("Cr", myResult.getGrade(74.9));
		assertEquals("D", myResult.getGrade(75.1));
		assertEquals("D", myResult.getGrade(84.9));
		assertEquals("HD", myResult.getGrade(85.1));
		assertEquals("HD", myResult.getGrade(99.9));
		assertEquals("HD", myResult.getGrade(101.1));
	}

	@Test
	public void testGetGrades() {
		String[] g1 = myResult.getGrades();
		String[] g2 = yourResult.getGrades();
		String[] g3 = herResult.getGrades();
		
		String[] e1 = {"P", "F", "D", "HD"};
		String[] e2 = {"F", "P", "HD", "D"};
		String[] e3 = {"F", "Cr", "F", "P"};
		
		for(int i=0; i < g1.length; i++) {
			assertEquals(g1[i], e1[i]);
			assertEquals(g2[i], e2[i]);
			assertEquals(g3[i], e3[i]);
		}

	}

/*	@Test
	public void testGetGpa() {
		assertEquals(5.875, myResult.getGpa(), 0.01);
		assertEquals(5.875, yourResult.getGpa(), 0.01);
		assertEquals(3.125, herResult.getGpa(), 0.01);
	}
*/

	@Test
	public void testCompareTo() {
		assertEquals(0, myResult.compareTo(yourResult));
		assertEquals(1, myResult.compareTo(herResult));
		assertEquals(-1, herResult.compareTo(yourResult));
		
		double[] m1 = {65, 65, 0, 0};
		SemesterResult r1 = new SemesterResult(m1);
		
		double[] m2 = {50, 50, 50, 0};
		SemesterResult r2 = new SemesterResult(m2);
		assertEquals(0, r1.compareTo(r2));
	}

	@Test
	public void testCount() {
		assertEquals(1, myResult.count("F"));
		assertEquals(1, myResult.count("P"));
		assertEquals(1, myResult.count("D"));
		assertEquals(1, myResult.count("HD"));
		assertEquals(0, myResult.count("Cr"));
		
		assertEquals(1, yourResult.count("F"));
		assertEquals(1, yourResult.count("P"));
		assertEquals(1, yourResult.count("D"));
		assertEquals(1, yourResult.count("HD"));
		assertEquals(0, yourResult.count("Cr"));
		
		assertEquals(2, herResult.count("F"));
		assertEquals(1, herResult.count("P"));
		assertEquals(1, herResult.count("Cr"));
		assertEquals(0, herResult.count("D"));
		assertEquals(0, herResult.count("HD"));
		
		
	}

	@Test
	public void testEqualsSemesterResult() {
		assertTrue(myResult.equals(yourResult));
		assertFalse(myResult.equals(herResult));
		assertFalse(herResult.equals(yourResult));	
		
		double[] m1 = {65, 65, 0, 0};
		SemesterResult r1 = new SemesterResult(m1);
		
		double[] m2 = {50, 50, 50, 0};
		SemesterResult r2 = new SemesterResult(m2);
		assertFalse(r1.equals(r2));
	}

	@Test
	public void testSemesterResultSemesterResult() {
		yourResult = new SemesterResult(herResult);
		herResult.setMark(1, 0);
		
		double[] m = yourResult.getMarks();
		assertNotNull(m);
		assertEquals(m[0], 40, 0.01);
		assertEquals(m[1], 66.1, 0.01);
		assertEquals(m[2], 40, 0.01);
		assertEquals(m[3], 50, 0.01);
	}

}
