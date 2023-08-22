import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1697.���ڲ���
 * 1. �����̰� ������ ã�� ���� �ִ� �ð� ���ϱ�
 * 
 * Ǯ��
 * 1. �ִ� �Ÿ��� ���ϸ鼭, ����ġ�� �����ϱ� ������ bfs�� Ǭ��.
 * 2. �ش� ��ġ�� �� �湮�� �� �ֱ� ������ �湮üũ �迭�� �̿��Ѵ�.
 * 3. next���� end ������ Ȯ���ϱ� ������, ù ������ end �������� Ȯ���ؾ� �Ѵ�.
 */
public class BOJ_1697_���ڲ��� {

	static int[] dx = {-1, 1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		// �������� ������ ������,
		if(start == end) System.out.println(0);
		else System.out.println(bfs(start, end));
	}
	
	
	static int bfs(int start, int end) {
		
		
		Queue<Integer> Q = new ArrayDeque<>();
		// �����̰� �̵��ϴ� ������ �ִ� 100,000
		boolean[] ch = new boolean[100001];
		
		// ������ �ְ� üũ
		Q.offer(start);
		ch[start] = true;
		int time = 0;
		
		while(!Q.isEmpty()) {
			
			int size = Q.size();
			
			while(size --> 0) {
				
				int cur = Q.poll();
				int next;
				
				for(int dir=0; dir<3; dir++) {
					
					// �����̰� �����̵� �Ѵٸ�,
					if(dir == 2) next = cur*2;
					// �����̰� �ȴ´ٸ�,
					else next = cur + dx[dir];
					
					// ���� �� �湮 üũ
					if(next >= 0 && next <= 100000 && !ch[next]) {
						
						// ���������̸�,
						if(next == end) return time+1;
						
						// �湮 �� ť�� �ֱ�
						ch[next] = true;
						Q.offer(next);
					}
				}
			}
			time++;
		}
		
		return time;
	}
}
