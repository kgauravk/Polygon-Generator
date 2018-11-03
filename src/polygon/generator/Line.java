package polygon.generator;


public class Line {
	
private Point p1,p2;
	
Line(Point p1,Point p2)
{
	this.p1=p1;
	this.p2=p2;
}
public Point getpoint1()
{
	return p1;
}
public Point getpoint2()
{
	return p2;
}
public double getLength()
{
	double d1=(double)p1.getX()-p2.getX();
	double d2=(double)p1.getY()-p2.getY();
	double d3=Math.sqrt(Math.pow(d1, 2)+Math.pow(d2, 2));
	return d3;
}
}
