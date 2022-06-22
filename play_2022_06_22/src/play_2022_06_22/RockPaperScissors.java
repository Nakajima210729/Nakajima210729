package play_2022_06_22;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	private static Scanner sc = new Scanner(System.in);
	private static Random rd = new Random();

	private final static int WIN = 2;
	private final static int LOSE = 1;
	private final static int DRAW = 0;

	private final static boolean SAME = true;

	private RockPaperScissors() {
	}

	public static void main(String[] args) {
		greeting();
		while(true) {
			int resultRockPaperScissors = playRockPaperScissors();
			boolean resultFingerPointingGame = playFingerPointingGame();
			
			if(resultFingerPointingGame == SAME) {
				System.out.println();
				if(resultRockPaperScissors == WIN) {
					System.out.println("(* >ω<): おめでとう！あなたの勝ち！");
				}else {
					System.out.println("(* -ω-): 残念！あなたの負け…");
				}
				break;
			}
			
		}
		System.out.println("(oωo)ﾉｼ: 遊んでくれてありがとう");
		
	}

	private static void greeting() {
		System.out.println("(* oωo): ジャンケンをします！");
		System.out.println("          (any:次へ)");
		System.out.print("[input]>> ");
		sc.nextLine();
	}

	private static int playRockPaperScissors() {

		String[] hands = { "グー✊", "チョキ✌", "パー✋" };
		String[] statements = { "ジャンケン…", "あいこで…" };

		int ptr = 0;

		while (true) {
			try {
				System.out.println();
				System.out.println("(*`oωo): " + statements[ptr]);
				System.out.println("          (0:グー✊ / 1:チョキ✌ / 2:パー✋)");
				System.out.print  ("[input]>> ");

				int playerHand = Integer.parseInt(sc.nextLine());
				int computerHand = rd.nextInt(3);

				System.out.println();

				if (playerHand < 0 || playerHand > 2) {
					throw new NumberFormatException();
				}

				System.out.println("(* >ω<): YOU: " + hands[playerHand] + 
										  " / CPU: " + hands[computerHand]);

				int rpsResult = (playerHand - computerHand + 3) % 3;

				Thread.sleep(500);

				switch (rpsResult) {
				case WIN:
					return WIN;

				case LOSE:
					return LOSE;

				case DRAW:
					ptr = 1;
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("(* xωx): 0, 1, 2のどれかを入力してね…！");

			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}

	}

	private static boolean playFingerPointingGame() {
		
		String[] fingers = {"←", "↓", "↑", "→"};
		
		while (true) {
			System.out.println();
			System.out.println("(*`oωo): あっち向いて…");
			System.out.println("          (0:← / 1:↓ / 2:↑ / 3:→)");
			System.out.print  ("[input]>> ");
;			try {
				int playerFinger = Integer.parseInt(sc.nextLine());
				int computerFinger = rd.nextInt(4);

				System.out.println();
				
				if (playerFinger < 0 || playerFinger > 3) {
					throw new NumberFormatException();
				}
				
				System.out.println("(* >ω<): YOU: " + fingers[playerFinger] +
										  " / CPU: " + fingers[computerFinger]);
				Thread.sleep(500);
				return (playerFinger == computerFinger);

			} catch (NumberFormatException e) {
				System.out.println("(* xωx): 0, 1, 2, 3のどれかを入力してね…！");
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}
