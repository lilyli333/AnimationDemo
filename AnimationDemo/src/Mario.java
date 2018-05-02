

import java.awt.*;
import java.util.*;

import processing.core.PImage;

public class Mario extends Sprite {

	public static final int MARIO_WIDTH = 40;
	public static final int MARIO_HEIGHT = 60;

	public Mario(PImage img, int x, int y) {
		super(img, x, y, MARIO_WIDTH, MARIO_HEIGHT);
	}

	// METHODS
	public void walk(int dir) {
		// WALK!
	}

	public void jump() {
		// JUMP!
		moveByAmount(0,-10);
	}

	public void act(ArrayList<Shape> obstacles) {
		// FALL (and stop when a platform is hit)
		double minY = Integer.MAX_VALUE;
		for(Shape obstacle : obstacles) {
			if(obstacle.getBounds().getMaxY() < minY)
				minY = obstacle.getBounds().getMaxY();
			
		}
		
		while(super.getBounds().getMaxY() < minY) {
			moveByAmount(0, 1);
		}
	}


}
