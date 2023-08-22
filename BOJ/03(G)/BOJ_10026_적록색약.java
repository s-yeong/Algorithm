
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 10026. ���ϻ���
 * 1. R, G, B �� �ϳ��� ��ĥ�� �׸�
 * 2. ���ϻ����� ����� ���� ���� �ƴ� ����� ���� �� ������ ���� ���ϴ� ���α׷��� �ۼ�
 *
 * Ǯ��
 * 1. ���ϻ����� ����� �Ϲ� ����� �迭 ���� ���� ���
 * 2. ���ϻ��� �迭�� �ʷϻ��� �Է¹޾��� �� ���������� �ٲ㼭 ����
 * 3. �湮�� ��� 'X' ó��
 */
public class BOJ_10026_���ϻ��� {
	
	static int boardLen;
	
	// �Ϲ� �׸���, ������ �� �׸���
	static char[][] board, boardRG;
	
	// �����¿�
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	// ����
	static int answer;
	static int answerRG;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boardLen = Integer.parseInt(br.readLine());
		board = new char[boardLen][boardLen];
		boardRG = new char[boardLen][boardLen];;
		answer = 0;
		answerRG = 0;
		
		
		for(int row=0; row<boardLen; row++) {
			board[row] = br.readLine().toCharArray();

			for(int col=0; col<boardLen; col++) {
				//2. ���ϻ��� �迭�� �ʷϻ��� �Է¹޾��� �� ���������� �ٲ㼭 ����
				boardRG[row][col] = (board[row][col] == 'G')? 'R' : board[row][col];
			}
		}
		
		for(int row=0; row<boardLen; row++) {
			for(int col=0; col<boardLen; col++) {
				// �湮 ��������, �湮
				if(board[row][col] != 'X') {
					dfs(row, col, board[row][col], board);
					answer++;
				}
				if(boardRG[row][col] != 'X') {
					dfs(row, col, boardRG[row][col], boardRG);
					answerRG++;
				}
			}
		}
		System.out.println(answer + " " + answerRG);
	}
	
	
	static void dfs(int row, int col, char color, char[][] board) {
		
		for(int dir=0; dir<4; dir++) {
			
			int nextRow = row + dr[dir];
			int nextCol = col + dc[dir];
			
			// ���� ������ ��� �̵�
			if(nextRow >= 0 && nextCol >= 0 && nextRow < boardLen && nextCol < boardLen &&
					board[nextRow][nextCol] == color) {
				
				// �湮 ǥ��
				board[nextRow][nextCol] = 'X';
				
				dfs(nextRow, nextCol, color, board);
			}
		}
		
	}



}
