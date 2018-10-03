import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;



/* With inner classes Main class can extend one Class say A. One or more inner classes are free to extend multiple other classes B,C...
 * Main class can be class A and also sometimes classes B,C... (IS-A relationship)
 */


public class SwingInnerClassAnimationTest {
	private int x=70;
	private int y=70;
	

	public static void main(String[] args) {
		
		SwingInnerClassAnimationTest gui = new SwingInnerClassAnimationTest();
		gui.go();
	}
	
	public void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyDrawPanel drawPanel = this.new MyDrawPanel(); // 'this' is invisible here but it is required to create instance of an inner class
		
		frame.getContentPane().add(drawPanel);
		frame.setSize(500,500);
		frame.setVisible(true);
		
		for(int i=0;i<200;i++){
			x+=5;
			y+=5;

			//frame.repaint();
			// It will also do the same thing as frame.repaint(); i.e calling overridden paintComponent method
			drawPanel.repaint(); 
			
			try{
				Thread.sleep(100);
			}catch(Exception e){}
		}
		
	}
	
	class MyDrawPanel extends JPanel{ // Inner class extends JPanel and main class (SwingInnerClassAnimationTest) is free to extend other class as required. 
	
		private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				g.fillRect(0, 0, this.getWidth(), this.getHeight()); // Erases trails of previous circles
				
				int red = (int)(Math.random() * 256); 
				int green = (int)(Math.random() * 256);
				int blue = (int)(Math.random() * 256);
				
				Color color = new Color(red,green,blue);
				g.setColor(color);
				g.fillOval(x, y, 100, 100); // Inner class has access to private instance variables x and y of main class (SwingInnerClassAnimationTest)
				
			}
	}

}
