package _02_Advanced_Robot_Race;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.
	public static void main(String[] args) throws InterruptedException{
		int numberOfRobots = 3;
		Random r = new Random();
		int winner = 0;
		Robot[] robots = new Robot[numberOfRobots];
		for (int i = 0; i < numberOfRobots; i++) {
			robots[i] = new Robot();

			robots[i].setX(100 + Math.round(850 / numberOfRobots) * i);
			robots[i].setY(500);
			robots[i].setAngle(0);
		}
		

		while(robots[0].getY() > 50 && robots[1].getY() > 50 && robots[2].getY() > 50) {
			Thread t1 = new Thread(() -> goRand(robots[0]));
			Thread t2 = new Thread(() -> goRand(robots[1]));
			Thread t3 = new Thread(() -> goRand(robots[2]));
			t1.start();
			t2.start();
			t3.start();
			t1.join();
			t2.join();
			t3.join();
			TimeUnit.SECONDS.sleep(1);
		}
		
		for (int i = 0; i < 3; i++) {
			if (robots[i].getY() < robots[winner].getY()) {
				winner = i;
			}
		}

		JOptionPane.showMessageDialog(null, "Robot " + (winner+1) + " wins!!!");

	}

	public static void goRand(Robot rr) {
		Random r = new Random();
		rr.move(r.nextInt(100));
	}
}
