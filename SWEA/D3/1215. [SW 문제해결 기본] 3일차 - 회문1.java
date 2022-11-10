import java.util.*;
import java.io.*;

class Solution {
	
	static boolean pal(String s) {
		
		StringBuilder sb = new StringBuilder(s);
		String tmp = sb.reverse().toString();
		if(s.equals(tmp)) return true;
		else return false;
	}

	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		for(int test_case=0; test_case<T; test_case++) {
			
			// ȸ�� ����
			int len = Integer.parseInt(br.readLine());
			
			char[][] arr = new char[8][8];
			
			// 8x8 �Է�
			for(int i=0; i<8; i++) {
				String s = br.readLine();
				for(int j=0; j<8; j++) {
					arr[i][j] = s.charAt(j); 
				}
			}
			
			int cnt = 0;
			
			// �����Ǵ�
			
			for(int i=0; i<8; i++) {
				int lt = 0;
				for(int rt = len; rt<=8; rt++) {

					// lt���� rt���� String ���� �����
					String s1= "";	// ����
					String s2= "";	// ����
					for(int j=lt; j<rt; j++) {
						s1 += arr[i][j];	
						s2 += arr[j][i];
					}
					
					// ȸ������ �Ǵ�
					if(pal(s1)) cnt++;
					if(pal(s2)) cnt++;
					
					lt++;
				}
			}
			
			
			
			
			sb.append("#").append(test_case+1).append(" ").append(cnt).append("\n");
		}
		
	
		
		System.out.println(sb);

	}
}