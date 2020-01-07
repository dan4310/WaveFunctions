
import java.lang.Math;

public class Function {
	private int[][] coords = new int[1000][2];
	private int frameL, frameW;
	private int sepPix;
	
	public Function(int sepPix) {
		this.sepPix = sepPix;
	}
	public Function() {
	}
	
	public void cos(double k, double amp, boolean bool) {
		int xPos = (int) (-frameL/2);
		double xPosReal = -6*Math.PI;
		for (int i = 0; i < getCoords().length; i++) {
			getCoords()[i][0] = xPos; xPos+=1;
			getCoords()[i][1] = (int) (Math.cos(xPosReal*k)*amp*(250/5)); xPosReal+=(0.03769911184);
			
			
			if (!bool) {
				getCoords()[i][0] += (int) frameL/2;
				if (getCoords()[i][1] < 0) {
					getCoords()[i][1] = Math.abs(getCoords()[i][1]) + (int) frameW/2;
				} else if (getCoords()[i][1] > 0) {
					getCoords()[i][1] = (int) (frameW/2 - getCoords()[i][1]);
				} else { getCoords()[i][1] = (int) frameW/2;}
			}
		}
	}
	public void sin(double k, double amp, boolean bool) {
		int xPos = (int) (-frameL/2);
		double xPosReal = -6*Math.PI;
		for (int i = 0; i < getCoords().length; i++) {
			getCoords()[i][0] = xPos; xPos+=1;
			getCoords()[i][1] = (int) (Math.sin(xPosReal*k)*amp*(250/5)); xPosReal+=(0.03769911184);
			
			
			if (!bool) {
				getCoords()[i][0] += (int) frameL/2;
				if (getCoords()[i][1] < 0) {
					getCoords()[i][1] = Math.abs(getCoords()[i][1]) + (int) frameW/2;
				} else if (getCoords()[i][1] > 0) {
					getCoords()[i][1] = (int) (frameW/2 - getCoords()[i][1]);
				} else { getCoords()[i][1] = (int) frameW/2;}
			}
		}
	}
	// Time dependent
	public void cos(double k, double amp, double w, int t, boolean bool) {
		int xPos = (int) (-frameL/2);
		double xPosReal = -6*Math.PI;
		for (int i = 0; i < getCoords().length; i++) {
			getCoords()[i][0] = xPos; xPos+=1;
			getCoords()[i][1] = (int) (Math.cos((xPosReal*k)-(w*t))*amp*(250/5)); xPosReal+=(0.03769911184);
			
			
			if (!bool) {
				getCoords()[i][0] += (int) frameL/2;
				if (getCoords()[i][1] < 0) {
					getCoords()[i][1] = Math.abs(getCoords()[i][1]) + (int) frameW/2;
				} else if (getCoords()[i][1] > 0) {
					getCoords()[i][1] = (int) (frameW/2 - getCoords()[i][1]);
				} else { getCoords()[i][1] = (int) frameW/2;}
			}
		}
	}
	
	public void sin(double k, double amp, double w, int t, boolean bool) {
		int xPos = (int) (-frameL/2);
		double xPosReal = -6*Math.PI;
		for (int i = 0; i < getCoords().length; i++) {
			getCoords()[i][0] = xPos; xPos+=1;
			getCoords()[i][1] = (int) (Math.sin((xPosReal*k)-(w*t))*amp*(250/5)); xPosReal+=(0.03769911184);
			
			
			if (!bool) {
				getCoords()[i][0] += (int) frameL/2;
				if (getCoords()[i][1] < 0) {
					getCoords()[i][1] = Math.abs(getCoords()[i][1]) + (int) frameW/2;
				} else if (getCoords()[i][1] > 0) {
					getCoords()[i][1] = (int) (frameW/2 - getCoords()[i][1]);
				} else { getCoords()[i][1] = (int) frameW/2;}
			}
		}
	}
	
	public int[][] getCoords() {
		return coords;
	}
	
	public void setFrame(int l, int w) {
		frameL = l; frameW = w;
		setCoords(new int[(int) (frameL)][2]);
	}
	public int getFrameL() {
		return frameL;
	}
	public int getFrameW() {
		return frameW;
	}
	
	public void setSepPix(int sepPix) {
		this.sepPix = sepPix;
	}
	public int getSepPix() {
		return sepPix;
	}
	public void setCoords(int[][] coords) {
		this.coords = coords;
	}
	
}
