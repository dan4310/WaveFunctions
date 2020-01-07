
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Listener implements ActionListener {
	private JComboBox<String>[] comboBoxes;
	private JTextField[] kTextFields;
	private JTextField[] ATextFields;
	private JCheckBox check, time;
	
	private Graph gOld;
	public Graph gNew;
	private JFrame frame;
	private ToolBar tb;
	private int t = 0;
	
	public Listener(JComboBox<String>[] cb, JTextField[] k, JTextField[] A, JCheckBox check, JCheckBox time) {
		comboBoxes = cb; kTextFields = k; ATextFields = A; this.check = check; this.time = time;
	}
	public Listener() {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		
			if (b.getText().equals("Plot!")) {
				int[] funcInts = new int[comboBoxes.length];
				double[] k = new double[comboBoxes.length];
				double[] A = new double[comboBoxes.length];
				int total = 0;
				for (int i = 0; i < comboBoxes.length; i++) {
					funcInts[i] = comboBoxes[i].getSelectedIndex();
					if (funcInts[i] != 0) {total++;}
					try {
					k[i] = Double.parseDouble(kTextFields[i].getText());
					A[i] = Double.parseDouble(ATextFields[i].getText());
					} catch (Exception noInput) { k[i] = 0; A[i] = 0;}
					
				}
				if (total > 0) {
					if (check.isSelected()) {
						gNew = new Graph(funcInts, k, A, true);
					} else { 
						if (time.isSelected()) {
							gNew = new Graph(funcInts, k, A, 1, t, false);
							t++;
						} else {
							t = 0;
							gNew = new Graph(funcInts, k, A);
						}
					}
		
				} else {
					gNew = new Graph();
				}
			} else { 
				for (int i = 0; i < comboBoxes.length; i++) {
					comboBoxes[i].setSelectedIndex(0);
					kTextFields[i].setText("");
					ATextFields[i].setText("");	
				}
				gNew = new Graph(); 
			}
				gNew.setColors(gOld.getColors());
				gOld.setVisible(false);
				gNew.setVisible(true);
				frame.add(gNew);
				frame.setVisible(true);
				setGraphOld(gNew);
				tb.setGraph(gNew);
		
	}
	
	public void setGraphOld(Graph g) {
		this.gOld = g;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public void setToolbar(ToolBar tb) {
		this.tb = tb;
	}
	

}
