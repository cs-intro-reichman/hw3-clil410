// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
		System.out.println(minus(0,-1));
		System.out.println(minus(-4,-4));
		System.out.println(minus(-3,1));
 		System.out.println(times(3,4));  // 3 * 4
		System.out.println(times(-1,-2));
		System.out.println(times(-1,-4));
		System.out.println(times(3,-4));
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
		System.out.println(pow(-2,3));
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
		System.out.println(div(-2,2));
		System.out.println(div(-5,2));
		System.out.println(div(2,-2));  
		System.out.println(div(5,-2)); 
		System.out.println(div(11,-2));
		System.out.println(div(-8,2));
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) { 
		int sum = x1; 
		if  (x2 > 0) { 
		for (int i=0; i < x2; i++) { 
			sum++;
		}
		}
		if (x2 < 0) { 
		for (int i= x2; i < 0; i++) { 
			sum--;
			}
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int sum = x1;
		if  (x2 > 0) { 
			for (int i = 0; i < x2; i++) {
				sum--;
				}
			}
		if (x2 < 0) {
			for (int i = x2; i < 0; i++) {
				sum++;
				}
			}
		return sum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
        int multiple = 0; 
		if (x2 < 0) {
			for (int i = x2; i < 0; i++) { 
				multiple = minus(multiple, x1); 
				}
			return multiple;
		}
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) { 
				multiple = plus(multiple, x1);  
			}
			return multiple;
		}	
		return multiple;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int pow1 = 1;
		for (int i=0; i <n; i++) {
			pow1 =+ times(pow1, x); 
		}
		return pow1;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
        int count =0; // count the number of times x2 is in x1
		int num = x2; // 2
		if (x2 > 0 && x1 > 0) {
			while (num <= x1) { // <10, 4 
				count++; // 1
				num = plus(num, x2); // 2+2+2+2
			}
		}
		if (x2 > 0 && x1 < 0) {
			while (times(num,count) > x1) { //2 , -2
				count--; // -1 
			}
			if (times(num,count) == x1) {
				return count;
			}
			else {
			return (count + 1); 	
			}
		}
		if (x2 < 0) {
			while (times(num,count) < x1) { //2 , -2
				count--; // -1 
			}
			if (times(num,count) == x1) {
				return count;
			}
			else {
				return (count + 1); 
			}
			
		}
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
        int divInt = div(x1, x2); // 10, 2 = 5 ,, 11, 2 = 5 
		int modulo = 0; 
		 if (times(divInt, x2) == x1) {
			return 0;	
		 } else { 
			modulo = x1 - times(divInt, x2);
			return modulo;
		 }
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
        int numAnswer = 2; 
		int check = 0;
		boolean notSqrt = true;
		while (notSqrt) {
			check = mod(x, numAnswer);
			if (check == 0) { //if numAnswer is a divider of x
				if (times(numAnswer, numAnswer) < x) { //when num is a divider but not the sqrt
					numAnswer++; 
				} else {
					if (times(numAnswer, numAnswer) == x) { //when num is a divider and the sqrt
						notSqrt = false; 
					}
				}
			} else { //numAnswer is not a divider of x
				if (times(numAnswer, numAnswer) < x) {
					numAnswer++;
				} else { // >x
					numAnswer--;
					notSqrt = false;
				}
			}
		}	
		return numAnswer;	
	}	  	  
}