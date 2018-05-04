package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GenerateOrder{
    private String postfixNotation;
    private List<String> instructionSequence;
    /**
     *<PRE>
     * " "(スペース)区切りになっているString文字を区切って命令列の作成
     * つぎの2つのメソッドを持つ。
     *</PRE>
     *<OL>
     * <LI>void OrderSplit()
     * <LI>String[] getOrder()
     *</OL>
     *@author Yamashita Kyonosuke
     *@version 1.0
     */
    GenerateOrder(String postfixNotation){
	this.postfixNotation = postfixNotation;
	this.instructionSequence = new ArrayList<String>();
	this.instructionSequence.add("wrt");
	this.instructionSequence.add("halt");
    }
    /**
     * " "区切りにするメソッド
     * @param none
     * @return none
     */
    void generateInstructionSequence(){
	replaceNotation();
	addListNotation();
	addPushNotation();
    }

    void replaceNotation(){
	this.postfixNotation=postfixNotation.replace("+","add");
	this.postfixNotation=postfixNotation.replace("-","sub");
	this.postfixNotation=postfixNotation.replace("*","mul");
	this.postfixNotation=postfixNotation.replace("/","div");
    }

    void addListNotation(){
    	this.instructionSequence.addAll(0,Arrays.asList(this.postfixNotation.split("[\\s]+")));
    }

    void addPushNotation(){
    	for(int i=0;i<instructionSequence.size();i++){
	    if(instructionSequence.get(i).matches("[+-]?\\d+")){
	    	instructionSequence.add(i,"push");
		i++;
	    }
	}
    }
    
    
    /**
     * 命令列を返す
     * @param none
     * @return List
     */
     List<String> getInstructionSequence(){
	return this.instructionSequence;
    }
}