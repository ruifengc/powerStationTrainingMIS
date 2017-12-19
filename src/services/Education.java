package services;

import java.util.Vector;

public enum Education {
 
    DOCTOR("博士", "1"), MASTER("硕士", "2"), BACHELOR("本科", "3"), JUNIOR("专科", "4");
    // 成员变量
    private String name;
    private String index;

    public static void main(String[] args){
    	System.out.println(getIndex("主任"));
    	System.out.println(getNames());
    }
    // 构造方法
    private Education(String name, String index) {
        this.name = name;
        this.index = index;
    }
    public static Vector<String> getNames(){
    	Vector<String> names =  new Vector<String>();
    	for(Education d : Education.values()){
    		names.add(d.name);
    	}
    	return names;
    }
    // 普通方法
    public static String getName(int index) {
    	
        for (Education c : Education.values()) {
            if (c.getIndex().equals( index)) {
                return c.name;
            }
        }
        return null;
    }
    public static String getIndex(String name){
    	for (Education c : Education.values()) {
            if (c.getName().equals(name)) {
                return c.index;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
