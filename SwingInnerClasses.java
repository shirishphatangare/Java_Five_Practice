import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/* This swing class demonstrates use of nested inner classes to implement same interface multiple times in a class
 * to achieve different behaviors for different buttons by implementing  actionPerformed method differently for each Listener class.
 * Pass references of different Listener classes to each button to get different behaviors.
 * This is the cleanest Object oriented approach to achieve this behavior in SWING/JAVA. Moreover, nested inner classes have access to private/non-private variables of main class(frame/label in this case).
 */



public class SwingInnerClasses {
	JFrame frame;
	JLabel label;
	
	public static void main(String[] args) {
		SwingInnerClasses gui = new SwingInnerClasses();
		gui.go();
	}
	
	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton labelButton = new JButton("Change Label");
		JButton colorButton = new JButton("Change Circle");
		
		labelButton.addActionListener(new LabelListerner());
		colorButton.addActionListener(new ColorListener());
		
		label = new JLabel("I am a Label");
		MyDrawPanel drawpanel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH,colorButton);
		frame.getContentPane().add(BorderLayout.CENTER,drawpanel);
		frame.getContentPane().add(BorderLayout.EAST,labelButton);
		frame.getContentPane().add(BorderLayout.WEST,label);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	
	class LabelListerner implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			label.setText("Oach!");
		}
	}

	
	class ColorListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			frame.repaint();
		}
	}

}

class MyDrawPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public void paintComponent(Graphics g){
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		int red = (int)(Math.random() * 256); 
		int green = (int)(Math.random() * 256);
		int blue = (int)(Math.random() * 256);
		
		Color color = new Color(red,green,blue);
		g.setColor(color);
		g.fillOval(70, 70, 100, 100);
		
	}
}
