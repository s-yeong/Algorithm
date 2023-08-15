import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 9229. �Ѻ��̿� Spot Mart
 * 1. ���̸�Ʈ���� N���� ���� ������ �ְ�, �� ���� ������ a�׷��� ���Ը� ������.
 * 2. �ִ��� ���� ���� �����鼭, �� ������ ���԰� M�׷��� �ʰ��ϸ� X
 * 3. ��� ��� ���� ��� -1 ���
 * => "�� ����"�� �����, �ִ� ������ ���
 * 
 * n���� ���� ������ 2���� ���� => ���� nC2
 * ���� �� M�׷��� �ʰ����� �ʾ��� �� �ִ밪 ����
 * �ִ� 1000C2
 */
public class SWEA_9229_�Ѻ��̿�SpotMart {

	// ���� ���� ����
	static int snackArrLength;
	// m�׷�
	static int maxWeight;
	// ����
	static int answer;
	// ���� �迭
	static int[] snackArr;
	// ���� �迭
	static int[] combi;
	
	public static void main(String[] args) throws IOException {
		
		// �����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=tc; test_case++) {
			
			// �ʱ�ȭ
			st = new StringTokenizer(br.readLine());
			snackArrLength = Integer.parseInt(st.nextToken());
			snackArr = new int[snackArrLength];
			combi = new int[2];
			maxWeight = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int idx = 0 ; idx < snackArrLength ; idx++) {
				snackArr[idx] = Integer.parseInt(st.nextToken());
			}
			
			answer = -1;
			recursion(0, 0);
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}
	
	// ����
	static void recursion(int depth, int start) {
		
		// 2���� �̾��� ��
		if(depth == 2) {
			
			int sum = combi[0] + combi[1];
			// �ִ� ���� �ʰ� ���� ������,
			if(sum <= maxWeight) answer = Math.max(answer, sum);
		}
		else {
			for(int idx=start; idx<snackArrLength; idx++) {
				combi[depth] = snackArr[idx];
				recursion(depth+1, idx+1);
			}
		}
		
	}

}
