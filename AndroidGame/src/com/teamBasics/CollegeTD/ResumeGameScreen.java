package com.teamBasics.CollegeTD;

import java.util.List;

import android.graphics.Color;
import android.graphics.Paint;

import com.teamBasics.framework.Game;
import com.teamBasics.framework.Graphics;
import com.teamBasics.framework.Image;
import com.teamBasics.framework.Input.TouchEvent;
import com.teamBasics.framework.Screen;

public class ResumeGameScreen extends Screen {

	// Variable Setup
	Paint paint, paint2;

	public ResumeGameScreen(Game game) {
		super(game);

		// Defining a paint object
		paint = new Paint();
		paint.setTextSize(30);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setAntiAlias(true);
		paint.setColor(Color.GRAY);

		// Back button (options menu)
		paint2 = new Paint();
		paint2.setTextSize(100);
		paint2.setTextAlign(Paint.Align.CENTER);
		paint2.setAntiAlias(true);
		paint2.setColor(Color.LTGRAY);

	}

	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {

				// Level 1 Select
				if (inBounds(event, 50, 200, 100, 100)) {
					game.setScreen(new GameScreen(game, 1));
				}
				
				// Level 2 Select
				else if (inBounds(event, 200, 200, 100, 100)) {
					game.setScreen(new GameScreen(game, 2));
				}				
				
			}
		}
	}

	private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
		if (event.x > x && event.x < x + width - 1 && event.y > y
				&& event.y < y + height - 1)
			return true;
		else
			return false;
	}

	@Override
	public void paint(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawImage(Assets.resumebackground, 0, 0);
		g.drawImage(Assets.levelSelect_box, 50, 200);
		g.drawImage(Assets.levelSelect_box, 200, 200);
		g.drawString("Level 1", 100, 325, paint);
		g.drawString("Level 2", 250, 325, paint);
	}


	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	@Override
	public void backButton() {
		game.setScreen(new MainMenuScreen(game));
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}

}