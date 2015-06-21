package com.fupeng.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class UiBackGround extends UiBase{
	private static final Image BACKGROUND = new ImageIcon("image/light.jpg").getImage();
	
	public UiBackGround(){
		
	}
	
	@Override
	public void point(Graphics g){
		g.drawImage(BACKGROUND, 0, 2, 1200, 700, null);
	}
}
