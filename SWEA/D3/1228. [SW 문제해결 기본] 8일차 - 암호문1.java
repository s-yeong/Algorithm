import java.io.*;
import java.util.*;


public class Solution {
	
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= 10; test_case++) {

        	// ��ȣ���� ����
            int n = Integer.parseInt(br.readLine());
            
            // ���� ��ȣ��        
            ArrayList<Integer> arr = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int i=0; i<n; i++) arr.add(Integer.parseInt(st.nextToken()));
        	
            int m = Integer.parseInt(br.readLine());
            
            // ������ ����� ó�� 10��
            // x y s => x : i��ġ �ٷ� ������  y���� ���� ����
            
            int cnt = 0;
           
            while(cnt < m) {
            	if(st.nextToken().equals("I")) cnt++;
            	
            	int x = Integer.parseInt(st.nextToken());
            	int y = Integer.parseInt(st.nextToken());
            	for(int i=0; i<y; i++) {
            		arr.add(x++, Integer.parseInt(st.nextToken()));
            	}
            }
            
        	
            
            sb.append("#").append(test_case).append(" ");
            for(int i=0; i<10; i++) sb.append(arr.get(i)).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}