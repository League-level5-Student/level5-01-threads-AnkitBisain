package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot a = new Robot(400, 400);
		Robot b = new Robot(600, 550);
		Robot c = new Robot(800, 400);
		Robot d = new Robot(1000, 550);
		Robot e = new Robot(1200, 400);

		Thread c1 = new Thread(()->circle(a));
		Thread c2 = new Thread(()->circle(b));
		Thread c3 = new Thread(()->circle(c));
		Thread c4 = new Thread(()->circle(d));
		Thread c5 = new Thread(()->circle(e));
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();

	}

	public static void circle(Robot r) {
		r.penDown();
		for(int i = 0; i < 90; i++) {
			r.move(12);
			r.turn(4);
		}
		r.hide();
	}
	
}
