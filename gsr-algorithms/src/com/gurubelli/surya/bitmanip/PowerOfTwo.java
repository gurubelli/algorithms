package com.gurubelli.surya.bitmanip;

public class PowerOfTwo {

	public static boolean isPowerOfTwo(int n) {
        //Using bitwise &
		if (n <= 0) return false;
		if ((n & (n-1)) == 0) return true;
        return false;
    }
	
	public static boolean isPowerOfTwoR(int n) {
        //Using bitwise &
		if(n == 0) return false;
		if (n == 2 || n== 1) return true;
		if(n%2 != 0) return false;
		else return isPowerOfTwoR(n<<2);
        
    }
	
	public static boolean isPowerOfTwoBf(int n) {
		
		if (n == 0) {
			return false;
		} else { 
			while (n%2 == 0) {
				n = n /2;
			}
			return (n ==1);
		}
		  
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfTwo(3));
		System.out.println(isPowerOfTwo(0));
		System.out.println(isPowerOfTwoR(1));
		System.out.println(isPowerOfTwo(-2147483648));
		
		System.out.println(isPowerOfTwoR(3));
		System.out.println(isPowerOfTwoR(0));
		System.out.println(isPowerOfTwoR(-2147483648));
		
		
		
	}

}
