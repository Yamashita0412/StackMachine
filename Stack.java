package example;

import java.util.ArrayDeque;

public class Stack{
    private ArrayDeque<Integer> stack;    
    /**
     *<PRE>
     * Stackの機能
     * つぎの3つのメソッドを持つ。
     *</PRE>
     *<OL>
     * <LI>void push(int)
     * <LI>Object pop()
     * <LI>boolean nullCheck()
     *</OL>
     *@author Yamashita Kyonosuke
     *@version 1.0
     */
    Stack(){
	this.stack = new ArrayDeque<Integer>();
    }
    /**
     * stackにおけるプッシュ
     * @param int
     * @return none
     */
    void push(int data){
	System.out.println(data+"をpushしました。");
	this.stack.addFirst(data);
    }
    /**
     * stackにおけるプッシュ
     * @param none
     * @return Object
     */
    Object pop(){
	System.out.println(this.stack.getFirst()+"をpopしました。");
	return this.stack.pollFirst();
    }
    /**
     * 先頭が空であるかどうかの確認（要素の認知）
     * @param none
     * @return boolean
     */
    boolean nullCheck(){
	return stack.isEmpty();
    }
}