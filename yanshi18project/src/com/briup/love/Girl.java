package com.briup.love;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Girl {
	//名字
	private String name;
	//维护了一群小boy
	private Set<EventListener> boys;
	
	//构造器
	public Girl(String name) {
		this.name=name;
		this.boys=new HashSet<EventListener>();
	}
	
	
	//新增boy的权利
	public void addEventAction(EventListener e) {
		boys.add(e);
	}
	//删除boy的权利
	public void removeEventAction(EventListener e) {
		boys.remove(e);
	}
	
	//事件的推送
	public void happy() {
		EventInfo e = new EventInfo(this, "我今天很开心");
		//女孩要推送给所有的男孩
		for(EventListener boy : boys) {
			boy.happy(e);  //女孩开心了之后，所有男孩收到爱的回复，我们也开心了
		}
	}
	public void sad() {
		EventInfo e = new EventInfo(this, "我今天一点也不开心");
		//女孩要推送给所有的男孩
		for(EventListener boy : boys) {
			boy.sad(e);  
		}
	}
	
	
	
	
}
