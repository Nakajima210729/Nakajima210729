package study_2022_06_27;

public class DrawCircle_2 {
	public static void main(String[] args) {
		
		//円の直径・半径
		final int DIAMETER =30;
		final double RADIUS = DIAMETER / 2;
		
		double center = (double)(DIAMETER - 1) / 2;
		
		for (int y = 0; y < DIAMETER; y++) {
			for (int x = 0; x < DIAMETER; x++) {
				double squaredDistance = Math.pow(x - center, 2) + Math.pow(y - center, 2);
				if (Math.abs(squaredDistance - RADIUS*RADIUS) <= RADIUS) {
					System.out.print("XX");
				}else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
		
	}
}
