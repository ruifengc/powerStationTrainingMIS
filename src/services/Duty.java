package services;

import java.util.Vector;
//构建了个对应关系
public enum Duty {
 
    FACTORY_MANAGER("厂长", "1"), HEAD("主任", "2"), TEAM_LEADER("班长", "3"), TEAM_EMP("员工", "4");
    // 成员变量
    private String name;
    private String index;

    public static void main(String[] args){
    	System.out.println(getIndex("主任"));
    	System.out.println(getNames());
    }
    // 构造方法
    private Duty(String name, String index) {
        this.name = name;
        this.index = index;
    }
    public static Vector<String> getNames(){
    	Vector<String> names =  new Vector<String>();
    	for(Duty d : Duty.values()){
    		names.add(d.name);
    	}
    	return names;
    }
    // 普通方法
    public static String getName(String index) {
    	
        for (Duty c : Duty.values()) {
            if (c.getIndex().equals(index)) {
                return c.name;
            }
        }
        return null;
    }
    public static String getIndex(String name){
    	for (Duty c : Duty.values()) {
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
