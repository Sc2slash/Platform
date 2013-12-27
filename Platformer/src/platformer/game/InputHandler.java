package platformer.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{

	Game game;
	public InputHandler(Game game){
		game.window.addKeyListener(this);
		this.game = game;
	}
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){

		case KeyEvent.VK_LEFT:
			game.testEntity.setXSpeed(-80);
			break;
		case KeyEvent.VK_RIGHT:
			game.testEntity.setXSpeed(80);
			break;
		case KeyEvent.VK_SPACE:
			game.testEntity.jump();
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_RIGHT:
			game.testEntity.setXSpeed(0);
			break;
		case KeyEvent.VK_LEFT:
			game.testEntity.setXSpeed(0);
			break;
		case KeyEvent.VK_SPACE:
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
