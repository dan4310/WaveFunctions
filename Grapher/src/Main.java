

import javax.swing.*;
import java.awt.*;

public class Main {
	public static int frameW = 500;
	public static int frameL = 1000;
	
	
	public Main() {
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Color green = new Color(54, 168, 50);
		Color[] colors = {Color.blue, green, Color.red, Color.magenta, Color.orange};
		
		JFrame frame = new JFrame(); frame.setBackground(Color.cyan);
		frame.setResizable(false);
		ToolBar tb = new ToolBar();
		tb.setColors(colors);
		tb.create();
		tb.setBounds(1000, 0, 300, 500);
		frame.add(tb);
		tb.getListener().setFrame(frame);
		Graph g = new Graph();
		g.setFrameL(frameL);
		g.setFrameW(frameW);
		g.setColors(colors);
		frame.add(g);
		
	
		frame.setTitle("Daniel's Cool Plotter");
		frame.setSize(frameL+300,frameW);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		tb.setGraph(g);
		tb.l1.setGraphOld(g);
		
		
		
		
		
	}
	
	
		
		
 }
