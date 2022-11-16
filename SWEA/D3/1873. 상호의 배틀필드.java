import java.io.*;
import java.util.*;


class Solution {
	static int H,W;
	static char[][] board;
	
	static void solution(char[] in, int idxI, int idxJ) {
		
		for(char x : in) {
			if(x == 'U') {
				if(idxI - 1 >= 0 && board[idxI-1][idxJ] == '.') {
					board[idxI][idxJ] = '.';
					idxI = idxI-1;
				}
				board[idxI][idxJ] = '^';
			}
			else if(x == 'D') {
				if(idxI + 1 < H && board[idxI+1][idxJ] == '.') {
					board[idxI][idxJ] = '.';
					idxI = idxI+1;
				}
				board[idxI][idxJ] = 'v';
			}
			else if(x == 'L') {
				if(idxJ - 1 >= 0 && board[idxI][idxJ-1] == '.') {
					board[idxI][idxJ] = '.';
					idxJ = idxJ-1;
				}
				board[idxI][idxJ] = '<';
			}
			else if(x == 'R') {
				if(idxJ + 1 < W && board[idxI][idxJ+1] == '.') {
					board[idxI][idxJ] = '.';		
					idxJ = idxJ+1;
				}
				board[idxI][idxJ] = '>';
			}
			else { // ��ź �߻�
				char tmp = board[idxI][idxJ];
				// ���� �ε����� -> ��ź �Ҹ�, �����̸� �� �ı��Ǿ� ����, ��ö�̸� �ƹ��ϵ� X
				int nI=idxI;
				int nJ=idxJ;
				// �߻� ����
				switch(tmp) {
				case '^': nI++; break;
				case 'v': nI--; break;
				case '<': nJ--; break;
				case '>': nJ++; break;
				}
				
				while(nI>=0 && nJ >=0 && nI < H && nJ < W) {
					// ���� ���� �ε����� -> ����, ����
					if(board[nI][nJ] == '*') {
						board[nI][nJ] = '.';
						break;
					}
					// ��ö�̸�,����
					else if(board[nI][nJ] == '#') break;
					
					else {
						switch(tmp) {
						case '^': nI++; break;
						case 'v': nI--; break;
						case '<': nJ--; break;
						case '>': nJ++; break;
						}
					}
				}
				
			}
			
		}
	}
	// alt+s+a+g  : �Ű����� �ִ� ������ ����
 public static void main(String args[]) throws Exception {
	 
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   StringBuilder sb = new StringBuilder();
   int T = Integer.parseInt(br.readLine().trim());
   
   for(int tc = 1; tc<=T; tc++) {
	  
	 
	  
	  StringTokenizer st = new StringTokenizer(br.readLine());
	  H = Integer.parseInt(st.nextToken());	// ����
	  W = Integer.parseInt(st.nextToken());	// �ʺ�
	  // HxW ������
	  board = new char[H][W];
	  
	  for(int i=0; i<H; i++) {
		  //���̰� W�� ���ڿ�
		  board[i] = br.readLine().toCharArray();
	  }
	  // ����ڰ� ���� �Է��� ����
	  int N = Integer.parseInt(br.readLine());
	  // ���̰� N�� ���ڿ�
	  char[] in = br.readLine().toCharArray();
	  
	  int idxI = 0;
	  int idxJ = 0;
	  for(int i=0; i<H; i++) {
		  for(int j=0; j<W; j++) {
			  // ���� ��ġ �ľ�
			  if(board[i][j] == '^' || board[i][j] == 'v' 
					  || board[i][j] == '<' || board[i][j] == '>') {
				  idxI = i;
				  idxJ = j;
			  }
		  }
	  }
	  
	  solution(in, idxI, idxJ);
	   
	   
	  sb.append("#").append(tc).append(" ");
	  for(int i=0; i<H; i++) {
		  for(int j=0; j<W; j++) {
			  sb.append(board[i][j]);
		  }
		  sb.append("\n");
	  }
   }
   System.out.println(sb);	
 }
}