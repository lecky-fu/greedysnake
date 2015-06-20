package com.fupeng.layerconfig;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/*
 * config配置文件读取类
 * 利用dom4j架包读取xml配置文件
 * xml配置文件中包括frame层和两个layers层的配置文件
 */
public class GameConfig {
	//JFrameGame全局配置对象
	private static FrameConfig FRAME_CONFIG=null;
	static{
		try {
				//创建dom4j读取器
				SAXReader reader = new SAXReader();
				//读取cfg.xml配置文件
				Document doc = reader.read("config/cfg.xml");
				//获取根节点
				Element game = doc.getRootElement();
				//利用跟节点，获取frame对象
				FRAME_CONFIG = new FrameConfig(game.element("frame"));
			} catch (DocumentException e) {
				e.printStackTrace();
			}
	}
	public static FrameConfig getFRAME_CONFIG() {
		return FRAME_CONFIG;
	}
	/*
	 * 私有化构造器
	 */
	private GameConfig(){
	}
}
