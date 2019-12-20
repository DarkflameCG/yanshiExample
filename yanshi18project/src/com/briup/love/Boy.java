package com.briup.love;

public class Boy{
	
	private String boyName;
	
	public static void main(String[] args) {
		
		Girl marry = new Girl("joker");
		//可以在后宫团里添加一个
		marry.addEventAction(new EventListener() {
			
			@Override  
			public void sad(EventInfo e) {
				System.out.println("你伤心我就开心");
			}
			@Override
			public void happy(EventInfo e) {
				System.out.println("你开心我更开心");
			}
		});
		
		marry.happy();
		marry.sad();
		
	}

}
