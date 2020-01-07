

public class Ticks {
	private int sepPix;
	private int tickW = 2;
	private int tickL = 4;
	private int frameL, frameW;
	
	public Ticks() {
		sepPix = 10;
		frameW = 500; frameL = 1000;
	}
	public Ticks(int sep, int sepPix, int frameW, int frameL) {
		this.sepPix = sepPix;
		this.frameW = frameW; this.frameL = frameL;
	}
	
	public int[] getCoordsX() {
		int[] coords = new int[13];
		int pos = 0;
		for (int i = 0; i < coords.length; i++) {
			coords[i] = pos;
			pos += frameL/12;
		}
		return coords;
	}
	
	public int[] getCoordsY() {
		int[] coords = new int[11];
		int pos = 0;
		for (int i = 0; i < coords.length; i++) {
			coords[i] = pos;
			pos += frameW/10;
		}
		return coords;
	}
	
	public void setTickW(int w) {
		tickW = w;
	}
	public int getTickW() {
		return tickW;
	}
	
	public void setTickL(int l) {
		tickL = l;
	}
	public int getTickL() {
		return tickL;
	}
	
	public int getTickSep() {
		return sepPix;
	}
	
}
