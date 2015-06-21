package com.fupeng.entity;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		List<Entity>snake  =new ArrayList<Entity>();
		for(int i=1 ; i<10 ; i++){
			Entity entity = new Entity();
			entity.setPosition(new int[]{i,i});
			snake.add(entity);
		}
		Entity entity = new Entity();
		entity.setPosition(new int[]{0,0});
		boolean state = snake.contains(entity);
		System.out.println("״̬="+state);
	}

}
