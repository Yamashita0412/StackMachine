package example;
import java.util.*;
import java.lang.*;

public class StackMachine{
    private Stack stack;
    private int firstPop;
    private int secoundPop;
    /**
     *<PRE>
     * Stackを動かして計算を行うクラス
     * つぎの9つのメソッドを持つ。
     *</PRE>
     *<OL>
     * <LI>public void push(int)
     * <LI>public void add()
     * <LI>public void sub()
     * <LI>public void mul()
     * <LI>public void div()
     * <LI>public int wrt()
     * <LI>public void halt()
     * <LI>void setNumber()
     * <LI>void popCheck()
     *</OL>
     *@author Yamashita Kyonosuke
     *@version 1.0
     */
    public StackMachine(){
	this.stack = new Stack();
    }
    /**
     * stackのプッシュ機能を用いるメソッド
     * @param int
     * @return none
     */
    public void push(int a){
	stack.push(a);
    }
    /**
     * stackを用いて加算を行うメソッド
     * @param none 
     * @return none
     */
    public void add(){
	setNumber();
	System.out.println( firstPop + " + " + secoundPop + "の加算を行いました。");
	stack.push( firstPop + secoundPop );
    }

    /**
     * stackを用いて減算を行うメソッド
     * @param none
     * @return none
     */
    public void sub(){
	setNumber();
	System.out.println( secoundPop + " - " + firstPop + "の減算を行いました。");
	stack.push( secoundPop - firstPop );
    }

    /**
     * stackを用いて乗算を行うメソッド
     * @param none
     * @return none
     */
    public void mul(){
	setNumber();
	System.out.println( firstPop + " * " + secoundPop + "の乗算を行いました。");
	stack.push( firstPop * secoundPop );
    }

    /**
     * stackを用いて除算を行うメソッド
     * @param none
     * @return none
     */
    public void div(){
	setNumber();
	System.out.println( secoundPop + " / " + firstPop + "の除算を行いました。");
	stack.push( secoundPop/firstPop ); 
    }
    /**
     * スタックの中身が２つ以上出ない時、最後の一つを返り値とする出力メソッド
     * @param none
     * @return none
     */
    public int wrt(){
	int Ans = new Integer(stack.pop().toString());
	if (stack.nullCheck() == false){
	    System.out.println("計算式が不適切です。スタックに要素が２つ以上あります。\n検出値:"+stack.pop());
	    halt();
	}
	return Ans;
    }
    /**
     * 想定外の自体に対して強制終了を行うメソッド
     * @param none
     * @return none
     */
    public void halt(){
	System.out.println("動作を停止します.");
	System.exit(1);
    }
    /**
     * 各種計算に用いる２つの変数を取得するメソッド
     * @param none
     * @return none
     */
    void setNumber(){
	popCheck();
	this.firstPop = new Integer(stack.pop().toString());
	popCheck();
	this.secoundPop = new Integer(stack.pop().toString());
    }
    /**
     * stack内に要素があるかチェックするメソッド
     * @param none
     * @return none
     */
    void popCheck(){
	if (stack.nullCheck()){
	    System.out.println("popするデータが存在しません.");
	    halt();
	}
    }
}