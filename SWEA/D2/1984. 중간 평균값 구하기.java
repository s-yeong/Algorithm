import java.io.*;
import java.util.*;


class Solution {
	// alt+s+a+g  : �Ű����� �ִ� ������ ����
 public static void main(String args[]) throws Exception {
	 
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   StringBuilder sb = new StringBuilder();
   int T = Integer.parseInt(br.readLine().trim());
   
   for(int test_case = 1; test_case<=T; test_case++) {

	   // �ִ� �� �ּ� �� ���� ������ ��հ�
	   int[] arr = new int[10];
	   StringTokenizer st = new StringTokenizer(br.readLine());
	   for(int i=0; i<10; i++) arr[i] = Integer.parseInt(st.nextToken());
	   Arrays.sort(arr);
	   int sum = 0;
	   for(int i=1; i<9; i++) sum += arr[i];
	   // �Ҽ� ù°�ڸ� ���� �ݿø�
	   long avg = Math.round(sum/8.0);
	   
	   sb.append("#").append(test_case).append(" ").append(avg).append("\n");
   }
   System.out.println(sb);
 }
}