package com.fupeng.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.fupeng.dto.GameDto;

public abstract class UiBase {
	private static final Image WINDOW = new ImageIcon("image/Window.png").getImage();
	private static int window_w=WINDOW.getWidth(null);
	private static int window_h=WINDOW.getHeight(null);
	protected static int size ;
	protected static int x ;
	protected static int y ;
	protected static int w ;
	protected static int h ;
	
	protected GameDto gameDto;
	
	public void setGameDto(GameDto gameDto) {
		this.gameDto = gameDto;
	}

	public UiBase(){}
	
	@SuppressWarnings("static-access")
	public UiBase(int x,int y,int w,int h, int size){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.size=size;
	}
	
	protected void drawLine(Graphics g,int horizontal, int vertical ,int disision,int size ){
		if(horizontal>1){
			for(int i=1;i<horizontal;i++)
				g.drawLine(x+size, y+size+disision*i, x+w-size, y+size+disision*i);
		}
		if(vertical>1){
			for(int i=1;i<vertical;i++)
				g.drawLine(x+size+disision*i, y+size, x+size+disision*i, y+h-size);
		}
	}
	
	protected void drawWindow(Graphics g){
		//左上角
		g.drawImage(WINDOW, x, x, x+size, x+size, 
				0, 0, size, size, null);
		//上
		g.drawImage(WINDOW, x+size, y,  x+w-size, y+size, 
				size, 0, window_w-size, size, null);
		//右上角
		g.drawImage(WINDOW, x+w-size, y, x+w, y+size, 
				window_w-size, 0, window_w, size, null);
		//左
		g.drawImage(WINDOW, x, y+size, x+size, y+h-size, 
				0, size, size, window_h-size, null);
		//左下
		g.drawImage(WINDOW, x, y+h-size, x+size, y+h, 
				0, window_h-size, size, window_h, null);
		//下
		g.drawImage(WINDOW, x+size, y+h-size, x+w-size, y+h, 
				size, window_h-size, window_w-size, window_h, null);
		//右下
		g.drawImage(WINDOW, x+w-size, y+h-size, x+w, y+h, 
				window_w-size, window_h-size, window_w, window_h, null);
		//右
		g.drawImage(WINDOW, x+w-size, y+size, x+w, y+h-size, 
				window_w-size, size, window_w, window_h-size, null);
	}
	
	public abstract void point(Graphics g);

}
