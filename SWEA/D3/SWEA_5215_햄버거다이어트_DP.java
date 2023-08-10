import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 5215. �ܹ��� ���̾�Ʈ - DP
 * Į�θ� ������ ���� �ʰ� �ִ� ������ ���ϱ�
 * => ���� �˰���
 */
public class SWEA_5215_�ܹ��Ŵ��̾�Ʈ_DP {

	static int ingredientCount;
	static int calorieLimit;	// Į�θ� ����
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
			
			// dp �迭
			int[] dp = new int[calorieLimit + 1];
			
			for(int idx=0; idx<ingredientCount; idx++) {
				
				st = new StringTokenizer(br.readLine().trim());
				
				// ���� ���� ����
				int score = Integer.parseInt(st.nextToken());
				// Į�θ�
				int calorie = Integer.parseInt(st.nextToken());

				// dp[x] : x Į�θ��� �־����� ��, ���� �� �ִ� �ִ� ����
				for(int x=calorieLimit; x>=calorie; x--) {
					dp[x] = Math.max(dp[x], dp[x - calorie] + score);
				}
			}
			
			// �־��� ���� Į�θ� ������ �����߿��� ���� ���� ���� ������ ���� �ܹ����� ������ ��� 
			answer = dp[calorieLimit];
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb);
	}
}
