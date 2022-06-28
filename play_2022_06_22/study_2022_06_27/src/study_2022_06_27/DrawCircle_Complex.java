package study_2022_06_27;

public class DrawCircle_Complex {
	public static void main(String[] args) {
		
		//円の直径・半径
		final int DIAMETER =30;
		final double RADIUS = DIAMETER / 2;
		
		//円の中心の座標
		double center_x = (double)(DIAMETER - 1) / 2;
		double center_y = (double)(DIAMETER - 1) / 2;
		
		boolean[][] areDrawing = new boolean[DIAMETER][DIAMETER];
		
		ComplexNumber z = new ComplexNumber();
		
		for(int i = 0; i < 8 * RADIUS; i++) {
			z.setPolar(RADIUS, i * (Math.PI / RADIUS / 4));
			
			int drawX = Math.min(DIAMETER - 1, (int)Math.round(z.getX() + center_x));
			int drawY = Math.min(DIAMETER - 1, (int)Math.round(z.getY() + center_y));
			
			areDrawing[drawY][drawX] = true;
		}
		
		//print文で円を出力
		for (int y = 0; y < DIAMETER; y++) {
			for (int x = 0; x < DIAMETER; x++) {
				if (areDrawing[y][x]) {
					System.out.print("XX");
				}else {
					System.out.print("..");
				}
			}
			System.out.println();
		}
	}
}

class ComplexNumber {
	
	private double x;
	private double y;
	private double r;
	private double theta;
	
	ComplexNumber(){}
	
	public void setCartesian(double x, double y) {
		this.x = x;
		this.y = y;
		this.r = Math.sqrt(x*x + y*y);
		this.theta = Math.acos(x / this.r);
	}
	
	public void setPolar(double r, double theta) {
		this.r = r;
		this.theta = theta;
		this.x = r * Math.cos(theta);
		this.y = r * Math.sin(theta);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getR() {
		return r;
	}
	
	public double getTheta() {
		return theta;
	}
}