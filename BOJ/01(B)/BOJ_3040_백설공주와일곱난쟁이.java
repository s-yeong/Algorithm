import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 3040. �鼳 ���ֿ� �ϰ� ������
 * �Է� : �� ��ȩ�� �ٿ� 1���� ũ�ų� ���� 99���� �۰ų� ���� �ڿ����� �־���
 * => �ϰ� �����̸� ã�� (��ȩ ���� �� �� ���� 100�� �Ǵ� �ϰ� ���� ��)
 * 1. ��ü �� ���� ���� 9�� �߿��� 2�� �̾��� �� ��ü - 2�� ���� 100�� �Ǹ� �ϰ� ������ ã��
 * 2. 9C2
 */
public class BOJ_3040_�鼳���ֿ��ϰ������� {
	
	// ������ ���� �湮ó�� �迭
	static boolean[] ch;
	static int[] dwarfs;	// ������ �迭
	static int totalSum;	// ��ü ��
	
	// ���
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// �ʱ�ȭ �� �Է�
		sb = new StringBuilder();
		dwarfs = new int[9];
		ch = new boolean[9];
		totalSum = 0;
		for(int idx=0; idx<9; idx++) {
			dwarfs[idx] = Integer.parseInt(br.readLine());
			totalSum += dwarfs[idx];
		}
		
		recur(0,0,0);
		System.out.print(sb);
	}
	
	// 9C2 ����
	static void recur(int depth, int start, int sum) {
		
		// ���� �Ϸ��,
		if(depth == 2) {
			// 2���� ������ 7���� ���� 100�� �Ǹ�
			if(totalSum - sum == 100) {
				// �ش� �ε��� ���
				for(int idx=0; idx<9; idx++) {
					if(ch[idx]) continue;
					sb.append(dwarfs[idx]).append("\n");
				}
			}
		}
		else {
			for(int idx=start; idx<9; idx++) {
				ch[idx] = true;
				recur(depth+1, idx+1, sum + dwarfs[idx]);
				ch[idx] = false;
			}
		}
	}
}
