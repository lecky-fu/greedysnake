package com.fupeng.layerconfig;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class FrameConfig {
	private int width ;
	private int height ;
	private int move ;
	private String title;
	private boolean resizable;
	private boolean visible;
	private List<LayerConfig>layerConfigs=new ArrayList<LayerConfig>();
	private List<ButtonConfig>buttonConfigs = new ArrayList<ButtonConfig>();
	
	public FrameConfig(Element frame){
		//将传递进来的frame 元素按属性取出并存入到配置对象文件中
		getFrameConfig(frame);
		//获取frame节点的layer对象
		getlayerObject(frame);
		//获取frame节点的button对象
		getbuttonObject(frame);
	}
	
	private void getFrameConfig(Element frame) {
		this.width =Integer.parseInt(frame.attributeValue("width"));
		this.height=Integer.parseInt(frame.attributeValue("height"));
		this.move =Integer.parseInt(frame.attributeValue("move"));
		this.title = frame.attributeValue("title");
		this.resizable =Boolean.parseBoolean(frame.attributeValue("Resizable"));
		this.visible = Boolean.parseBoolean(frame.attributeValue("Visible"));
	}

	private void getbuttonObject(Element frame) {
		List<Element> buttonList=frame.elements("button");
		for(Element ele:buttonList){
			ButtonConfig buttonConfig = new ButtonConfig(
					Integer.parseInt(ele.attributeValue("x")), 
					Integer.parseInt(ele.attributeValue("y")), 
					Integer.parseInt(ele.attributeValue("width")), 
					Integer.parseInt(ele.attributeValue("height")), 
					ele.attributeValue("name"));
			buttonConfigs.add(buttonConfig);
		}
	}

	private void getlayerObject(Element frame) {
		List<Element>layerList = frame.elements("layer");
		for(Element ele : layerList){
			LayerConfig layerConfig = new LayerConfig(
					Integer.parseInt(ele.attributeValue("x")), 
					Integer.parseInt(ele.attributeValue("y")), 
							Integer.parseInt(ele.attributeValue("w")), 
									Integer.parseInt(ele.attributeValue("h")), 
											Integer.parseInt(ele.attributeValue("size")),
													ele.attributeValue("classname"));
			layerConfigs.add(layerConfig);
		}
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
	public List<LayerConfig> getLayerConfig() {
		return layerConfigs;
	}
	public List<ButtonConfig> getButtonConfigs() {
		return buttonConfigs;
	}
	
}
