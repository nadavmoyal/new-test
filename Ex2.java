

public class Ex2 {  //TZ - 208514265 NADAV MOYAL
//**The function places the value of "X" within the polynomial equation "poly"
//	and returns the value of poly(x).
//	
public static double f (double[] poly, double x)  //TZ - 208514265 NADAV MOYAL
{
	   double sum = poly[0];
	   sum = sum + poly[1]*x;
		for (int i=2; i < poly.length;++i)
		{
			double v = Math.pow(x,i);
	        v = v*poly[i];
			sum=sum+v;
}
	
	return sum;

          	}
//**The function receives an array of digits and returns a String
//representing the poly polynomial.
public static String poly (double[] poly)  //TZ - 208514265 NADAV MOYAL
	{  
	String polynom= "";
	for(int i=poly.length-1 ; i>=0 ;i-- )
	{
	  if( (i==0) && (poly[i]!=0) )
	  {
		if (poly[i]>0)
		{
			polynom +="+"+poly[i];
		}
		else 
			polynom +=""+poly[i];
		}
	  else if ((i == 1) && (poly[i]!=0) )
	  {
		  if (poly[i]>0)
  		{
  			polynom +="+"+poly[i] + "x";
  		}
  		else 
  			polynom +=""+poly[i] + "x";  
	    
	  }
	
	  else if (poly[i]!=0) 
	  {
		  if  (poly[i]>0) 
    		{
    			polynom +="+"+poly[i] + "x^"+i +"";
    		}
    		else 
    			polynom +=""+poly[i] + "x^"+i +"";
		  
  	      
	  }
	}
	return polynom;

	}
//The function receives an array of digits, 2 numbers, epsilon,
//and returns the root of the function by the bisection method.
public static double root (double[] p,double x1,double x2,double eps)  //TZ - 208514265 NADAV MOYAL
{
	double c=0,pos,neg;
	double y1= f(p,x1);	 
	double y2= f(p,x2);
	if (y1>y2)
	{
	   pos=x1;
	   neg=x2;}
	   else {
		   pos=x2;
		  neg=x1;
	   }
	while ((Math.abs(pos-neg))>eps)
	{
	    c=((pos + neg)/2);
	    double fc= f(p,c);	 
         if (fc>0)
         {
        	 pos = c;
         }
	    else {
	    	neg = c;
	    }
	}
	
	return pos = Math.max(pos, neg);
}
//The function gets 2 arrays of digits (p1, p2 ), and returns a new array representing the polynom of p1+p2.
public static double[] add(double [] p1, double [] p2)  //TZ - 208514265 NADAV MOYAL
{
	int length = Math.max(p1.length,p2.length); 
	double [] mergedArray = new double [length];   
	if (p1.length >= p2.length) 
	{
		for (int s1=0;s1<p2.length;s1++)
			mergedArray [s1] =p1[s1]+p2[s1];
		
		for (int s1=p2.length;s1<p1.length;s1++)
			mergedArray [s1] =p1[s1];	
	}
		else for (int s2=0;s2<p2.length;s2++)
		mergedArray [s2] =p1[s2]+p2[s2];
     	for (int s2=p1.length;s2<p2.length;s2++)
		mergedArray [s2] =p2[s2];	
	return mergedArray;
	}
	 
//The function gets 2 arrays of digits (p1, p2 ),returns a new array representing the polynom of (p1)*(p2)
public static double[] mul(double[] p1, double[] p2)  //TZ - 208514265 NADAV MOYAL
{
	int length = (p1.length+p2.length);
	double [] MultiArray = new double [length];   
		for (int s1=0;s1<p1.length;s1++)
		{
			for (int s2=0;s2<p2.length;s2++)
				MultiArray [s2+s1] =MultiArray [s2+s1]+p1[s1]*p2[s2];	
		}
	return MultiArray;
	}

//The function receives an array of digits (po), returns a new polynom representing the derivative of (po).
	
public static double[] derivative (double[] po) {  //TZ - 208514265 NADAV MOYAL
double [] gazur = new double [po.length-1];
if (po [1]!=0) 
  gazur [0]=po [1];
for (int i=2; i<po.length;i++)
{
	gazur [i-1]=(po [i]*i);
}       
	System.out.println("hgfds");


	return gazur;
}

}
	
