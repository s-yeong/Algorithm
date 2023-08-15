import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 2493. ž
 * 1. N���� ���̰� ���� �ٸ� ž�� ���� ������ ���ʺ��� ������ ������ ���ʴ�� �����.
 * 2. �� ž�� ����⿡ ������ �۽ű⸦ ��ġ + ������ ��ȣ �����ϴ� ��ġ ��ġ
 * 3. ��� ž�� ������ �۽ű�(�����)�� ������ ��ȣ�� ��ǥ��� �����ϰ� "���� ������ ���� ����"���� �߻� 
 * 4. �ϳ��� ž���� �߻�� ������ ��ȣ�� ���� ���� ������ �� �ϳ��� ž������ ���� ����
 * => ������ ž���� �߻��� ������ ��ȣ�� ��� ž���� �����ϴ��� ���ϱ�
 * 
 * ����
 * 1. N �ִ� 50��, ž���� ���� �ִ� 1��
 * 2. �����ϴ� ž ������ϸ� '0' ���
 * 
 * ���� Ǯ��
 * ������ ž�� �ڽ��� ���ʿ� �ڱ� ���� ū ���ڰ� ž�� �����Ѵ�.
 * n�� 50���̱� ������ ���� for������ Ǯ ������. O(nlon), O(n)���� Ǯ ����� ��������.
 * 
 * "����"�� �ִ� �����͸� ���� ������ �����͸� �ִ� �������� �ٷ� ������ �����͸� Ȯ���ϰ�, �������� �����͸� Ȯ���ϰ�.. => LIFO 
 * => �ش��ϴ� ���� �ε��� ��ȣ�� ������ �ִ� �迭�� ����, ���ÿ��� �ڽź��� ū ���̸� ��� ã�� ������.
 * �� �� ���ÿ��� �ڽ� ���� ���̰� �� �� ũ�ٸ� �ش��ϴ� �ε����� �����Ѵ�.
 * 
 */
public class BOJ_2493_ž {

	public static void main(String[] args) throws IOException {
		// �Է�.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		
		// ������ �� �迭
		int[] answerArr = new int[n+1];
		
		// ž�� ���� : 0, ž�� �ε��� : 1 
		Stack<int[]> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for(int idx=1; idx<=n; idx++) {
			
			// ���� Ÿ�� ����
			int curTower = Integer.parseInt(st.nextToken());
			
			// ����ִ°� �ƴ϶��,
			while(!stack.isEmpty()) {
				
				int[] temp = stack.peek();
				
				// ���� Ÿ�� ���� ũ�ų� ������ Ȯ��
				if(temp[0] >= curTower) {
					// ũ�ٸ�, �ش� Ÿ���� ����
					answerArr[idx] = temp[1];
					break;
				}
				// ũ�� �ʴٸ�, �״��� Ÿ���� Ȯ�� �ؾ� �ϱ�
				else {
					stack.pop();
				}
			}
			
			// ���� ž�� ���ÿ� Ǫ���Ѵ�.
			stack.push(new int[] {curTower, idx});
		}
		
		
		// ���
		StringBuilder sb = new StringBuilder();
		for(int idx=1; idx<=n; idx++) {
			sb.append(answerArr[idx]).append(" ");
		}
		System.out.print(sb);
		
	}

}
