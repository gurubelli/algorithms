package com.gurubelli.surya.arrays;

public class StockBuy {

	
	//https://gist.github.com/benjaminwu7
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 10, 22, 5, 75, 65, 80 };
		
		//Find out the min price has to buy and sell at what price
		// Max. benefit with single buy and sell
		//a = FileUtil.readInts();
		bruteForce(a);
		optimal(a);
		
		
	}
	
	
	private static void bruteForce(int [] a) {
		
		int maxProfit = 0;
		for(int i = 0; i < a.length ; i++) {
			for (int j = i+1; j< a.length; j++) {
				maxProfit = Math.max(maxProfit, (a[j]-a[i]));
			}
		}
		
		System.out.println("Max Profit on one day " + maxProfit);
	}

   private static void optimal(int [] a) {
	   int maxProfit = a[1] -a[0] ;
	   int minPrice = a[0];
	   for (int i = 0; i< a.length ; i++) {
		   if ( a[i] < minPrice) {
			   minPrice = a[i];
		   }
		   if ( (a[i] -minPrice) > maxProfit) {
			   maxProfit = a[i] -minPrice;
		   }
	   }
	   System.out.println("Buy price " +  minPrice);
	   System.out.println(" Maximum profit " + maxProfit);
	   
   }
}
