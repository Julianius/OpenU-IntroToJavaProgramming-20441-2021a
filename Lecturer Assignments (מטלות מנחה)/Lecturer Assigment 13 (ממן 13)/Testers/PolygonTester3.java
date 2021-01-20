package com.openu_2020.maman13;

public class PolygonTester3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("********** Test Q1 Polygon - Start **********");

        System.out.println("Test constructor");
		Polygon p = new Polygon();
		String epmtyPolygon = "The polygon has 0 vertices.";
		if(p.toString().equals(epmtyPolygon)){
			System.out.println("\t OK - expected p.toString()=\"The polygon has 0 vertices.\" ; actual=" + p.toString());
		}
		else{
			System.out.println("\t ERROR - expected p.toString()=\"The polygon has 0 vertices.\" ; actual=" + p.toString());
		}
		System.out.println("Test addVertex");
		
		if(p.addVertex(3, 3) == true){
			System.out.println("\t OK - expected p.addVertex()=true ; actual=" + p.addVertex(3, 3));
		}
		else{
			System.out.println("\t ERROR - expected p.addVertex()=true ; actual=" + p.addVertex(3, 3));
		}
		
		p.addVertex(3, 3);
		p.addVertex(6, 2);
		p.addVertex(7, 5);
		p.addVertex(6, 7);
		p.addVertex(4, 6);
		p.addVertex(3, 3);
		p.addVertex(6, 2);
		p.addVertex(7, 5);
		p.addVertex(6, 7);
		p.addVertex(4, 6);
		if(p.addVertex(0, 0) == false){
			System.out.println("\t OK - expected p.addVertex()=false ; actual=" + p.addVertex(0, 0));
		}
		else{
			System.out.println("\t ERROR - expected p.addVertex()=false ; actual=" + p.addVertex(0, 0));
		}
		
		System.out.println("Test toString");
		
		p = new Polygon();
		String polygonToString = "The polygon has 0 vertices.";
		if(p.toString().equals(polygonToString)){
			System.out.println("\t OK - expected p.toString() = The polygon has 0 vertices. ; actual = " + p.toString());
		}
		else{
			System.out.println("\t ERROR - expected p.toString() = The polygon has 0 vertices. ; actual = " + p.toString());
		}
		
		p.addVertex(3, 3);
		p.addVertex(6, 2);
		p.addVertex(7, 5);
		p.addVertex(6, 7);
		p.addVertex(4, 6);
		polygonToString = "The polygon has 5 vertices:\n((3.0,3.0),(6.0,2.0),(7.0,5.0),(6.0,7.0),(4.0,6.0))";
		if(p.toString().equals(polygonToString)){
			System.out.println("\t OK - expected and actual = " + p.toString());
		}
		else{
			System.out.println("\t ERROR - expected p.toString() = The polygon has 5 vertices:\n((3.0,3.0),(6.0,2.0),(7.0,5.0),(6.0,7.0),(4.0,6.0)) \n \t actual = " + p.toString());
		}
		
		System.out.println("Test calcPerimeter");
		if(p.calcPerimeter() == 13.95896893550472){
			System.out.println("\t OK - expected p.calcPerimeter() = 13.95896893550472 ; actual=" + p.calcPerimeter());
		}
		else{
			System.out.println("\t ERROR - expected p.calcPerimeter() = 13.95896893550472 ; actual=" + p.calcPerimeter());
		}
		
		p = new Polygon();
		p.addVertex(3, 3);
		p.addVertex(6, 3);
		if(p.calcPerimeter() == 3){
			System.out.println("\t OK - expected p.calcPerimeter() = 3.0 ; actual=" + p.calcPerimeter());
		}
		else{
			System.out.println("\t ERROR - expected p.calcPerimeter() = 3.0 ; actual=" + p.calcPerimeter());
		}
		
		p = new Polygon();
		if(p.calcPerimeter() == 0){
			System.out.println("\t OK - expected p.calcPerimeter() = 0.0 ; actual=" + p.calcPerimeter());
		}
		else{
			System.out.println("\t ERROR - expected p.calcPerimeter() = 0.0 ; actual=" + p.calcPerimeter());
		}
		
		p.addVertex(3, 3);
		if(p.calcPerimeter() == 0){
			System.out.println("\t OK - expected p.calcPerimeter() = 0.0 ; actual=" + p.calcPerimeter());
		}
		else{
			System.out.println("\t ERROR - expected p.calcPerimeter() = 0.0 ; actual=" + p.calcPerimeter());
		}
		
		p = new Polygon();
		p.addVertex(1, 1);
		p.addVertex(2, 0);
		p.addVertex(3, 1);
		p.addVertex(4, 2);
		p.addVertex(3, 4);
		p.addVertex(2, 6);
		p.addVertex(1, 5);
		p.addVertex(0, 4);
		
		if(p.calcPerimeter() == 14.705481427033437){
			System.out.println("\t OK - expected p.calcPerimeter() = 14.705481427033437 ; actual=" + p.calcPerimeter());
		}
		else{
			System.out.println("\t ERROR - expected p.calcPerimeter() = 14.705481427033437 ; actual=" + p.calcPerimeter());
		}
		
		System.out.println("Test calcArea");
		if(p.calcArea() == 12.999999999999996){
			System.out.println("\t OK - expected p.calcArea() = 12.999999999999996 ; actual=" + p.calcArea());
		}
		else{
			System.out.println("\t ERROR - expected p.calcArea() = 12.999999999999996 ; actual=" + p.calcArea());
		}
		
		p = new Polygon();
		p.addVertex(5, 3);
		p.addVertex(6, 4);
		p.addVertex(4, 4);
		if(p.calcArea() == 0.9999999999999996){
			System.out.println("\t OK - expected p.calcArea() = 0.9999999999999996 ; actual=" + p.calcArea());
		}
		else{
			System.out.println("\t ERROR - expected p.calcArea() = 0.9999999999999996 ; actual=" + p.calcArea());
		}
		p = new Polygon();
		p.addVertex(3,3);
		p.addVertex(4,2);
		p.addVertex(6,3);
		p.addVertex(5,4);
		p.addVertex(4,4);
		
		if(p.calcArea() == 3.499999999999999){
			System.out.println("\t OK - expected p.calcArea() = 3.499999999999999 ; actual=" + p.calcArea());
		}
		else{
			System.out.println("\t ERROR - expected p.calcArea() = 3.499999999999999 ; actual=" + p.calcArea());
		}
		
		p = new Polygon();
		p.addVertex(3, 3);
		p.addVertex(6, 2);
		p.addVertex(7, 5);
		p.addVertex(6, 7);
		p.addVertex(4, 6);
		
		if(p.calcArea() == 12.500000000000007){
			System.out.println("\t OK - expected p.calcArea() = 12.500000000000007 ; actual=" + p.calcArea());
		}
		else{
			System.out.println("\t ERROR - expected p.calcArea() = 12.500000000000007 ; actual=" + p.calcArea());
		}
		
		System.out.println("Test isBigger");
		
		Polygon p1 = new Polygon();
		p1.addVertex(3,3);
		p1.addVertex(4,2);
		p1.addVertex(6,3);
		p1.addVertex(5,4);
		p1.addVertex(4,4);
		
		if(p.isBigger(p1)){
			System.out.println("\t OK - expected p.isBigger(p1) = true ; actual=" + p.isBigger(p1));
		}
		else{
			System.out.println("\t ERROR - expected p.isBigger(p1) = true ; actual=" + p.isBigger(p1));
		}
		
		p = new Polygon();
		p.addVertex(1, 1);
		p.addVertex(2, 0);
		p.addVertex(3, 1);
		p.addVertex(4, 2);
		p.addVertex(3, 4);
		p.addVertex(2, 6);
		p.addVertex(1, 5);
		p.addVertex(0, 4);
		
		if(p.isBigger(p1)){
			System.out.println("\t OK - expected p.isBigger(p1) = true ; actual=" + p.isBigger(p1));
		}
		else{
			System.out.println("\t ERROR - expected p.isBigger(p1) = true ; actual=" + p.isBigger(p1));
		}
		
		p1 = new Polygon();
		p1.addVertex(3, 3);
		p1.addVertex(6, 2);
		p1.addVertex(7, 5);
		p1.addVertex(6, 7);
		p1.addVertex(4, 6);
		
		if(p.isBigger(p1)){
			System.out.println("\t OK - expected p.isBigger(p1) = true ; actual=" + p.isBigger(p1));
		}
		else{
			System.out.println("\t ERROR - expected p.isBigger(p1) = true ; actual=" + p.isBigger(p1));
		}
		
		if(!p1.isBigger(p)){
			System.out.println("\t OK - expected p1.isBigger(p) = false ; actual=" + p1.isBigger(p));
		}
		else{
			System.out.println("\t ERROR - expected p1.isBigger(p) = flase ; actual=" + p1.isBigger(p));
		}
		
		p = new Polygon();
		p1 = new Polygon();
		
		if(!p1.isBigger(p)){
			System.out.println("\t OK - expected p1.isBigger(p) = false ; actual=" + p1.isBigger(p));
		}
		else{
			System.out.println("\t ERROR - expected p1.isBigger(p) = flase ; actual=" + p1.isBigger(p));
		}
		
		System.out.println("Test findVertex");
		
		p = new Polygon();
		p.addVertex(1, 1);
		p.addVertex(2, 0);
		p.addVertex(3, 1);
		p.addVertex(4, 2);
		p.addVertex(3, 4);
		p.addVertex(2, 6);
		p.addVertex(1, 5);
		p.addVertex(0, 4);
		
		Point testP = new Point(3,1);
		if(p.findVertex(testP) == 2){
			System.out.println("\t OK - expected p.findVertex(testP) = 2 ; actual=" + p.findVertex(testP));
		}
		else{
			System.out.println("\t ERROR - expected p.findVertex(testP) = 2 ; actual=" + p.findVertex(testP));
		}
		
		testP = new Point(3, 4);
		
		if(p.findVertex(testP) == 4){
			System.out.println("\t OK - expected p.findVertex(testP) = 4 ; actual=" + p.findVertex(testP));
		}
		else{
			System.out.println("\t ERROR - expected p.findVertex(testP) = 4 ; actual=" + p.findVertex(testP));
		}
		
		testP = new Point(13, 4);
		
		if(p.findVertex(testP) == -1){
			System.out.println("\t OK - expected p.findVertex(testP) = -1 ; actual=" + p.findVertex(testP));
		}
		else{
			System.out.println("\t ERROR - expected p.findVertex(testP) = -1 ; actual=" + p.findVertex(testP));
		}
		
		System.out.println("Test getNextVertex");
		
		if(p.getNextVertex(testP) == null){
			System.out.println("\t OK - expected p.getNextVertex(testP) = null ; actual=" + p.getNextVertex(testP));
		}
		else{
			System.out.println("\t ERROR - expected p.getNextVertex(testP) = null ; actual=" + p.getNextVertex(testP));
		}
		
		testP = new Point(4,2);
		if(p.getNextVertex(testP).equals(new Point(3, 4))){
			System.out.println("\t OK - expected p.getNextVertex(testP) = (3.0,4.0)) ; actual=" + p.getNextVertex(testP));
		}
		else{
			System.out.println("\t ERROR - expected p.getNextVertex(testP) = (3.0,4.0)) ; actual=" + p.getNextVertex(testP));
		}
		
		testP = new Point(0,4);
		if(p.getNextVertex(testP).equals(new Point(1,1))){
			System.out.println("\t OK - expected p.getNextVertex(testP) = (1.0,1.0)) ; actual=" + p.getNextVertex(testP));
		}
		else{
			System.out.println("\t ERROR - expected p.getNextVertex(testP) = (1.0,1.0)) ; actual=" + p.getNextVertex(testP));
		}
		
		p = new Polygon();
		if(p.getNextVertex(testP) == null){
			System.out.println("\t OK - expected p.getNextVertex(testP) = null ; actual=" + p.getNextVertex(testP));
		}
		else{
			System.out.println("\t ERROR - expected p.getNextVertex(testP) = null ; actual=" + p.getNextVertex(testP));
		}
		
		p.addVertex(3, 1);
		
		testP = new Point(3,1);
		if(p.getNextVertex(testP).equals(new Point(3,1))){
			System.out.println("\t OK - expected p.getNextVertex(testP) = (3.0,1.0)) ; actual=" + p.getNextVertex(testP));
		}
		else{
			System.out.println("\t ERROR - expected p.getNextVertex(testP) = (3.0,1.0)) ; actual=" + p.getNextVertex(testP));
		}
		
		System.out.println("Test getBondingBox");
		
		p = new Polygon();
		p.addVertex(1, 1);
		p.addVertex(2, 0);
		p.addVertex(3, 1);
		p.addVertex(4, 2);
		p.addVertex(3, 4);
		p.addVertex(2, 6);
		p.addVertex(1, 5);
		p.addVertex(0, 4);
		
		Polygon pTest = new Polygon();
		pTest.addVertex(0, 0);
		pTest.addVertex(4, 0);
		pTest.addVertex(4, 6);
		pTest.addVertex(0, 6);
		if(equals(p.getBoundingBox(), pTest)){
			System.out.println("\t OK - expected p.getBoundingBox().equals(pTest) = true ; actual=" + equals(p.getBoundingBox(), pTest));
		}
		else{
			System.out.println("\t ERROR - expected p.getBoundingBox().equals(pTest) = true ; actual=" + equals(p.getBoundingBox(), pTest));
		}
		
		p = new Polygon();
		p.addVertex(2, 1);
		p.addVertex(5, 0);
		p.addVertex(7, 5);
		p.addVertex(4, 6);
		p.addVertex(1, 4);
		
		pTest = new Polygon();
		pTest.addVertex(1, 0);
		pTest.addVertex(7, 0);
		pTest.addVertex(7, 6);
		pTest.addVertex(1, 6);
		if(equals(p.getBoundingBox(), pTest)){
			System.out.println("\t OK - expected p.getBoundingBox().equals(pTest) = true ; actual=" + equals(p.getBoundingBox(), pTest));
		}
		else{
			System.out.println("\t ERROR - expected p.getBoundingBox().equals(pTest) = true ; actual=" + equals(p.getBoundingBox(), pTest));
		}
		
		p = new Polygon();
		p.addVertex(2, 1);
		p.addVertex(5, 0);
		p.addVertex(2, 8);
		p.addVertex(7, 5);
		p.addVertex(4, 7);
		p.addVertex(2, 6);
		p.addVertex(-1, 4);
		
		pTest = new Polygon();
		pTest.addVertex(0, 0);
		pTest.addVertex(7, 0);
		pTest.addVertex(7, 8);
		pTest.addVertex(0, 8);
		if(equals(p.getBoundingBox(), pTest)){
			System.out.println("\t OK - expected p.getBoundingBox().equals(pTest) = true ; actual=" + equals(p.getBoundingBox(), pTest));
		}
		else{
			System.out.println("\t ERROR - expected p.getBoundingBox().equals(pTest) = true ; actual=" + equals(p.getBoundingBox(), pTest));
		}
		
		System.out.println("********** Test Q1 Polygon - End **********");
	}

	private static boolean equals(Polygon p , Polygon testP){
		if(p.toString().equals(testP.toString())){
			return true;
		}
		return false;
	}
}
