import gdp.stdlib.StdDraw;


public class HelloWorld {

	public static void main(String[] args) {
		
			// Lege die Achsenbereiche fest
			StdDraw.setXscale(0, 1);
			StdDraw.setYscale(0, 1);
			// Lege die Koordinaten der Punkte des Dreiecks fest
			double a_x = 0.8;
			double a_y = 0.0;
			double b_x = 0.9;
			double b_y = 0.2;
			double c_x = 1.0;
			double c_y = 0.0;
			// Zeichne das Dreieck
			StdDraw.line(a_x, a_y, b_x, b_y);
			StdDraw.line(b_x, b_y, c_x, c_y);
			StdDraw.line(c_x, c_y, a_x, a_y);
			
			double alpha = 45; // Winkel in Grad um den gedreht werden soll
			double alpha_rad = alpha * (Math.PI / 180); // Winkel in Rad
			// Berechnung der neuen Eckpunkte des gedrehten Dreiecks
			double a_x1 = a_x * Math.cos(alpha_rad) - a_y * Math.sin(alpha_rad);
			double a_y1 = a_x * Math.sin(alpha_rad) + a_y * Math.cos(alpha_rad);
			double b_x1 = b_x * Math.cos(alpha_rad) - b_y * Math.sin(alpha_rad);
			double b_y1 = b_x * Math.sin(alpha_rad) + b_y * Math.cos(alpha_rad);
			double c_x1 = c_x * Math.cos(alpha_rad) - c_y * Math.sin(alpha_rad);
			double c_y1 = c_x * Math.sin(alpha_rad) + c_y * Math.cos(alpha_rad);
			// Zeichnen des (um den Nullpunkt) gedrehten Dreiecks
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.line(a_x1, a_y1, b_x1, b_y1);
			StdDraw.line(b_x1, b_y1, c_x1, c_y1);
			StdDraw.line(c_x1, c_y1, a_x1, a_y1);

	}
}
