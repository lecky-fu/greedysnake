package com.fupeng.layerconfig;

import org.dom4j.Element;

public class LayerConfig {
	private int x;
	private int y;
	private int w;
	private int h;
	private int size;
	private String name;
	public LayerConfig(int x, int y, int w, int h, int size, String name) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.size = size;
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
	public int getSize() {
		return size;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "LayerConfig [x=" + x + ", y=" + y + ", w=" + w + ", h=" + h
				+ ", size=" + size + ", name=" + name + "]";
	}
	
}
