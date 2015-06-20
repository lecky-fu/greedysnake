package com.fupeng.layerconfig;

import org.dom4j.Element;

public class FrameConfig {
	private int width ;
	private int height ;
	private int move ;
	private String title;
	private boolean resizable;
	private boolean visible;
	
	public FrameConfig(Element frame){
		//将传递进来的frame 元素按属性取出并存入到配置对象文件中
		this.width =Integer.parseInt(frame.attributeValue("width"));
		this.height=Integer.parseInt(frame.attributeValue("height"));
		this.move =Integer.parseInt(frame.attributeValue("move"));
		this.title = frame.attributeValue("title");
		this.resizable =Boolean.parseBoolean(frame.attributeValue("Resizable"));
		this.visible = Boolean.parseBoolean(frame.attributeValue("Visible"));
		System.out.println("测试部分："+this.width+this.height+this.move +this.resizable +this.visible);
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getMove() {
		return move;
	}
	public boolean isResizable() {
		return resizable;
	}
	public boolean isVisible() {
		return visible;
	}
	public String getTitle() {
		return title;
	}
	
}
