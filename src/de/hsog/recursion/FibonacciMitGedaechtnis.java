package de.hsog.recursion;

import java.text.DecimalFormat;

class FibonacciMitGedaechtnis {
	private long ged[]; // Ged�chtnis

	public FibonacciMitGedaechtnis(int max) {
		ged = new long[max]; //
	}

	public long fibonacci(int n) {
		// requires 0 <= n < max == ged.length
		if (ged[n] != 0) // schon errechnet
			return ged[n];
		else if (n < 2) { // 0 oder 1
			ged[n] = n;
			return ged[n];
		}
		else
			ged[n] = fibonacci(n - 1) + fibonacci(n - 2);
		return ged[n];
	}
	
	public static void main(String args[]) {
		FibonacciMitGedaechtnis fibMitGed = new FibonacciMitGedaechtnis(50);
		DecimalFormat df = new DecimalFormat("###,###,##0");
		
		// Einfache Zeitmessung
		final long timeStart = System.currentTimeMillis(); 
		
		System.out.println("Fibonacci mit Ged�chtnis: " + df.format(fibMitGed.fibonacci(45)));
				
		final long timeEnd = System.currentTimeMillis();
        System.out.println("Ben�tigte Zeit: " + df.format((timeEnd - timeStart)) + " Millisek."); 
	}
}

