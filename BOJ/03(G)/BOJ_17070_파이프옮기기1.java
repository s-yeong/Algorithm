import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 17070. ������ �ű�� 1
 * 1. �� ��� ���� 1���� �����ϰ� '2��'�� ���ӵ� ĭ�� ������
 * 2. ������ ȸ�� ���� = ����, ����, �밢�� (���� ����)
 * 2. ������ �̴� ���� = ��, ���Ʒ�, �Ʒ�
 * 3. ��ĭ�� �����ؾ���. �� ������ X
 * 
 * 4-1. �������� ������ ��� => ��, ���Ʒ�
 * 4-2. �������� ������ ��� => �Ʒ�, ���Ʒ�
 * 4-3. �������� �밢���� ��� => ��, �Ʒ�, ���Ʒ� 
 * => ù° �ٿ� �������� ���� ���� (N, N)���� �̵���Ű�� ����� �� ���, ������ 0 ���
 * 
 * ���� �ذ�
 * 1. ���� ���� (N, N)���� �������� ���� üũ �ؾ��ϱ� ������ 2�� �� ���ӵ� ĭ �� ���� ���� �������� �ű��
 * 2. ���� ���⿡ ���� �̴� ����� �ٸ��� ������ ������ �����ؾ� ��  
 * 3. dfs�� ���� '��ĭ�� ���'�� ������ �б�, ���� ������ (N, N)�� ���� ���� ��
 */
public class BOJ_17070_�������ű��1 {

	// ���� ũ��
	static int houseSize;
	// ��
	static int[][] house;
	
	static final int HORIZONTAL = 0;
	static final int VERTICAL = 1;
	static final int DIAGONAL = 2;
	
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// �Է� �� �ʱ�ȭ
		houseSize = Integer.parseInt(br.readLine());
		house = new int[houseSize+1][houseSize+1];
		for(int rowIdx = 1; rowIdx <= houseSize; rowIdx++) {
			st = new StringTokenizer(br.readLine());
			for(int colIdx = 1; colIdx<= houseSize; colIdx++) {
				house[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
			}
		}
		answer = 0;
		dfs(2, 1, HORIZONTAL);
		System.out.println(answer);
	}
	
	static void dfs(int col, int row, int dir) {
		
		// �� �� ������ ����
		if(row > houseSize || col > houseSize || house[row][col] == 1) {
			return;
		}
		
		if(col == houseSize && row == houseSize) {
			answer++;
		}
		else {
			
			// 4-1. �������� ������ ��� => ��, ���Ʒ�
			if(dir == HORIZONTAL) {
				// ��
				dfs(col+1, row, HORIZONTAL);
			}
			
			// 4-2. �������� ������ ��� => �Ʒ�, ���Ʒ�
			else if(dir == VERTICAL) {
				// �Ʒ�
				dfs(col, row+1, VERTICAL);
				
			}
			
			// 4-3. �������� �밢���� ��� => ��, �Ʒ�, ���Ʒ�
			else if(dir == DIAGONAL) {
				// ��
				dfs(col+1, row, HORIZONTAL);
				// �Ʒ�
				dfs(col, row+1, VERTICAL);
			}
			
			// ���Ʒ��� ��� ����
			// ���Ʒ��� ��� ���� ��ġ �Ӹ� �ƴ϶� ������, �Ʒ� ���� ��ĭ �̾�� ��
			if(col+1 > houseSize || row+1 > houseSize || house[row][col+1] == 1 || house[row+1][col] == 1) 
				return;
			dfs(col+1, row+1, DIAGONAL);
		}
	}
	
	
}
