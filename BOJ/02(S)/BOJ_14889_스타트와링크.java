import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 14889. ��ŸƮ�� ��ũ
 * 1. N/2�� �̷���� ��ŸƮ���� ��ũ��
 * 2. Sij�� i�� ����� j�� ����� ���� ���� ������ ��, ���� �������� �ɷ�ġ�̴�. 
 * 3. ���� �ɷ�ġ�� ���� ���� ��� ���� �ɷ�ġ Sij�� ��
 * 4. Sij�� Sji�� �ٸ� ���� ������, i�� ����� j�� ����� ���� ���� ������ ��, ���� �������� �ɷ�ġ�� Sij�� Sji�̴�.
 * 5. ��� ���� ���ؾ� �Ѵ�. 
 * => ��ŸƮ ���� �ɷ�ġ�� ��ũ ���� �ɷ�ġ�� �ּ�ȭ 
 * 
 * ���� Ǯ��
 * 1. N���߿� ���� �����ϴ� ����� ��
 * 2. N�� 20�̹Ƿ�, 20C10�� ��츦 ���ؼ� �� ������ �ּҰ� �Ǵ� ���� ���ϱ�
 * 3. ������ �ε����� �湮 üũ�Ͽ� �� ���� �����Ͽ� ���� ���
 */
public class BOJ_14889_��ŸƮ�͸�ũ {
	
	static int n;
	// �� �ɷ�ġ �迭
	static int[][] teamStatArr;
	// �������� �� üũ�ϱ� ���� �迭
	static boolean[] ch; 
	
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		// �Է� �� �ʱ�ȭ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		teamStatArr = new int[n][n];
		ch = new boolean[n];
		
		for(int row=0; row<n; row++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int col=0; col<n; col++) {
				teamStatArr[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = Integer.MAX_VALUE;
		recur(0,0);
		System.out.println(answer);
	}
	
	// ���� ���
	static void recur(int depth, int start) {
		
		// �������� ��ŭ ������ ��������,
		if(depth == n/2) {
			
			// ���� ���ϱ�
			int diff = calculateDiff();
			
			// ���� ���� ���� �ּҰ� ����
			answer = Math.min(answer, diff);
		}
		else {
			for(int idx=start; idx<n; idx++) {
				ch[idx] = true; // �ش� �ε��� �湮 üũ
				recur(depth+1, idx+1);	
				ch[idx] = false;
			}
		}
		
		
	}
	
	static int calculateDiff() {
		
		// �湮�� ���� ��ŸƮ ��, �湮���� ���� ��ũ ������ ������
		int startSum = 0;
		int linkSum = 0;
		
		for(int row=0; row<n; row++) {
			for(int col=0; col<n; col++) {
				
				if(ch[row] && ch[col]) {
					startSum += teamStatArr[row][col];
				}
				
				if(!ch[row] && !ch[col]) {
					linkSum += teamStatArr[row][col];
				}
			}
		}
		
		return Math.abs(startSum - linkSum);
	}
	
}
