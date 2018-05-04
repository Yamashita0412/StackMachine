package example;
import java.applet.Applet;
import java.awt.*;

public class Action extends Applet{
    InputPanel input;
    DisplayCanvas display;
    public void init(){
	display = new DisplayCanvas(this);
	input = new InputPanel(this);
	this.add(input,BorderLayout.NORTH);
	this.add(display,BorderLayout.SOUTH);
    }
    
    public void paint(Graphics g){
	this.display.display(g);
    }
    
}