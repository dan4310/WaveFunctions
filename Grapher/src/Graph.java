
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Graph extends JPanel {

	private int frameL,frameW;
	
	public Function f;
	public int[][] coords;
	int[] funcInts;
	double[] k,A;
	Color[] colors;
	private int[][] interCoords = new int[1000][2];
	
	private boolean refresh = false;
	private boolean interference = false;
	
	public Graph(int[] funcs, double[] k, double[] A) {
		funcInts = funcs; this.k = k; this.A = A; refresh = true;
		frameL = 1000; frameW = 500;
	}
	public Graph(int[] funcs, double[] k, double[] A, boolean interference) {
		funcInts = funcs; this.k = k; this.A = A;
		frameL = 1000; frameW = 500; this.interference = interference;
	}
	public Graph() {
		frameL = 1000; frameW = 500;
	}
	 
	@Override
	protected void paintComponent(Graphics g) {
		setBounds(0,0,1000,500);
		super.paintComponent(g);
		g.drawLine(0, (int) frameW/2, frameL, (int) frameW/2);
		g.drawLine(frameW, 0, frameW, frameW);
		
		// Axis
		g.setFont(new Font("Courier New", Font.BOLD, 12));
		Ticks t = new Ticks(1, 40, frameW, frameL);
		int[] coordsTicksX = t.getCoordsX();
		int[] coordsTicksY = t.getCoordsY();
		for (int i = 0; i < coordsTicksX.length; i++) {
			g.fillRect(coordsTicksX[i], (int) (frameW/2), t.getTickW(), t.getTickL());
			if (i != 6) {
				g.drawString(-6+i+"π", coordsTicksX[i]-4, (int) (frameW/2)+16);
			}
		}
		for (int i = 0; i < coordsTicksY.length; i++) {
			g.fillRect((int) (frameL/2), coordsTicksY[i], t.getTickL(), t.getTickW());
			g.drawString(-5+i+"", (int) (frameL/2)+4, coordsTicksY[i]+4);
		}
		
		f = new Function();
		f.setFrame(frameL, frameW);
		
		if (refresh) {
			for (int i = 0; i < funcInts.length; i++) {
				g.setColor(colors[i]);
				if (funcInts[i] == 1) {
					f.cos(k[i],A[i], false);
					coords = f.getCoords();
				} else if (funcInts[i] == 2) {
					f.sin(k[i], A[i], false);
					coords = f.getCoords();
				} else {continue;}
				for (int j = 0; j < coords.length; j++) {
					try {
						g.drawLine(coords[j][0], coords[j][1], coords[j+1][0], coords[j+1][1]);
					} catch (Exception e) {}
				}
			}
		} else if (interference) {
			for (int i = 0; i < interCoords.length; i++) {
				interCoords[i][0] = i; interCoords[i][1] = 0;
			}
			
			for (int i = 0; i < funcInts.length; i++) {
				if (funcInts[i] == 1) {
					f.cos(k[i], A[i], true);
					coords = f.getCoords();
				} else if (funcInts[i] == 2) {
					f.sin(k[i], A[i], true);
					coords = f.getCoords();
				} else {continue;}
				
				for (int j = 0; j < interCoords.length; j++) {
					interCoords[j][1] += coords[j][1];
				}	
			}
			
	
			for (int k = 0; k < interCoords.length; k++) {
				if (interCoords[k][1] < 0) {
					interCoords[k][1] = Math.abs(interCoords[k][1]) + (int) frameW/2;
				} else if (interCoords[k][1] > 0) {
					interCoords[k][1] = (int) (frameW/2 - interCoords[k][1]);
				} else { interCoords[k][1] = (int) frameW/2;}
				
			}
			
			
			for (int j = 0; j < interCoords.length; j++) {
				try {
					g.setColor(new Color(150, 178, 181));
					g.drawLine(interCoords[j][0], interCoords[j][1], interCoords[j+1][0], interCoords[j+1][1]);
				} catch (Exception e) {}
			}
		}
		
	}
	
	public void setFrameL(int l) {
		frameL = l;
	}
	public void setFrameW(int w) {
		frameW = w;
	}
	public void setRefresh(boolean bool) {
		refresh = bool;
	}
	public void setColors(Color[] colors) {
		this.colors = colors;
	}
	public Color[] getColors() {
		return colors;
	}
}
