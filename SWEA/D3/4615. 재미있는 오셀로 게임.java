import java.io.*;
import java.util.*;


class Solution {

	// alt+s+a+g  : �Ű����� �ִ� ������ ����
	static int[][] board;;
	static int N;
	// �»� �� ��� �� ���� �� ���� �� - 8
	static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
	static void sol(int x,int y, int bw) {
		
		for(int i=0; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			boolean flag = false;
			while(nx >=1 && ny >=1 && nx <= N && ny <= N && board[ny][nx] != 0) {

				if(board[ny][nx] == bw) {
					flag = true;
					break;
				}
				nx = nx + dx[i];
				ny = ny + dy[i];
			}
			
			
			while(flag) {
				if(nx == x && ny == y) break;
				board[ny][nx] = bw;
				nx -= dx[i];
				ny -= dy[i];
			}
		}
		
	}
 public static void main(String args[]) throws Exception {
	 
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   StringBuilder sb = new StringBuilder();
   int T = Integer.parseInt(br.readLine().trim());
   for(int tc = 1; tc<=T; tc++) {
	 
	   StringTokenizer st = new StringTokenizer(br.readLine());
	   N = Integer.parseInt(st.nextToken());
	   int M = Integer.parseInt(st.nextToken());
	   board = new int[N+1][N+1];
	   // �ʱⰪ �α�
	   // W B
	   // B W
	   board[N/2][N/2] = 2;
	   board[N/2+1][N/2+1] = 2;;
	   board[N/2][N/2+1] = 1;
	   board[N/2+1][N/2] = 1;
	   
	   // ���� -> ���� ���� �밢��
	   for(int i=0; i<M; i++) {
		   st = new StringTokenizer(br.readLine());
		   int x = Integer.parseInt(st.nextToken());
		   int y = Integer.parseInt(st.nextToken());
		   int bw = Integer.parseInt(st.nextToken());
		   board[y][x] = bw;
		   sol(x,y, bw);
	   }
	   
	   int bC = 0;
	   int wC = 0;
	   for(int i=1; i<=N; i++) {
		   for(int j=1; j<=N; j++) {
			   if(board[i][j] == 1) bC++;
			   if(board[i][j] == 2) wC++;
		   }
	   }
	   
	   sb.append("#").append(tc + " ").append(bC + " ").append(wC + "\n");
   }
   System.out.println(sb);
      
 }
}