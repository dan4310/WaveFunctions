
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ToolBar extends JPanel {
	
	@SuppressWarnings("unchecked")
	private JComboBox<String>[] comboBoxes = new JComboBox[5];
	private JTextField[] kTextFields = new JTextField[5];
	private JTextField[] ATextFields = new JTextField[5];
	public JButton btnPlot;
	public Listener l1;
	private Graph g;
	private Color[] colors;
	
	public ToolBar() {
		
	}
	
	public void create() {
				setBounds(1000,0,300,500);
				Color back = new Color(202, 233, 237);
				setBackground(back);
				setLayout(null);
				int num,xPos,yPos;
				num = 1; xPos = 10; yPos = 30;
				String[] waves = {"NONE", "A*cos(kx)", "A*sin(kx)" };
				Cursor hand = new Cursor(Cursor.HAND_CURSOR);
				
				for (int i = 0; i < 5; i++) {
					JPanel p = new JPanel(); p.setBackground(colors[i]);
					p.setLayout(null);
					p.setBounds(0,yPos,300,30); 
					JLabel lbl = new JLabel(Integer.toString(num)+"."); lbl.setForeground(Color.white);
					lbl.setBounds(0,0,20,20); p.add(lbl);
					JComboBox<String> cb = new JComboBox<String>(waves);
					cb.setCursor(hand);
					cb.setBounds(20,0,120,25); p.add(cb);
					comboBoxes[i] = cb;
					lbl = new JLabel("k:"); lbl.setBounds(150,0,20,20); 
					lbl.setForeground(Color.white); p.add(lbl);
					JTextField txt = new JTextField(); txt.setBounds(160,0,40,20); p.add(txt);
					kTextFields[i] = txt;
					lbl = new JLabel("A:"); lbl.setBounds(210,0,20,20); 
					lbl.setForeground(Color.white); p.add(lbl);
					txt = new JTextField(); txt.setBounds(220,0,30,20); p.add(txt);
					ATextFields[i] = txt;
					add(p);
					yPos += 30;
					num++;
				}
				
				// CheckBox
				JCheckBox check = new JCheckBox("Interference"); check.setBounds(0,430,120,20);	
				check.setCursor(hand);
				add(check);
				
				
				// button plot
				btnPlot = new JButton("Plot!"); btnPlot.setBounds(0,400,100,30);
				btnPlot.setCursor(hand);
				l1 = new Listener(comboBoxes, kTextFields, ATextFields, check);
				l1.setToolbar(this);
				l1.setGraphOld(g);
				btnPlot.addActionListener(l1);
				Color green = new Color(54, 168, 50);
				btnPlot.setForeground(green);
				add(btnPlot);
				
				// button clear
				JButton btnClear = new JButton("Clear"); btnClear.setBounds(100,400,100,30);
				btnClear.setCursor(hand);
				btnClear.addActionListener(l1);
				btnClear.setForeground(Color.red);
				add(btnClear);
				
	}
	
	public JComboBox<String>[] getComboBoxes() {
		return comboBoxes;
	}
	public JTextField[] getKFields() {
		return kTextFields;
	}
	public JTextField[] getAFields() {
		return ATextFields;
	}
	public Listener getListener() {
		return l1;
	}
	public void setGraph(Graph g) {
		this.g = g;
	}
	public void setColors(Color[] colors) {
		this.colors = colors;
	}
	
}
