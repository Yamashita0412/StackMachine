package example;

public enum CalculationCodes{
    add("add"),
	sub("sub"),
	mul("mul"),
	div("div"),
	wrt("wrt"),
	halt("halt");
    
    private final String name;
    /**
     *<PRE>
     * switchを扱うためにEnum型を実現するクラス
     * つぎの2つのメソッドを持つ。
     *</PRE>
     *<OL>
     * <LI>String getName()
     * <LI>CalculationCodes getEnumName(String)
     *</OL>
     *@author Yamashita Kyonosuke
     *@version 1.0
     */
    CalculationCodes(String name){
	this.name = name;
    }
    
    /**
     * nameを返すメソッド
     * @param none
     * @return String
     */
    String getName(){
	return this.name;
    }
    /**
     * Stringの一致を確認するメソッド
     * @param String
     * @return CalculationCodes
     */
    public static CalculationCodes getEnumName(String str){
	for(CalculationCodes cc : values()){
	    if(cc.getName().equals(str)){
		return cc;
	    }
	}
    throw new IllegalArgumentException("未定義ワード:"+str);
    }
}
