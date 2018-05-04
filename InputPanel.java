package example;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


class InputPanel extends Panel implements ActionListener{
    TextField notationField ;
    String postfixNotation="";
    boolean generateFlag=false;
    boolean executionFlag=false;
    String[] instructionSequens;
    Bynalytree bt;
    int Answer;
    Button conversion;
    Button generate;
    Button execution;
    Action parent;
    InputPanel(Action app){
	this.parent = app;
	Label label= new Label("中置記法");
	this.add(label);
	this.notationField = new TextField(30);
	this.add(this.notationField);
	
	this.conversion = new Button("変換");
	this.add(this.conversion);
	this.conversion.addActionListener(this);
	
	this.generate = new Button("生成");
	this.add(this.generate);
	this.generate.addActionListener(this);
	
	this.execution = new Button("実行");
	this.add(this.execution);
	this.execution.addActionListener(this);
	
    }

    public void actionPerformed(ActionEvent evt){
	Button button = (Button)evt.getSource();
	if(button == this.conversion){
	    this.generateFlag = false;
	    this.executionFlag = false;
	    String infixNotation =this.notationField.getText();
	    bt = new Bynalytree( infixNotation );
	    bt.makeBynalytree();
	    bt.postorderTraversal();
	    this.postfixNotation = bt.getPostfixNotation();
	    this.parent.repaint();
	}
	if(button == this.generate){
	    GenerateOrder go = new GenerateOrder( bt.getPostfixNotation() );
	    go.generateInstructionSequence();
	    this.instructionSequens=go.getInstructionSequence().toArray(new String[go.getInstructionSequence().size()]);
	    this.generateFlag = true;
	    this.parent.repaint();
	}
	if(button == this.execution){
	    Calculation cl = new Calculation(this.instructionSequens);
	    cl.OrderCheck();
	    this.Answer = cl.getAns();
	    this.executionFlag = true;
	    this.parent.repaint();
	}
    }
}