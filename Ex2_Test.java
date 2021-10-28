

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ex2_Test {   //TZ - 208514265 NADAV MOYAL
	static double[] po1={2,0,3,-1,0},po2 = {0.1,0,1, 0.1,3},po3= {-5,3,0,1},po4= {0,-1.9,3,7,0.6};
	static final double EPS = 0.0001 ,EPS1=0.01;
//po1 =-x^3+3x^2+2  po2 = +3x^4+0.1x^3+x^2+0.1 po3= x^3+3x-5
	@Test
	void testF() {  //TZ - 208514265 NADAV MOYAL
		//ts_1
		double fx0 = Ex2.f(po1, 0); 
		double fx1 = Ex2.f(po1, 1);
		double fx2 = Ex2.f(po1, 2);
		//ts_2
		double fx3 = Ex2.f(po3, 0);
		double fx4 = Ex2.f(po3, 1);
		double fx5 = Ex2.f(po3, 2);
		//ts_3
		double fx6 = Ex2.f(po2, 0);
		double fx7 = Ex2.f(po2, 7);
		double fx8 = Ex2.f(po2, 19);
		//ts_4
		double fx9 = Ex2.f(po4, 0);
		double fx10 = Ex2.f(po4, 1);
		double fx11 = Ex2.f(po4, 2);
		//ts_1
		assertEquals(fx0,2);
		assertEquals(fx1,4);
		assertEquals(fx2,6);
		//ts_2
		assertEquals(fx3,-5);
		assertEquals(fx4,-1);
		assertEquals(fx5,9);
		//ts_3
		assertEquals(fx6,0.1);
		assertEquals(fx7,7286.4);
		assertEquals(fx8,392010);
		//ts_4
		assertEquals(fx9,0);
		assertEquals(fx10,8.7);
		assertEquals(fx11,73.8);
	}

	@Test
	void testRoot() {  //TZ - 208514265 NADAV MOYAL
   //ts_1
		double x12 = Ex2.root(po1, 0, 10, EPS);
		assertEquals(x12, 3.1958,0.001);
   //ts_2
		double x11 = Ex2.root(po3, 1, 2, EPS1);
		assertEquals(x11,  1.15625,0.001);
	}

	@Test
	void testDerivativeArrayDoubleArray() { //TZ - 208514265 NADAV MOYAL	
	//ts_1	
	    double[] p = {1,2,3}; // 3X^2+2x+1
		double[] dp1 = {2,6}; // 6x+2
	    double[] dp2 = Ex2.derivative(p);
		for (int i=0;i<dp1.length;i++)
	    assertEquals(dp1[0], dp2[0],EPS);

	//ts_2
		double[] nig = {0,6,-3}; //-3x^2+6x
		double[] dp3 = Ex2.derivative(po1);
		for (int i=0;i<nig.length;i++)
		assertEquals(dp3[i], nig[i],EPS);
	
    //ts_3	
		double[] nigz = {3,0,3}; //3x^2+3	
		double[] dp4 = Ex2.derivative(po3);
		for (int i=0;i<nigz.length;i++)
		assertEquals(dp4[i], nigz[i],EPS);
	
	}
	@Test
	void Test_Add() {  //TZ - 208514265 NADAV MOYAL
		//ts_1
		double [] merge =Ex2.add(po1,po2); //(-x^3+3x^2+2)+(+3x^4+0.1x^3+x^2+0.1)
		double [] exp = {2.1,0,4,-0.9,3}; //3x^4-0.9x^3+4x^2+2.1
        for (int i=0;i<exp.length;i++)
			assertEquals(merge[i],exp[i],EPS);
    	//ts_2
        double [] merge1 =Ex2.add(po1,po3); // (-x^3+3x^2+2)+(x^3+3x-5)
		double [] exp1 = {-3,3,3};   // 3x^2+3x-3
		 for (int i=0;i<exp1.length;i++) 
			assertEquals(merge1[i],exp1[i],EPS);
		//ts_3
	     double [] merge3 =Ex2.add(po1,po4); //(-x^3+3x^2+2)+(0.6x^4+7x^3+3x^2-1.9x)
	     double [] exp3 = {2,-1.9,6,6,0.6}; //0.6x^4+6x^3+6x^2-1.9x+2
		  for (int i=0;i<exp3.length;i++) 
			assertEquals(merge3[i],exp3[i],EPS);
	    //ts_4
		 double [] merge4 =Ex2.add(po2,po3); // (+3x^4+0.1x^3+x^2+0.1)+(x^3+3x-5)
	     double [] exp4 = {-4.9,3,1,1.1,3}; //3x^4+1.1x^3+x^2+3x-4.9
		  for (int i=0;i<exp3.length;i++) 
		     assertEquals(merge4[i],exp4[i],EPS);
			 	 
		 
	}
	@Test 
	void Test_poly() {   //TZ - 208514265 NADAV MOYAL
	//ts_1
	 String s =Ex2.poly(po1); // (-x^3+3x^2+2)
	  assertEquals(s,"-1.0x^3+3.0x^2+2.0");	
	//ts_2
	 String g =Ex2.poly(po2); //(+3x^4+0.1x^3+x^2+0.1)
	  assertEquals(g,"+3.0x^4+0.1x^3+1.0x^2+0.1");
	//ts_3
	 String t =Ex2.poly(po3); //(x^3+3x-5)
	  assertEquals(t,"+1.0x^3+3.0x-5.0");	
	//ts_4
	 String d =Ex2.poly(po4); //(0.6x^4+7x^3+3x^2-1.9x)
	assertEquals(d,"+0.6x^4+7.0x^3+3.0x^2-1.9x");
	 
	}
	@Test
	void Test_Mul() {   //TZ - 208514265 NADAV MOYAL
		//ts_1
		double [] yuv =Ex2.mul(po1,po2); // (-x^3+3x^2+2)(+3x^4+0.1x^3+x^2+0.1)
		double [] al = {0.2,0,2.3,0.1,9,-0.7,8.9,-3}; //-3x^7+8.9x^6-0.7x^5+9x^4+0.1x^3+2.3x^2+0.2
	   for (int i=0;i<al.length;i++)
			assertEquals(yuv[i],al[i],EPS);
	    //ts_2
		double [] yuv1 =Ex2.mul(po1,po3); // (-x^3+3x^2+2)(x^3+3x-5)
		double [] al1 = {-10,6,-15,16,-3,3,-1}; //-x^6+3x^5-3x^4+16x^3-15x^2+6x-10
	  for (int i=0;i<al1.length;i++)
			assertEquals(yuv1[i],al1[i],EPS);
	   //ts_3
		double [] yuv2 =Ex2.mul(po2,po3); //  (+3x^4+0.1x^3+x^2+0.1)(x^3+3x-5)
		double [] al2 = {-0.5,0.3,-5,2.6,-14.7,10,0.1,3}; //3x^7+0.1x^6+10x^5-14.7x^4+2.6x^3-5x^2+0.3x-0.5
	  for (int i=0;i<al2.length;i++)
			assertEquals(yuv2[i],al2[i],EPS);
	   //ts_4 
		double [] yuv3 =Ex2.mul(po3,po4);  //(x^3+3x-5)(0.6x^4+7x^3+3x^2-1.9x)
		double [] al3 = {0,9.5,-20.7,-26,16.1,4.8,7,0.6}; // 0.6x^7+7x^6+4.8x^5+16.1x^4-26x^3-20.7x^2+9.5x
      for (int i=0;i<al3.length;i++)
	        assertEquals(yuv3[i],al3[i],EPS);
	}
	}
	
	



