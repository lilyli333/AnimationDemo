

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
		// WALK
		super.x += dir*10;
		
	}

	public void jump() {
		// JUMP!
		moveByAmount(0,-10);
	}

	public void act(ArrayList<Shape> obstacles) {
		// FALL (and stop when a platform is hit)
		boolean onGround = false;
		for(Shape obstacle : obstacles) {
			if(obstacle.contains(super.getCenterX(), super.getMaxY())) {
				onGround = true;
			}
		}
		if(!onGround)
			moveByAmount(0,3);
	}
}
