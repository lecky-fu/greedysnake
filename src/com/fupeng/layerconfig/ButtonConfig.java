package com.fupeng.layerconfig;
/*
 * button事件配置类对象
 */
public class ButtonConfig {
	private int x;
	private int y;
	private int width;
	private int height;
	private String name;
	
	public ButtonConfig(int x, int y, int width, int height, String name) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public String getName() {
		return name;
	}
	
}
