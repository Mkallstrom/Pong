package controller;
import static org.junit.Assert.*;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import model.*;

import org.junit.Test;


public class PongTest {

	@Test
	public void test() throws InterruptedException {
		final ControllerOptions options = new ControllerOptions();
		myPongModel model = new myPongModel(options.getLeftPlayer(), options.getRightPlayer());
		final Set<Input> input = new HashSet<Input>();
		Point middle = new Point(model.getFieldSize().width/2,model.getFieldSize().height/2);
		assertTrue(model.getBallPos().x == middle.x);
		assertTrue(model.getBallPos().y == middle.y);
		model.compute(input, 33);
		assertTrue(model.getBallPos().x == middle.x+model.getVelocity().x);
		assertTrue(model.getBallPos().y == middle.y+model.getVelocity().y);
		Point outside = new Point(model.getFieldSize().width,middle.y*2/3);
		model.setBallPos(outside);
		assertTrue(model.getScoreAsInt(BarKey.LEFT) == 0);
		model.compute(input,33);
		assertTrue(model.getBallPos().x == middle.x+model.getVelocity().x);
		assertTrue(model.getScoreAsInt(BarKey.LEFT) == 1);
		outside.x = 0;
		model.setBallPos(outside);
	    model.setVelocity(new Point(model.getVelocity().x*-1,model.getVelocity().y*-1));
		model.compute(input, 33);
		assertTrue(model.getScoreAsInt(BarKey.RIGHT) == 1);
	}

}
