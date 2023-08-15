import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 11286. ���� ��
 * 1. �迭�� ���� x�� �ִ´� (x!=0)
 * 2. �迭���� ������ ���� ���� ���� ����ϰ�, �� ���� �迭���� �����Ѵ�.
 * 3. ������ ���� ���� ���� ���� ���� ����, ���� ���� ���� ���, �� ���� �迭���� ����
 * 
 * �Է�
 * 1. x�� 0�� �ƴϴ� => �迭�� x��� ���� �ֱ�
 * 2. x�� 0�̴� => �迭���� ���밪�� ���� ���� �� ���
 * 3. ����ִ� ��� 0 ��� 
 * 
 * => �켱���� ť�� �̿� + compare �޼��� ������ �ϱ�
 * 
 */
public class BOJ_11286_������ {

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���
		StringBuilder sb = new StringBuilder();
		
		// �ּ� �� �켱���� ť
		PriorityQueue<Integer> pQ = new PriorityQueue<>((num1, num2) -> {
			
			// ���밪
			int absNum1 = Math.abs(num1);
			int absNum2 = Math.abs(num2);
			
			// ������, ���� ��
			if(absNum1 == absNum2) {
				return Integer.compare(num1, num2);
			}
			else {
				// �ٸ��� ���밪 �������� ���� ��
				return Integer.compare(absNum1, absNum2);
			}
		});
		
		// ������ ����
		int n = Integer.parseInt(br.readLine());
		
		while(n --> 0) {
			
			int num = Integer.parseInt(br.readLine());
			
			if(num != 0) {
				pQ.offer(num);
			}
			// 0�� ��� ���
			else {
				// ��������� 0 ���
				if(pQ.isEmpty()) sb.append("0").append("\n");
				else sb.append(pQ.poll()).append("\n");
			}
		}
		System.out.print(sb);
	}
}
