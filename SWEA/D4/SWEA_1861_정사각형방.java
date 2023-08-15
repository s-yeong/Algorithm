import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1861. ���簢�� �� 
 * 1. N^2�� ��, 1�̻� N2 ������ �� Ai
 * 2. �����¿� �̵�
 * 3. �̵��Ϸ��� ���� ���� + �̵��Ϸ��� �濡 ���� ���ڰ� ���� �濡 ���� ���ں��� ��Ȯ�� 1 �� Ŀ���� 
 * => ó�� � ���� ���� �濡�� �־�� ���� ���� ������ ���� �̵��� �� �ִ��� ���ϱ�
 * 
 * ���� Ǯ��
 * N �ִ� 1000, N^2 �ִ�� 100��
 * ��� ����� Ž�� => N^2*N^2 => �ð��ʰ� => BFS + �޸������̼�
 * ��� �� ���ڰ� �ߺ��Ǵ� ���� ���� -> �ش� �� �������� �� �� �ִ� ���� �ϳ��ۿ� ����
 */
public class SWEA_1861_���簢���� {
	
	static int N;
	static int[][] roomArr;
	
	// �����¿�
	static int[] deltaCol = {0,0,-1,1};
	static int[] deltaRow = {-1,1,0,0};
	
	// �� �濡�� �� �� �ִ� ���� ���� ���� �迭
	static int[][] roomCountArr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			N = Integer.parseInt(br.readLine().trim());
			roomArr = new int[N][N];
			roomCountArr = new int[N][N];
			
			for(int rowIdx=0; rowIdx<N; rowIdx++) {
				st = new StringTokenizer(br.readLine().trim());
				for(int colIdx=0; colIdx<N; colIdx++) {
					roomArr[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
				}
			}
			
			// ó���� ����ؾ� �ϴ� ���ȣ + �ִ� ��� ���� �̵��� �� �ִ��� 
			int maxRoomNumber = 0;
			int maxRoomCount = 0;
			for(int rowIdx=0; rowIdx<N; rowIdx++) {
				for(int colIdx=0; colIdx<N; colIdx++) {
					bfs(rowIdx, colIdx);
					
					if(roomCountArr[rowIdx][colIdx] > maxRoomCount) {
						maxRoomCount = roomCountArr[rowIdx][colIdx];
						maxRoomNumber = roomArr[rowIdx][colIdx];
					}
					// �ִ밪�� ���� ��� �ּ� ��ȣ
					else if(roomCountArr[rowIdx][colIdx] == maxRoomCount) {
						maxRoomNumber = Math.min(maxRoomNumber, roomArr[rowIdx][colIdx]);
					}
				}
			}
			
			// ó���� ����ؾ� �ϴ� ���ȣ + �ִ� ��� ���� �̵��� �� �ִ��� 
			for(int rowIdx=0; rowIdx<N; rowIdx++) {
				for(int colIdx=0; colIdx<N; colIdx++) {
					if(roomCountArr[rowIdx][colIdx] > maxRoomCount) {
						maxRoomCount = roomCountArr[rowIdx][colIdx];
						maxRoomNumber = roomArr[rowIdx][colIdx];
					}
					// �ִ밪�� ���� ��� �ּ� ��ȣ
					else if(roomCountArr[rowIdx][colIdx] == maxRoomCount) {
						maxRoomNumber = Math.min(maxRoomNumber, roomArr[rowIdx][colIdx]);
					}
				}
			}
			
			// �ڱ� �ڽŵ� �����ؾ� �ϹǷ� 1 ���ؼ� ���
			sb.append("#").append(testCase).append(" ").append(maxRoomNumber).append(" ").append(maxRoomCount+1).append("\n");
		}
		System.out.print(sb);
	}
	
	static void bfs(int startRow, int startCol) {
		
		Queue<int[]> Q = new ArrayDeque<>();
		
		Q.offer(new int[] {startRow, startCol});
		
		while(!Q.isEmpty()) {
			
			// ���� ��
			int[] cur = Q.poll();
			
			for(int direction=0; direction<4; direction++) {
				
				int nextRow = cur[0] + deltaRow[direction];
				int nextCol = cur[1] + deltaCol[direction];
				
				// �� �� �ִ� ����
				if(nextRow >= 0 && nextCol >= 0 && nextRow < N && nextCol < N) {
					
					if(roomArr[cur[0]][cur[1]] + 1 == roomArr[nextRow][nextCol]) {
						
						// ���� ���� �ߴٸ�, �̹� ���Ѱ���
						if(roomCountArr[nextRow][nextCol] != 0) {
							// ���� ���� ���� �ִ� �� ���� + ������ ���������� �� �� �ִ� �� ���� + 1
							roomCountArr[startRow][startCol] = roomCountArr[startRow][startCol] + roomCountArr[nextRow][nextCol] + 1;
							return;
						}
						
						roomCountArr[startRow][startCol]++;
						Q.offer(new int[]{nextRow, nextCol});
					}
					
				}
				
			}
			
		}
		
		
		
	}
}
