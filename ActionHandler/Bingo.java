//Bingo.java
//This program can print Bingo number by click on the numbers

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Bingo extends Applet {

	private Circle myCircle= new Circle();

	//buttons for moving the circle
	Button
		left= new Button("Left"),
		right= new Button("Right"),
		up= new Button("Up"),
		down= new Button("Down");

      public void Bingo() {

		//add the move buttons
		left.addActionListener(new LeftAction());
		add(new Label("    Circle Movement"));
		add(left);

		//sets default color
		myCircle.setRed();
      }//init

	public void paint(Graphics g) {
		myCircle.display(g);
	}//paint

      class LeftAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			myCircle.left();
			repaint();
		}//actionPerformed
       }//LeftAction

      class ColorChoiceItem implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			//assign color choice to integer to set color
			int choice= colorChoice.getSelectedIndex() + 1;
				switch (choice) {
					case 1: myCircle.setRed(); repaint(); break;
					case 2: myCircle.setGreen(); repaint(); break;
					case 3: myCircle.setBlue(); repaint(); break;
					case 4: myCircle.setPink(); repaint(); break;
					default: myCircle.setRed(); repaint();
				}//switch
		}//itemStateChanged
      }//ColorChoiceItem

	class RedItem implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			myCircle.setRed();
			repaint();
		}//itemStateChanged
       }//RedItem

      static class WL extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}//windowClosing
       }//WL

      public static void main(String[] args) {
		Bingo applet= new Bingo();
		Frame aFrame= new Frame("Bingo Window");
		aFrame.addWindowListener(new WL());
		aFrame.add(applet);
		aFrame.setSize(600,600);
		applet.init();
		applet.start();
		aFrame.setVisible(true);
      }//main
} //Bingo

class Circle {
	private int diameter= 75;
	private int XCoord= 150, YCoord= 75;
	int color= 0; //used for setting circle color

	public void display(Graphics g) {
		setColor(color, g);
		g.fillOval(XCoord, YCoord, diameter, diameter);
	}//display

	public void setColor(int c, Graphics g) {
			switch (c) {
				case 1: g.setColor(Color.red); break;
				case 2: g.setColor(Color.green); break;
				case 3: g.setColor(Color.blue); break;
				case 4: g.setColor(Color.pink); break;
				default: g.setColor(Color.red);
			}//switch
	}//setColor

	public void left() {
		XCoord-= 10;
	}
	public void right() {
		XCoord+= 10;
	}
	public void up() {
		YCoord-= 10;
	}
	public void down() {
		YCoord+= 10;
	}

	public void setRed() {
		color= 1;
	}
	public void setGreen() {
		color= 2;
	}
	public void setBlue() {
		color= 3;
	}
	public void setPink() {
		color= 4;
	}

}//Circle
