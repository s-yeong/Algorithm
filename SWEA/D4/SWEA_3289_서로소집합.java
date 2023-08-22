import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 3289. ���μ� ����
 * 1. {1} ~ {n} : n���� ����
 * 2. ������ ����� �� ���Ұ� ���� ���տ� ���ԵǾ� �ִ��� Ȯ���ϴ� ���� ����
 * => union-find ����
 *
 */
public class SWEA_3289_���μ����� {

	// �θ� �迭
	static int[] parentArr;
	static int[] rankArr;
	static int n, inputCount;
	
	public static void main(String[] args) throws IOException {
		
		// �����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			sb.append("#").append(testCase).append(" ");
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			inputCount = Integer.parseInt(st.nextToken());
			
			make();
			
			while(inputCount --> 0) {
				
				st= new StringTokenizer(br.readLine());
				
				int type = Integer.parseInt(st.nextToken());
				int element1 = Integer.parseInt(st.nextToken());
				int element2 = Integer.parseInt(st.nextToken());
				
				// 0: ������
				if(type == 0) {
					union(element1, element2);
				}
				// 1: �� ���Ұ� ���� ���տ� ���ԵǾ� �ִ���
				else {
					int e1Parent = find(element1);
					int e2Parent = find(element2);
					if(e1Parent == e2Parent) sb.append("1");
					else sb.append("0");
				}
				
			}
			
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	// ���� self-loop �����
	static void make() {
		rankArr = new int[n+1];
		parentArr = new int[n+1];
		for(int num=1; num<=n; num++) {
			parentArr[num] = num;
		}
	}
	
	// element�� ���ϴ� ������ ��ǥ��(��Ʈ ���) ��ȯ
	static int find(int element) {
		
		// ���� element�� �θ���, 
		if(element == parentArr[element]) return element;
		else return parentArr[element] = find(parentArr[element]);	// ��� ����
	}
	
	// element1 ���� ���հ� element2 ���� ���� ��ģ��
	static void union(int element1, int element2) {
		
		// �� ������ ��ǥ�� ã��
		int e1Parent = find(element1);
		int e2Parent = find(element2);
		
		// ������ ������ ����
		if(e1Parent == e2Parent) return;
		
		// ��ŷ ��
		// e1�� �θ� ��ŷ�� ������, e2 ���� ������ �� �ؿ� ��ġ
		if(rankArr[e1Parent] > rankArr[e2Parent]) {
			parentArr[e2Parent] = e1Parent;
		}
		else parentArr[e1Parent] = e2Parent;
		
		// ��ũ�� ���� ���, e2�� ��ũ �ϳ� ������ e1�� ���� �ϱ�
		if(rankArr[e1Parent] == rankArr[e2Parent]) {
			rankArr[e2Parent]++;
		}
	}

}
