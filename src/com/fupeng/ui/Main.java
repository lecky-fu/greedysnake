package com.fupeng.ui;

import com.fupeng.control.GameControl;
import com.fupeng.dto.GameDto;
import com.fupeng.service.CoreService;

public class Main {

	public static void main(String[] args) {
		GameDto gameDto = new GameDto();
		CoreService coreService = new CoreService(gameDto);
		GameControl gameControl = new GameControl(coreService);
		gameDto.jPanelGame.setGameControl(gameControl);
		gameDto.jPanelGame.setGameDto(gameDto);
		gameDto.jPanelGame.initComponet();
		new JFrameGame(gameDto.jPanelGame);
	}
}
