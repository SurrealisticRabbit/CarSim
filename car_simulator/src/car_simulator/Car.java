package car_simulator;

import processing.core.PApplet;

public class Car {
	private PApplet instance;
	int x;
	int y;
	int angle;
	int car_length = 40;
	int car_width = 20;
	double acceleration = 0.1;
	double velocityY;
	double velocityX;
	double maxVelocity = 5;
	double frictionCoefficient = 0.99;
	
	public Car(PApplet instance, int x, int y) {
		this.instance = instance;
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.car_length = car_length;
		this.car_width = car_width;
		this.acceleration = acceleration;
		this.velocityY = velocityY;
		this.velocityX = velocityX;
		this.maxVelocity = maxVelocity;
		this.frictionCoefficient = frictionCoefficient;
	}
	
	public void physicUpdate(String keyPress) {
		if (keyPress == "UP") {
			if (this.velocityY > -this.maxVelocity) {
				this.velocityY -= this.acceleration;
				System.out.println("added");
			}
		}
		if (keyPress == "DOWN") {
			if (this.velocityY < this.maxVelocity) {
				this.velocityY += this.acceleration;
				System.out.println("added");
			}
		}
		
		// Performing physics calc
		this.x += this.velocityX;
		this.y += this.velocityY;
		this.velocityX *= this.frictionCoefficient;
		this.velocityY *= this.frictionCoefficient;
		
	}
	
	public void render() {
		// Front Left
		this.instance.rect(this.x - 5, this.y - 5, 5, 10);
		// Front Right
		this.instance.rect(this.x + 20, this.y - 5, 5, 10);
		// Rear Left
		this.instance.rect(this.x - 5, this.y + 35, 5, 10);
		// Rear Left
		this.instance.rect(this.x + 20, this.y + 35, 5, 10);
		this.instance.rect(this.x, this.y, this.car_width, this.car_length);
	}
	
	public double returnVelocity() {
		return this.velocityY;
	}
}
