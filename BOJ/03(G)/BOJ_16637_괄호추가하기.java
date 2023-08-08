import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 16637. ��ȣ �߰��ϱ�
 * 1. �������� �켱������ *, / �� ������ �ƴ� ���ʺ��� ������� ����ϱ�
 * 2. ���Ŀ� ��ȣ�� �߰��Ǹ�, ��ȣ �ȿ� ����ִ� ���� ���� ����ϱ�
 * 3. ��ȣ �ȿ� �����ڰ� �ϳ��� ��� �־�� ��
 * 4. ��ø�� ��ȣ�� ����
 * => ��ȣ�� "������ �߰�"�� ���� �� �ִ� ���� �ִ밪 ���ϱ� (��ȣ�� �߰��ϰų� ��� ��)
 *	
 * Ǯ��
 * 1. �ִ� ���ڴ� 10��, ������ 9��, �ִ� ��ȣ 5��
 * 2. ��ȣ�� �߰����� ������ -> �κ�����
 * 3. ��ȣ �ȿ��� �����ڰ� '�ϳ���' ��� �־�� �Ѵ�.
 * 4. ���ڸ� �������� 
 * 4-1. ���� ���� ���(��ȣ)�� �Ѵ��� ���� ������ ��� �ϴ���
 * 4-2. ���� �ʰ� ���� ������ ����ϴ���
 */
public class BOJ_16637_��ȣ�߰��ϱ� {

	static int n;
	static String expression;
	// ���� �迭, ���� int������ ����
	static int[] expressionArr;
	// �ִ밪
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		expression = br.readLine();	
		expressionArr = new int[n];
		for(int idx=0; idx<n; idx++) {
			// ¦�� �ε����� ���ڿ� �ش��ϹǷ� ���⼭ �ٷ� ���ڷ� ��ȯ���ش�.
			// ��Ϳ��� ��ȯ�� �� ���� ������, ���� �Է¹��� �������� �����ϱ� �����.
			if(idx%2 == 0) expressionArr[idx] = expression.charAt(idx) - '0';
			else {
				expressionArr[idx] = expression.charAt(idx);
			}
		}
		answer = Integer.MIN_VALUE;	
		recursive(0, 0);
		System.out.println(answer);
	}
	
	// ��� ���� ������ �ִ밪 ����
	static void recursive(int idx, int sum) {
		
		// �ִ밪 ����
		if(idx >= n) {
			answer = Math.max(answer, sum);
		}
		
		else {
			// ��ȣ�� ����  ���
			if(idx+2 < n) {	// ��ȣ ���� idx+2���� Ȯ���ؼ� ����ϹǷ� �ش� ������ �����ؾ���
				// ��ȣ ���
				int calSum = calculate(expressionArr[idx], expressionArr[idx+2], expressionArr[idx+1]);
				if(idx == 0) {
					recursive(idx + 4, calSum); 
				}
				else {
					// ��ȣ ��� + ���� ���� ���
					recursive(idx + 4, calculate(sum, calSum, expressionArr[idx-1]));
				}
			}
			// ��ȣ�� �Ⱦ��� ���
			if(idx == 0) recursive(idx+2 , expressionArr[idx]);
			else {
				// ���� ���� ���
				recursive(idx + 2, calculate(sum, expressionArr[idx], expressionArr[idx-1]));
			}
		}
		
	}
	
	// ��� �ϱ�
	static int calculate(int num1, int num2, int opInt) {
		
		char op = (char) opInt;
		
		if(op == '*') {
			return num1 * num2;
		}
		else if(op == '+') {
			return num1 + num2;
		}
		else if(op == '-') {
			return num1 - num2;
		}
		return 0;
	}
}

