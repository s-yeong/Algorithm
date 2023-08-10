import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 5215. �ܹ��� ���̾�Ʈ - �κ�����
 * Į�θ� ������ ���� �ʰ� �ִ� ������ ���ϱ�
 * 1. �ϳ��� ��Ҹ� ���� �Ⱦ��ķ� ����
 * 2. �� �� Į�θ� �Ѿ�� ��ȯ
 */
public class SWEA_5215_�ܹ��Ŵ��̾�Ʈ_�κ����� {

	static int ingredientCount;
	
	static int calorieLimit;	// Į�θ� ����
	static int[] calorieArr;	// Į�θ� �迭
	static int[] scoreArr;	// ���� ���� ���� �迭
	static int answer;	// ����
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int testCase=1; testCase<=T; testCase++) {
			st = new StringTokenizer(br.readLine().trim());
			
			ingredientCount =  Integer.parseInt(st.nextToken());
			calorieLimit =  Integer.parseInt(st.nextToken());
			
			calorieArr = new int[ingredientCount];
			scoreArr = new int[ingredientCount];
			
			for(int idx=0; idx<ingredientCount; idx++) {
				
				st = new StringTokenizer(br.readLine().trim());
				// ���� ���� ����
				scoreArr[idx] = Integer.parseInt(st.nextToken());
				// Į�θ�
				calorieArr[idx] = Integer.parseInt(st.nextToken());
			}
			
			// �־��� ���� Į�θ� ������ �����߿��� ���� ���� ���� ������ ���� �ܹ����� ������ ���
			answer = 0;
			recur(0, 0, 0);
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);

	}
	
	static void recur(int depth, int scoreSum, int calorieSum) {
		
		// ���� Į�θ� ���� ������ ������
		if(calorieSum > calorieLimit) return;
		
		if(depth == ingredientCount) {
			// �ִ밪 ����
			answer = Math.max(answer, scoreSum);
		}
		else {
			// ��Ḧ �ֳ�
			recur(depth+1, scoreSum + scoreArr[depth], calorieSum + calorieArr[depth]);
			// ��Ḧ �ȳֳ�
			recur(depth+1, scoreSum, calorieSum);
		}
	}

}
