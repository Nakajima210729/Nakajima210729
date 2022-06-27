package study_2022_06_27;

public class DrawOval {
	
	//円の直径・半径
	private final static int DIAMETER = 30;
	private final static int RADIUS = DIAMETER / 2;
	
	//縦横比
	private final static double expansionRate_x = 2.0;
	private final static double expansionRate_y = 1.0;
	
	//円の中心の座標
	private static double center_x = (DIAMETER * expansionRate_x - 1) / 2;
	private static double center_y = (DIAMETER * expansionRate_y - 1) / 2;
	
	//出力する円を描くパレットの大きさ
	private static int  figureSize_x = (int)Math.ceil(DIAMETER * expansionRate_x);
	private static int figureSize_y = (int)Math.ceil(DIAMETER * expansionRate_y);
	
	//true: Xを描く | false: .を描く
	//中身が詰まっている版
	private static boolean[][] areDrawingFill = new boolean[figureSize_y][figureSize_x];
	//中身がくり抜かれている版
	private static boolean[][] areDrawingBorder = new boolean[figureSize_y][figureSize_x];
	
	
	public static void main(String[] args) {
		
		//中身が詰まった円(楕円)を作る
		for (int y = 0; y < figureSize_y; y++) {
			for (int x = 0; x < figureSize_x; x++) {
				//楕円の方程式の左辺
				//良ければこちらを参考にどうぞ>> https://univ-juken.com/daen
				double leftOfOvalEquation =
						  Math.pow((x - center_x) / expansionRate_x, 2)
						+ Math.pow((y - center_y) / expansionRate_y, 2);
				
				//格子点(x, y)が楕円のグラフの内側にある: true | 外側にある: false
				areDrawingFill[y][x] = (leftOfOvalEquation <= Math.pow(RADIUS, 2));
				areDrawingBorder[y][x] = (leftOfOvalEquation <= Math.pow(RADIUS, 2));
			}
		}
		
		//中身をくり抜く
		for (int y = 1; y < figureSize_y - 1; y++) {
			for (int x = 1; x < figureSize_x - 1; x++) {
				if (isAroundTrue(x, y)) {
					areDrawingBorder[y][x] = false;
				}
			}
		}
		
		//バリを取り除く
		for (int y = 1; y < figureSize_y - 1; y++) {
			for (int x = 1; x < figureSize_x - 1; x++) {
				if (isBurr(x, y)) {
					areDrawingBorder[y][x] = false;
				}
			}
		}
		
		//print文で円(楕円)を出力
		for (int y = 0; y < figureSize_y; y++) {
			for (int x = 0; x < figureSize_x; x++) {
				if (areDrawingBorder[y][x]) {
					System.out.print("X");
				}else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
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
	private static boolean isBurr(int x, int y) {
		return (  (areDrawingBorder[y][x - 1] || areDrawingBorder[y][x + 1])
			    &&(areDrawingBorder[y - 1][x] || areDrawingBorder[y + 1][x]) );
	}
	
}
