import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 13023. ABCDE
 * 1. A, B, C, D, E ģ�� ���谡 �´��� Ȯ��
 * 1-1. A <-> B <-> C <-> D <-> E ����
 * 
 * Ǯ��
 * 1. ���� ����Ʈ�� �׷����� ��Ÿ���� DFS�� ���� ģ�� ���谡 �Ǵ��� ã�´�.
 * 2. ģ�� ����� ����� �����̴�.
 * 3. ģ�� ����� �ᱹ ���̸� 4��ŭ �� �� �ִ��� Ȯ���ϴ� �Ŵ�.
 */
public class BOJ_13023_ABCDE {

	static int personCount, frinedCount;
	static List<List<Integer>> graph;
	static boolean[] ch;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		// �����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		personCount = Integer.parseInt(st.nextToken());
		frinedCount = Integer.parseInt(st.nextToken());
		
		// friend �� ��ŭ List ���� (���� ����Ʈ)
		graph = new ArrayList<>();
		for(int count=0; count<personCount; count++) {
			graph.add(new ArrayList<>());
		}
		
		for(int count=0; count<frinedCount; count++) {
			
			st= new StringTokenizer(br.readLine());
			int friend1 = Integer.parseInt(st.nextToken());
			int friend2 = Integer.parseInt(st.nextToken());
			
			// frend1, frend2 ����� ����
			graph.get(friend1).add(friend2);
			graph.get(friend2).add(friend1);
		}
		
		// �ʱ�ȭ
		ch = new boolean[personCount];
		answer = 0;
		
		for(int idx=0; idx<personCount; idx++) {
			// �ش� idx���� �� �� �ִ���,
			dfs(idx, 0);
			if(answer == 1) break;
		}
		
		System.out.println(answer);
	}
	
	static void dfs(int cur, int cnt) {
		
		// ģ�� ���� Ȯ�� ������ ��ȯ
		if(answer == 1) return;
		
		// �湮 üũ
		ch[cur] = true;
		
		// ģ�� ���谡 ������,
		if(cnt == 4) {
			answer = 1;
			return;
		}
		
		for(int next : graph.get(cur)) {
			if(!ch[next]) {
				dfs(next, cnt+1);
			}
		}
		
		// �湮 äũ ����
		ch[cur] = false;
	}
}
