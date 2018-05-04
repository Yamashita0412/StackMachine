package example;
import java.util.Arrays;
import java.util.Iterator;
import java.lang.Integer;
//import day1128.StackMachine;

public class Calculation{
    StackMachine sm;
    private String[] order;
    private int Ans ;
    private boolean wrtFlag=true;
    
    /**
     *<PRE>
     * 引数に応じた計算
     * つぎの３つのメソッドを持つ。
     *</PRE>
     *<OL>
     * <LI>int getAns()
     * <LI>void OrderCheck()
     * <LI>void checkCalculation(String)
     *</OL>
     *@author Yamashita Kyonosuke
     *@version 1.0
     */
    Calculation(String[] order){
	this.order = order;
	this.sm = new StackMachine();
    }
    /**
     * Ansrを返すメソッド
     * @param none
     * @return int
     */
    int getAns(){
	return this.Ans;
    }
    
    /**
     * 命令列をpushかその他か判定
     * @param none
     * @return none
     */
    void OrderCheck(){
    	Iterator itr = Arrays.asList(this.order).iterator();
	while(itr.hasNext() && wrtFlag){
	    String str = (String)itr.next();
	    if(str.equals("push"))
		sm.push(new Integer((String)itr.next()));
	    else 
		checkCalculation(str);
	}
    }

    /**
     * 命令列をなんの計算符号か判定
     * @param String
     * @return none
     */
    void checkCalculation(String str){
	switch(CalculationCodes.getEnumName(str)) {
	case add:
	    sm.add();
	    break;
	case sub:
	    sm.sub();
	    break;
	case mul:
	    sm.mul();
	    break;
	case div:
	    sm.div();
	    break;
	case wrt:
	    this.Ans = sm.wrt();
	    System.out.println(Ans);
	    wrtFlag = false;
	    break;
	case halt:
	    System.out.println("動作の中止");
	    System.exit(1);
	default :
	    System.out.println("--不適切な文字の検知--\n検出値:"+str);
	    sm.halt();
	}
    }
}