package example;

public class Bynalytree{
    private Node head = null;
    private String infixNotation;
    private String postfixNotation;
    /**
     *<PRE>
     * 引数に応じた計算式の二分木の管理
     * つぎの３つのメソッドを持つ
     *</PRE>
     *<OL>
     * <LI>void makeBynalytree()
     * <LI>void postorderTraversal()
     * <LI>String getPostfixNotation()
     *</OL>
     *@author Yamashita Kyonosuke
     *@version 1.0
     */
    Bynalytree( String infixNotation ){
	this.infixNotation = infixNotation;
    }
    /**
     * ２分木を生成するメソッド
     * @param none
     * @return none
     */
    void makeBynalytree(){
	this.head = new Node( this.infixNotation );
	head.connectNode();
    }
    /**
     * ２分木を後順走査するメソッド
     * @param none
     * @return none
     */    
    void postorderTraversal(){
	head.InitalizationNotation();
	this.postfixNotation=head.postorder();
    }
   /**
     * ２分木を後順走査した結果を返すメソッド
     * @param none
     * @return none
     */        
    String getPostfixNotation(){
	return this.postfixNotation;
    }
}