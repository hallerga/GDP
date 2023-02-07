
public class Bigs {
	
	// addiert die Ziffernfelder a und b
	public static int[ ] add (int[ ] a, int[ ] b) { 
		
		int max = 0;
		int transfer = 0;
		
		if (a.length >= b.length)
			max = a.length+1;
		else
			max = b.length+1;
				
		int[] sum = new int[max];
		
		for (int i = 0; i < max; i++) {

				if (i>=a.length && i>= b.length) sum[i] = transfer;
					
				else if (i>=a.length) {
					sum[i] = (b[i]+transfer)%10;
					transfer = (b[i]+transfer)/10;
				}
					
				else if (i>=b.length)	{
					sum[i] = (a[i]+transfer)%10;
					transfer = (a[i]+transfer)/10;
				}
					
				else {
					sum[i] = (a[i]+b[i]+transfer)%10;
					transfer = (a[i]+b[i]+transfer)/10;
				}
		}
					
		// Führende Null entfernen
		
		if (sum[sum.length-1] == 0) {
			max = max -1;
			int[] sumfinal = new int[max];
			for (int i = 0; i<max; i++)
				sumfinal[i] = sum[i];
			
			return sumfinal;
		}
				
		else return sum;
	}
	
	
	
	// gibt das Ziffernfeld n in lesbarer dezimaler Form aus
	// bei sehr langen Zahlen soll das Format verwendet werden, welches auch von
	// bc (s.u.) benutzt wird: Umbruch nach 68 Ziffern mit einem \ am Ende
	static void print (int[ ] n) {
	
		int factor = 1;
		
			for (int i = 1; i<= n.length; i++) {
				if (i/(68*factor) == 1) {
					factor++;
					System.out.print(n[n.length-i]);
					System.out.print("\\");
					System.out.println();
				}
				else System.out.print(n[n.length-i]);
			}	
		}
	
	// konstruiert ein einstelliges Ziffernfeld aus der Ziffer d
	static int[ ] digit(int d) { 
	
		int[] digit = new int [1];
		digit[0] = d;
		return digit;
		}
		
	
	// konstruiert das Ziffernfeld, welches den Wert Null repraesentiert
	static int[ ] Null() { 

		int[] Null = {0};
		return Null;
		}
		
	
	// konstruiert das Ziffernfeld, welches den Wert Eins repraesentiert
	static int[ ] One() {
	
		int[] One = {1};
		return One;
		}
	
	// Rest des Ziffernfeldes n bei Division durch 10 (eine int-Zahl!)
	static int mod10(int[ ] n) {
	
		int mod10 = 0;
		mod10 = n[0];
		return mod10;
		}
	
	// ganzzahliger Quotient bei Division durch 10
	static int[ ] div10(int[ ] n) {
		
		int[] div10 = new int[n.length-1];
		for (int i = 0; i < div10.length; i++)
			div10[i] = n[i+1];
		return div10;
		}
	
	
	// Umwandlung einer beliebigen int-Zahl in ein Ziffernfeld
	static int[ ] fromInt(int n) {
	
		int stellen = 1;
		int zahl = n;
		
		while (zahl/10 !=0) {
			zahl = zahl / 10;
			stellen ++;
		}
			
			
		int[] ziffernfeld = new int [stellen];
		
		for (int i = 0; i < ziffernfeld.length; i++) {
			ziffernfeld[i] = n%10;
			n = n/10;
		}
					
	return ziffernfeld;
						
	}
				
	
	// kopiert den Wert von n
	static int[ ] copy(int[ ] n) { 

		int[] copy = new int[n.length];
		
		for (int i = 0; i < copy.length; i++)
			copy[i]= n[i];
		
		return copy;
		
		}
	
	// multipliziert das Ziffernfeld n mit einer (einstelligen!) int-Zahl
	static int[ ] times(int[ ] n, int d) { 
		
		int max = n.length +1;
		int [] product = new int [max];
		int transfer = 0;
		
		for (int i = 0; i < product.length; i++) {
			if (i>=n.length) product[product.length-1]=transfer;
			else {
				product[i] = (n[i]*d + transfer)%10;
				transfer = (n[i]*d + transfer)/10;
			}
		}
		
		// Abfrag zwecks führender NULL
		if (product[product.length-1] == 0) {
			max = max - 1;
			int[] productfinal = new int[max];
			for (int i = 0; i<productfinal.length; i++)
				productfinal[i] = product[i];
			
			return productfinal;	
		}
		return product;
	}

	
		
	
	// multipliziert das Ziffernfeld n mit 10
	static int[ ] times10(int[ ] n) { 
	
	int[] times10 = new int[n.length+1];
	times10[0] = 0;
	for (int i = 0; i < n.length; i++)
		times10[i+1]= n[i];
	
	return times10;
	
	}
	
	// multipliziert zwei Ziffernfelder
	static int[ ] times(int[ ] a, int[ ] b) { 
		
		int max = (a.length+b.length);
			
		int[] product = new int [max];
		int[] temp = new int [max];
		int factor = b.length-1;
		
		for (int i = 1; i <= b.length; i++) {
				temp = times(a, b[b.length-i]);
					if (i<b.length) {
						for (int j=0; j<factor; j++)
							temp = times10(temp);
					}
				product = add(product, temp);
				for (int j=0; j<temp.length; j++)
					temp[j] = 0;
				factor--;
		}			
		
		// führende Nullen entfernen
		for (int i =1; i<=product.length; i++) {
			if (product[product.length-i]==0) max--;
			if (product[product.length-i]>0) break;
		}
				
		int [] finalproduct = new int [max];
		for (int i = 0; i<finalproduct.length; i++) {
			finalproduct[i]=product[i];
		}
		return finalproduct;		
		
	}
	
	
	
	// Quadratzahl eines Ziffernfeldes
	static int[ ] square(int[ ] a) { 
		
		int [] ergebnis = new int[a.length*2];
		ergebnis = times (a, a);
		return ergebnis;
		}
	
	
	
	// Kubikzahl eines Ziffernfeldes
	static int[ ] cubic(int[ ] a) { 
		
		int [] ergebnis = new int[a.length*2];
		int [] cubic = new int[a.length*3];
		
		ergebnis = square(a);
		cubic = times (ergebnis, a);
		return cubic;
	}
	
		
	// Test auf kleiner-Relation zweier Ziffernfelder: a < b ?
	static boolean less (int[ ] a, int[ ] b) {
			
		boolean less = false;
		
		if (a.length > b.length)
			less = false;				
		else if	(a.length < b.length)
			less = true;
		else {
			for (int i = 1; i <= a.length; i++) {
				if (a[a.length-i] < b[b.length-i]) less = true;
				else less = false;
			}
		}
		return less;
		}
	
		
	
	// Test auf Gleichheit zweier Ziffernfelder
	static boolean equal (int[ ] a, int[ ] b) { 

		boolean equal = false;
		
		if (a.length != b.length)
			equal = false;
		
		else 	{	
			for (int i = 0; i < a.length; i++)
				if (a[i] != b[i]) equal = false;
				else equal = true;
		}
		return equal;
		}
	
	
	
	// Test auf Korrektheit eines Ziffernfeldes: Feld existiert und enthaelt
	// mindenstens eine Ziffer, alle Positionen liegen zwischen 0 und 9
	// keine fuehrenden Nullen (ausser bei Null selbst)
	static boolean ok (int[ ] n) {
	
	boolean ok = false;	
		
	if (n.length == 1 && n[0] == 0)
		ok = true;
	
	else if (n[n.length-1] == 0)
		ok = false;
	
	else if (n.length > 1) 
		for (int i = 0; i <= n.length; i++) {
			if (!ok && n[n.length-i] == 0) ok = false;
			else ok = true;
		}
	else ok = false;
	
	return ok;	
		
	}
	
	
	// gibt die (kleinste) Ziffer mit der groessten Haeufigkeit in n aus
	static void maxDigit(int[] n) { 

		int ziffer = 0;
		int maxDigit = 0;
		int zaehler = 0;
		int maximum = 0;
		
		for (int i = 0;i <10; i++) {
			ziffer = i;
			zaehler = 0;
			
			for (int j = 0; j < n.length; j++) {
				if (ziffer == n[j])
				zaehler++;
			}
						
			if (zaehler>maximum || (zaehler == maximum && ziffer < maxDigit)) {
				maximum = zaehler;
				maxDigit = ziffer;
			}	
		}
		System.out.println(maxDigit + ": " + maximum);
	}	
	
	
	public static void main (String[] s) {
	
	int[ ] a = One();
	for (int i=0; i<33222; ++i) { a = times(a, 2); }
	System.out.println("2^33222 hat " + a.length + " Stellen");
	print(a);
	System.out.println();
	int[ ] b = fromInt(13);
	int[ ] c = copy(b);
	for (int i=1; i<8978; ++i) { c = times(c, b); }
	System.out.println("13^8978 hat " + c.length + " Stellen");
	print(c);
	System.out.println();
	System.out.println(less(a, c)); // beantwortet die Frage aus der
	// Aufgabenueberschrift
	maxDigit(a);
	maxDigit(c);
	}
	
	
}

