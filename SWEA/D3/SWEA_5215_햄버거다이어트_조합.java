import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 5215. �ܹ��� ���̾�Ʈ - ����
 * 
 * Į�θ� ������ ���� �ʰ� �ִ� ������ ���ϱ�
 * 1. ����� ��Ҹ� �������� 1�� ����, 2�� ����, 3�� ����... �ؼ� �ִ밪 ���ϱ�
 *  
 */
public class SWEA_5215_�ܹ��Ŵ��̾�Ʈ_���� {

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
			// 1������ ��� ���� ��ŭ �����ϸ鼭 �ִ밪 ����
			for(int combiCount=1; combiCount<=ingredientCount; combiCount++) {
				recur(0,0,combiCount,0,0);
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);

	}
	
	static void recur(int depth, int start, int combiCount, int scoreSum, int calorieSum) {
		
		// ���� Į�θ� ���� ������ ������
		if(calorieSum > calorieLimit) return;
		
		// ���� �Ϸ�
		if(depth == combiCount) {
			// �ִ밪 ����
			answer = Math.max(answer, scoreSum);
		}
		else {
			for(int idx=start; idx<ingredientCount; idx++) {
				recur(depth+1, idx+1, combiCount, scoreSum + scoreArr[idx], calorieSum + calorieArr[idx]);
			}
		}
	}
}
