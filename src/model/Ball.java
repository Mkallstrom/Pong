package model;

import java.awt.Point;

public class Ball {

	Point Velocity;
	Point Position;
	int Speed;
	int InitSpeed;
	
	public Ball(){
		
	}
	
	public Ball (Point Position, Point Velocity, int Speed, int InitSpeed){
		this.Position = Position;
		this.Velocity = Velocity;
		this.Speed = Speed;
		this.InitSpeed = InitSpeed;
	}
	
}
