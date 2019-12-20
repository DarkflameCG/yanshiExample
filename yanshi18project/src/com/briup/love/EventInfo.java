package com.briup.love;
//事件
public class EventInfo {
	
	//谁是他的事件源
	private Girl girl;
	private String content;//事件的信息

	//构造器的初始化
	
	public EventInfo(Girl girl, String content) {
		this.girl = girl;
		this.content = content;
	}
	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

	public Girl getGirl() {
		return girl;
	}

	public void setGirl(Girl girl) {
		this.girl = girl;
	}

	@Override
	public String toString() {
		return "EventInfo [girl=" + girl + ", content=" + content + "]";
	}
	
	
}
