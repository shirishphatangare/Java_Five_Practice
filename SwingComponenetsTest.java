import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


public class SwingComponenetsTest implements ActionListener{

	JTextArea textarea;
	
	
	public static void main(String[] args) {
		SwingComponenetsTest gui = new SwingComponenetsTest();
		gui.go();
	}
	
	public void go(){
		JFrame frame = new JFrame();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JButton button = new JButton("Click Me");
		button.addActionListener(this);
		
		JCheckBox checkBox1 = new JCheckBox("India");
		JCheckBox checkBox2 = new JCheckBox("Pakistan");
		
		textarea = new JTextArea(20,30);
		textarea.setLineWrap(true);
		
		JScrollPane scroller = new JScrollPane(textarea);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		panel1.add(scroller);
		panel2.add(checkBox1);
		panel2.add(checkBox2);
		
		frame.getContentPane().add(BorderLayout.CENTER,panel1);
		frame.getContentPane().add(BorderLayout.SOUTH,button);
		frame.getContentPane().add(BorderLayout.WEST,panel2);
		
		frame.setSize(400,400);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		textarea.append("Button Clicked\t");
		
	}

}
