import java.io.*;
import java.util.*;


class Solution {

	// alt+s+a+g  : �Ű����� �ִ� ������ ����
 public static void main(String args[]) throws Exception {
	 
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   StringBuilder sb = new StringBuilder();
   int T = Integer.parseInt(br.readLine().trim());
   for(int tc = 1; tc<=T; tc++) {
	   int answer = 0;
	   int N = Integer.parseInt(br.readLine());
	   // 0 : ���� �ӵ� ����
	   // 1 : ����
	   // 2 : ����
	   int v = 0; // �ӵ�
	   for(int i=0; i<N; i++) {
		   StringTokenizer st = new StringTokenizer(br.readLine());
		   int com = Integer.parseInt(st.nextToken());
		   switch(com) {
		   case 0 : break;
		   case 1 : 
			   v += Integer.parseInt(st.nextToken());;
			   break;
		   case 2 :
			   v -= Integer.parseInt(st.nextToken());;
			   break;
		   }
		   answer += v;
	   }
	   
	   sb.append("#").append(tc + " ").append(answer + "\n");
   }
   System.out.println(sb);
      
 }
}