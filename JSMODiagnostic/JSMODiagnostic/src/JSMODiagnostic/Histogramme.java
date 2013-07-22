package JSMODiagnostic;
import java.applet.Applet;
import java.awt.Graphics;
public class Histogramme extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//La formule de ton histogramme :
	double f(double x) {
		return (Math.cos(x / 5) + Math.sin(x / 7) + 2) * getSize().height / 4;
	}

	public void paint(Graphics g) {
		for (int x = 0; x < getSize().width; x+=20) {
			g.drawLine(x, getSize().width, x, (int) f(x + 1));
		}
	}
}
 