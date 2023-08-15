import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 4012. [���� SW �����׽�Ʈ] �丮��
 * 1. A���İ� B������ ���� ���̰� �ּҰ� �ǵ��� ��� ����ϱ�
 * 2. 14889. ��ŸƮ�� ��ũ ������ ���� ����
 *
 * ���� Ǯ��
 * 1. nCn/2 ����
 * 2. ������ �ε����� �湮 üũ�Ͽ� �� ������ �����Ͽ� ���� ���
 */
public class SWEA_4012_�丮�� {
	
	static int n;
	// �ó��� �迭
	static int[][] synergyArr;
	// �������� �� üũ�ϱ� ���� �迭
	static boolean[] ch;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int testCase=1; testCase<=T; testCase++) {
		
			// �Է� �� �ʱ�ȭ
			n = Integer.parseInt(br.readLine());
			synergyArr = new int[n][n];
			answer = Integer.MAX_VALUE;
			ch = new boolean[n];
			
			for(int row=0; row<n; row++) {
				st= new StringTokenizer(br.readLine());
				for(int col=0; col<n; col++) {
					synergyArr[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			recur(0,0);
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}
	
	static void recur(int depth, int start) {
		
		// ���� �Ϸ�
		if(depth == n/2) {
			
			// ���� ���
			int diff = calculateDiff();
			
			// �ּҰ� ����
			answer = Math.min(answer, diff);
		}
		else {
			
			for(int idx=start; idx<n; idx++) {
				ch[idx] = true;
				recur(depth+1, idx+1);
				ch[idx] = false;
			}
		}
	}
	
	static int calculateDiff() {
		
		// �湮�� ���� A����
		// �湮���� ���� B����
		int sumA = 0;
		int sumB = 0;
		
		for(int row=0; row<n/2; row++) {
			for(int col=0; col<n/2; col++) {
				
				if(ch[row] && ch[col]) {
					sumA += synergyArr[row][col];
				}
				if(!ch[row] && !ch[col]) {
					sumB += synergyArr[row][col];
				}
			}
		}
		
		return Math.abs(sumA - sumB);
	}
}
