/**
 * 
 * @author Arthur Langhammer / Gabriel Haller
 * @version 2.0
 * @Aufgabe GDP Praktikum Aufgabe 4
 *
 */
public class Riddle {
	
	// Arrays der Länge 2*n erstellen in denen alle Zahlen bis zur Größe n jeweils 2* vorkommen
	// und mit genau dem Abstand von dem Wert der jeweils betrachteten Zahl
	public static void main(String[] args) {
		
		if (args.length == 0) {
			System.out.println("Bitte eine Zahl als Parameter angeben");
			System.exit(0);
		}
		
		int n = Integer.parseInt(args[0]); 
		int[] array = new int[n*2];
		int amount = n;
		
		if (n <= 0) {
			System.out.println("Bitte eine Zahl groesser 0 eingeben");
			System.exit(0);
		}
		
		if (n > 15) {
			System.out.println("Bitte eine Zahl <= 15 eingeben");
			System.exit(0);
		}
		
		test(array, n, amount);
		
		if (c==0) System.out.println("Keine Loesung");
		
		else if (c==1) System.out.println(c + " Loesung");
		
		else System.out.println(c + " Loesungen");
		
	}

	
	// das Array ausgeben
	private static void printArray(int[] array) {
		
		for (int i = 0; i < array.length; i++) { 
			System.out.print(array[i]);
		}
		System.out.println();
		
	}
	
	// Klassenvariable die als Counter dient
	private static int c = 0;
	
	// Arrays in einer Rekursion füllen und die Bedingungen überprüfen
	public static void test(int[] array, int n, int amount) {
		
		if (n == 0) {
			if (amount <= 10)
				printArray(array);
			c++;	
		}
		
		
		boolean mirror = true;
		
		for(int i = array.length-1; i >=0; i--) {
			
			if (array[0] > array[array.length-1] ) mirror = false;
			
			
				if ((i+n+1)< array.length) {
				
					if (array[i] == 0 && array[i+n+1] == 0 && mirror) {
						
						array[i] = n;
						array[i+n+1] = n;
						
						test(array,n-1, amount);
						
						array[i] = 0;
						array[i+n+1] = 0;	
					}		
				}
		} // Ende for - Schleife
	
	} // Ende Funktion
	
} // Ende Klasse
