package example;
import java.awt.*;

class DisplayCanvas extends Canvas{
    Action parent;
    DisplayCanvas(Action app){
	this.parent = app;
    }

    public void display(Graphics g){
	Font font = new Font("TimesRoman",Font.BOLD,12);
	g.setFont(font);
	FontMetrics fm = g.getFontMetrics(font);
	int h =fm.getHeight();
	int tuple=1;
	//１個目
	if(!(this.parent.input.postfixNotation.equals(""))){
	    g.setColor(Color.red);
	    g.drawString("後置記法の式",10,70);
	    g.drawString(this.parent.input.postfixNotation,10,70+h*tuple++);
	}
	//２個目
	if(this.parent.input.generateFlag){
	    g.setColor(Color.blue);
	    g.drawString("スタックマシンの命令列",10,70+h*tuple++);
	    for(int i = 0;i < this.parent.input.instructionSequens.length;i++){
		if (this.parent.input.instructionSequens[i].equals("push")){
		    g.drawString(this.parent.input.instructionSequens[i]+" "+this.parent.input.instructionSequens[i+1],10,70+h*tuple++);
		    i++;
		}
		else{
		    g.drawString(this.parent.input.instructionSequens[i],10,70+h*tuple++);
		}
	    }
	}
	//３個目
	if(this.parent.input.executionFlag){
	    g.setColor(Color.black);
	    g.drawString("実行結果",10,70+h*tuple++);
	    
	    g.drawString(String.valueOf(this.parent.input.Answer),10,70+h*tuple++);
	}
    }
}