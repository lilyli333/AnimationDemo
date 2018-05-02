

import java.awt.*;
import java.util.*;

import processing.core.PImage;

public class Mario extends Sprite {

	public static final int MARIO_WIDTH = 40;
	public static final int MARIO_HEIGHT = 60;
	private static boolean onGround;

	public Mario(PImage img, int x, int y) {
		super(img, x, y, MARIO_WIDTH, MARIO_HEIGHT);
		onGround = false;
	}

	// METHODS
	public void walk(int dir) {
		// WALK!
	}

	public void jump() {
		// JUMP!
		moveByAmount(0,-10);
		onGround = false;
	}

	public void act(ArrayList<Shape> obstacles) {
		// FALL (and stop when a platform is hit)
		double minY = Integer.MAX_VALUE;

		for(Shape obstacle : obstacles) {
			if(obstacle.getBounds().getMinX() <= super.getMinX() && obstacle.getBounds().getMaxX() >= super.getMaxX()) {
				if(obstacle.getBounds().getMinY() < minY) {
					minY = obstacle.getBounds().getMinY();
					onGround = false;
				}
			}

		}

		if(super.getBounds().getMaxY() > minY) {
			System.out.println("hellos");
			onGround = true;
		}

		while(super.getBounds().getMaxY() < minY && !onGround) {
			moveByAmount(0, 1);
		}
	}
}
