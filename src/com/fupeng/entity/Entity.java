package com.fupeng.entity;

import java.awt.Image;

import javax.swing.ImageIcon;


public class Entity {
	public  static final Image ENTITY = new ImageIcon("image/rect.png").getImage();
	
	public static final int DIMENSION = ENTITY.getHeight(null);
	
	private  int[] position = new int[2];
	public int[] getPosition() {
		return position;
	}
	public void setPosition(int[] position) {
		this.position = position;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if (obj instanceof Entity) {
			Entity objEntity = (Entity) obj;
			if(this.position[0] == objEntity.position[0] && this.position[1] == objEntity.position[1])
				return true;
		}
		return false;
	}
}
