import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1233. ��Ģ���� ��ȿ�� �˻�
 * ��Ģ������ ���� Ʈ���� ǥ��
 * 1. ��Ģ���� : +, -, *, /
 * 2. ���� �����θ� ������ ������ ���� Ʈ��
 * => �� ���� ��ȿ���� �˻��ϱ� (���O : 1, ���X : 0)
 * 3. 0���� ������ ��� ���X
 * 
 * ���� ���� Ʈ�� (����) ������ ���� Ʈ��
 * �� ����� ������ 200���� ���� �ʰ�, ��Ʈ ���� ��ȣ�� �ݵ�� 1 
 * ����ε� ������ �Ϸ��� ���� ��尡 ���ڿ����� => �������� ��� üũ 
 */
public class SWEA_1223_��Ģ������ȿ���˻� {

	public static void main(String[] args) throws IOException {
		
		// �����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int test_case=1; test_case<=10; test_case++) {
			
			// �ʱ�ȭ
			int n = Integer.parseInt(br.readLine()); // �� ���̽��� Ʈ���� ���� ������ �� �� n
			int answer = 1;
			
			for(int nodeCount = 0; nodeCount<n; nodeCount++) {
				// �� ������ ����
				// ���ĺ�, ���� �ڽ�, ������ �ڽ��� ���� ��ȣ�� ���ʴ��
				
				st = new StringTokenizer(br.readLine());
				int number = Integer.parseInt(st.nextToken());
				
				// �Է��� �޾��� �� ���� ����� ��� �����ڰ� ���ԵǸ� �߸���
				char op = st.nextToken().charAt(0);
				
				// ���̻� �Է��� ������ ���� ���
				if(st.countTokens() == 0) {
					// �������� ��� �߸���
					if(op == '*' || op == '/' || op == '+' || op == '-') {
						answer = 0;
					}
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}
}
