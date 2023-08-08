import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1158. �似Ǫ�� ����
 * 1. 1���� n������ n���� ����� ���� �̷�鼭 �ɾ� �ִ�.
 * 2. ������� k��° ����� �����Ѵ�.
 * 3. n���� ����� ��� ���ŵ� �� ���� ����ϰ� ���ŵǴ� ������� ����Ѵ�.
 *	
 * "�������" k��° ����� �����Ѵ� => ť
 * ť���� �ְ� ���⸦ �ݺ��ϸ鼭 k��°�� �� �ȳְ� ����Ѵ�.
 */
public class BOJ_1158_�似Ǫ������ {

	
	public static void main(String[] args) throws IOException{
		
		// �Է�.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// ���.
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		Queue<Integer> Q = new ArrayDeque<>();
		
		for(int num=1; num<=n; num++) Q.offer(num);
		int count = 0;
		
		while(!Q.isEmpty()) {
			
			// ť���� �ְ� ���� ī��Ʈ
			count++;
			
			if(count != k) Q.offer(Q.poll());
			else {
				// k���� ī��Ʈ �� ���
				sb.append(Q.poll());
				
				// ������ 0�� ��� �������� ">' ���
				if(Q.size() == 0) {
					sb.append(">");
				} else sb.append(", ");
				
				// �ٽ� ó������ ī��Ʈ
				count = 0;
			}
		}
		System.out.print(sb);
	}

}
