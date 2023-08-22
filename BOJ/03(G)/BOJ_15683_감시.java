import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 15683. ����
 * 1. �繫�� n x m
 * 2. CCTV 5���� ����
 * 3-1. CCTV�� ������ �� �ִ� ���⿡ �ִ� ĭ ��ü�� ������ �� �ִ�.
 * 3-2. CCTV�� `��`�� ����� �� ������, CCTV�� ����� �� �ִ�.
 * 3-3. CCTV�� 90�� �������� ȸ���� �� �ְ�, �����Ϸ��� �ϴ� ������ ���� �Ǵ� ���ο��� �Ѵ�.
 * 4. 0: ��ĭ, 1~5: CCTV, 6: ��
 * 
 * => CCTV�� `����`�� ������ ���ؼ� �簢 ������ �ּ� ũ�� ���ϱ�
 * 
 * Ǯ��
 * 0. CCTV�� �ִ� ���� 8�� => 4^8 = 2^16 ����� ��
 * 1. �簢 ����� 0�� �Ǵ� ����
 * 2. 2^16���� ����� ���� ����Ͽ� CCTV ������ ���� ���� �ּҰ� ����
 * 
 */
public class BOJ_15683_���� {
	
	static int[][] board;
	static int rowLen, colLen;
	static List<Cctv> cctvList;
	static int cctvLen;
	
	static class Cctv {
		
		int row; int col;
		// cctv ����
		int type;
		// ���� ����
		int dir;
		public Cctv(int row, int col, int type, int dir) {
			this.row = row;
			this.col = col;
			this.type = type;
			this.dir = dir;
		}
	}
	
	// �ð�������� (��,��,��,��)
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		// ����� �� �ʱ�ȭ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		rowLen = Integer.parseInt(st.nextToken());
		colLen = Integer.parseInt(st.nextToken());
		board = new int[rowLen][colLen];
		cctvList = new ArrayList<>();
		
		for(int row=0; row<rowLen; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<colLen; col++) {
				board[row][col] = Integer.parseInt(st.nextToken());
				
				// cctv��, ����Ʈ�� �ֱ�
				if(board[row][col] >= 1 && board[row][col] <=5) {
					cctvList.add(new Cctv(row, col, board[row][col], 0));
				}
			}
		}
		answer = Integer.MAX_VALUE;
		cctvLen = cctvList.size();
		recur(0);
		System.out.println(answer);
	}
	
	static void recur(int depth) {
		
		if(depth == cctvLen) {
			// cctv ���� �����Ǹ�,
			// �簢 ���� ����ϱ�
			answer = Math.min(answer, calculate());
		}
		else {
			for(int dir=0; dir<4; dir++) {
				cctvList.get(depth).dir = dir;
				recur(depth+1);
			}
		}
	}
	
	static int calculate() {
		
		int[][] tempBoard = copyArr();

		// 9�� cctv ���� ���
		for(Cctv cctv : cctvList) {
			
			monitor(cctv, tempBoard);
		}
		
		// ��� �� ��ĭ ���
		int blankCount = 0;
		for(int row=0; row<rowLen; row++) {
			for(int col=0; col<colLen; col++) {
				if(tempBoard[row][col] == 0) blankCount++;
			}
		}
		return blankCount;
	}
	
	
	static void monitor(Cctv cctv, int[][] tempBoard) {
		
		// 9�� cctv ���� ���
			
		// cctv.type�� ���� ���⸸ŭ ���ϴ°� �߰��ȴ�.
		int dirCountLen = 1;
		if(cctv.type == 3) dirCountLen = 2;
		else if(cctv.type == 4) dirCountLen = 3;
		else if(cctv.type == 5) dirCountLen = 4;
		
		// 3���� ���� �����̾�� �� => ������ �ð���� 90���� �������
		for(int dirCount=0; dirCount<dirCountLen; dirCount++) {
			
			int nextDir = (cctv.dir + dirCount) % 4; 
			int nextRow = cctv.row + dr[nextDir];
			int nextCol = cctv.col + dc[nextDir];
			while(nextRow >= 0 && nextCol >= 0 && nextRow < rowLen && nextCol < colLen && tempBoard[nextRow][nextCol] != 6) {
				
				// CCTV�� 9�� �ٲ㵵 ����� ����. ������ cctvList�� ��ġ�� �����صױ� ������
				tempBoard[nextRow][nextCol] = 9;
				
				nextRow += dr[nextDir];
				nextCol += dc[nextDir];
			}
		}
		
		if(cctv.type == 2) {
			// �ݴ� ���� ���
			int nextRow = cctv.row - dr[cctv.dir];
			int nextCol = cctv.col - dc[cctv.dir];
			
			while(nextRow >= 0 && nextCol >= 0 && nextRow < rowLen && nextCol < colLen && tempBoard[nextRow][nextCol] != 6) {
				
				// CCTV�� 9�� �ٲ㵵 ����� ����. ������ cctvList�� ��ġ�� �����صױ� ������
				tempBoard[nextRow][nextCol] = 9;
				
				nextRow -= dr[cctv.dir];
				nextCol -= dc[cctv.dir];
			}
		}
	}
	
	static int[][] copyArr() {
		
		int[][] tempBoard = new int[rowLen][colLen];
		
		for(int row=0; row<rowLen; row++) {
			for(int col=0; col<colLen; col++) {
				tempBoard[row][col] = board[row][col];
			}
		}
		return tempBoard;
	}
	

}
