package example;

public class Node{
    private static String Notation=""; 
    private String infixNotation;
    private Object element = null;
    private Node leftNext = null;
    private Node rightNext = null;
    private int parenthesisCounter=0;
    private boolean flag = false;

    Node(int element){
	this.element = element;
    }
    Node(String infixNotation ){
	this.infixNotation = infixNotation;
    }
    
    /**
     * 葉と葉をつなげて二分木を作るメソッド
     * ルールに従いどのように二分木を作るか判定する。
     * @param none
     * @return none
     */
    void connectNode(){
	CheckParenthesis();
	if(infixNotation.indexOf("(")==-1 && infixNotation.indexOf(")")==-1 && infixNotation.matches(".*[\\+\\-\\*/].*")==false){
	     InsertNumericalValue();
	 }
	else{
	    SearchOperate();
	}
    }

    void SearchOperate(){
	while(flag == false){
	    SearchAddtionAndSubtraction();
	    if(flag == false){
		SearchMultiplicationAndDivision();
	    }
	    if(flag == false){
		this.infixNotation = infixNotation.substring(1,infixNotation.length()-1);	
	    }
	}
    }
    
    void SearchAddtionAndSubtraction(){
	char beeLine;
	for(int i = infixNotation.length()-1 ; i >= 0 ; i--){
	    beeLine = infixNotation.charAt(i);
	    
	    if ( beeLine == ')')
		parenthesisCounter++;
	    else if (beeLine == '(')
		parenthesisCounter--;
	    
	    if ( parenthesisCounter == 0 && (beeLine == '-' || beeLine == '+')){
		AssortNotation(i);
		this.flag = true;
		break;
	    }
	}
    }
    void SearchMultiplicationAndDivision(){
	char beeLine;
	for(int i = infixNotation.length()-1 ; i >= 0 ; i--){
	    beeLine = infixNotation.charAt(i);
	    
	    if ( beeLine == ')')
		parenthesisCounter++;
	    else if (beeLine == '(')
		parenthesisCounter--;
	    
	    if(parenthesisCounter == 0 && (beeLine == '*' || beeLine == '/')){
		AssortNotation(i);
		flag = true;
		break;
	    }
	}
    }
    
    void InsertNumericalValue(){
	System.out.println(infixNotation+"を葉に格納しました");
	this.element = Integer.parseInt(infixNotation);
    }

    void AssortNotation(int index){
	this.leftNext = new Node(infixNotation.substring(0,index));
	leftNext.connectNode();
	this.element = infixNotation.charAt(index);
	this.rightNext = new Node(infixNotation.substring(index+1,infixNotation.length()));
	rightNext.connectNode();

    }
    void CheckParenthesis(){
	while(true){
	    if(infixNotation.charAt(0) == '(' && infixNotation.charAt(infixNotation.length()-1) == ')' && infixNotation.indexOf(")")==infixNotation.length()-1)
		this.infixNotation = infixNotation.substring(1,infixNotation.length()-1);
	    else
		break;
	}
    }
    
    /**
     * 後順に走査した結果の文字列を返すメソッド。
     * @param none
     * @return String
     */   
    String postorder(){
	if(this.leftNext != null){
	    leftNext.postorder();
	}
	if(this.rightNext != null){
	    rightNext.postorder();
	}
	this.Notation =this.Notation + this.element+" ";
	return this.Notation;
    }
    
    void InitalizationNotation(){
	this.Notation="";
    }
}