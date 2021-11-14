/******************************************************************************
 *  Compilation:  javac Clock.java
 *  Execution:    java Clock
 *  Dependences: StdDraw.java
 *
 ******************************************************************************/
import java.util.* ;

public class Horloge {
        
    public static void main(String[] args) { 
	    StdDraw.enableDoubleBuffering();
        double hours ;
        double minutes ;
        double seconds ;

        while ( true ) {
	    
	    hours = Calendar.getInstance().get(Calendar.HOUR) ;
	    minutes = Calendar.getInstance().get(Calendar.MINUTE) ;
	    seconds = Calendar.getInstance().get(Calendar.SECOND) ;
	    
            StdDraw.clear(StdDraw.LIGHT_GRAY);
            StdDraw.setPenRadius();

            // cercle du fond
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(0.5, 0.5, 0.45);

            // points des heures
            StdDraw.setPenColor(StdDraw.BLUE);
            for (int i = 0; i < 12; i++) {
                double theta = Math.toRadians(i * 30);
                StdDraw.filledCircle(0.5 + 0.4 * Math.cos(theta), 0.5 + 0.4 * Math.sin(theta), .012);
            }

            // aiguille des secondes
            StdDraw.setPenRadius(.01);
            StdDraw.setPenColor(StdDraw.YELLOW);
            double angle1 = Math.toRadians(6 * seconds);
            double r1 = 0.4;
            StdDraw.line(0.5, 0.5, 0.5 + r1 * Math.sin(angle1), 0.5 + r1 * Math.cos(angle1));

            // aiguille des minutes
            StdDraw.setPenRadius(.02);
            StdDraw.setPenColor(StdDraw.GRAY);
            double angle2 = Math.toRadians(6 * minutes);
            double r2 = 0.3;
            StdDraw.line(0.5, 0.5, 0.5 + r2 * Math.sin(angle2), 0.5 + r2 * Math.cos(angle2));

            // aiguille des heures
            StdDraw.setPenRadius(.025);
            StdDraw.setPenColor(StdDraw.WHITE);
            double angle3 = Math.toRadians(30 * hours);
            double r3 = 0.2;
            StdDraw.line(0.5, 0.5, 0.5 + r3 * Math.sin(angle3), 0.5 + r3 * Math.cos(angle3));

            // affichage numérique de l'heure
            String time = String.format("%2d:%02d:%02d", (int)hours, (int)minutes, (int)seconds);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0.5, 0.2, time);

            // rafraichissement chaque 1000ms
            StdDraw.show();
            StdDraw.pause(1000);
        }
    }

}
