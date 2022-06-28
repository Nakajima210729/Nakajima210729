package study_2022_06_27;

public class DrawCircle {
	//円の直径・半径
	private final static int DIAMETER =30;
	private final static double RADIUS = DIAMETER / 2;
	
	//円の中心の座標
	private static double center_x = (double)(DIAMETER - 1) / 2;
	private static double center_y = (double)(DIAMETER - 1) / 2;
	
	//true: Xを描く | false: .を描く
	//中身が詰まっている版
	private static boolean[][] areDrawingFill = new boolean[DIAMETER][DIAMETER];
	//中身がくり抜かれている版
	private static boolean[][] areDrawingBorder = new boolean[DIAMETER][DIAMETER];
	
	
	public static void main(String[] args) {
		
		//中身が詰まった円を作る
		for (int y = 0; y < DIAMETER; y++) {
			for (int x = 0; x < DIAMETER; x++) {
				//円の方程式(x-a)²+(y-b)²=r²　の左辺
				double leftOfOvalEquation =
						  Math.pow(x - center_x, 2)
						+ Math.pow(y - center_y, 2);
				
				//格子点(x, y)が円のグラフの内側にある: true | 外側にある: false
				areDrawingFill[y][x] = (leftOfOvalEquation <= Math.pow(RADIUS, 2));
				areDrawingBorder[y][x] = (leftOfOvalEquation <= Math.pow(RADIUS, 2));
			}
		}
		
		//中身を取り除く
		for (int y = 1; y < DIAMETER - 1; y++) {
			for (int x = 1; x < DIAMETER - 1; x++) {
				if (shouldRemove(x, y)) {
					areDrawingBorder[y][x] = false;
				}
			}
		}
		
		//print文で円を出力
		for (int y = 0; y < DIAMETER; y++) {
			for (int x = 0; x < DIAMETER; x++) {
				if (areDrawingBorder[y][x]) {
					System.out.print("XX");
				}else {
					System.out.print("..");
				}
			}
			System.out.println();
		}
		return;
	}
	
	//周囲8マスがすべてtrueである: true | 1マスでもfalseである: false
	private static boolean isAroundTrue(int x, int y) {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (areDrawingFill[y + i][x + j] == false) {
					return false;
				}
			}
		}
		return true;
	}
	
	//バリである: true | バリでない: false
	private static boolean shouldRemove(int x, int y) {
		return (   areDrawingFill[y][x - 1] && areDrawingFill[y][x + 1]
			    && areDrawingFill[y - 1][x] && areDrawingFill[y + 1][x] );
	}
	
}
