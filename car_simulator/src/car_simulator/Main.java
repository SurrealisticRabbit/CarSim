package car_simulator;

import processing.core.PApplet;

public class Main extends PApplet{
	
	Car formulaCar = new Car(this, 250, 250);
	String keyPressed = "NONE";
	
	public void settings() {
		size(500,500);
	}
	
	public void draw() {
		background(255);
		String carVel = "Speed:";
		carVel += formulaCar.returnVelocity();
		fill(150);
		text(keyPressed, 20, 20);
		text(carVel, 20, 40);
		noFill();
		formulaCar.physicUpdate(keyPressed);
		formulaCar.render();
		System.out.println(keyPressed);
	}
	
	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == UP) {
				//System.out.println("UP+");
				keyPressed = "UP";
			} else if (keyCode == DOWN) {
				//System.out.println("DOWN+");
				keyPressed = "DOWN";
			} else if (keyCode == LEFT) {
				//System.out.println("LEFT+");
				keyPressed = "LEFT";
			} else if (keyCode == RIGHT) {
				//System.out.println("RIGHT+");
				keyPressed = "RIGHT";
			}
		}
	}
	
	public void keyReleased() {
		keyPressed = "NONE";
	}
	
	public static void main(String[] args) {
		String[] arguments = {"Sketch"};
		Main instance = new Main();
		PApplet.runSketch(arguments, instance);
	}

}
