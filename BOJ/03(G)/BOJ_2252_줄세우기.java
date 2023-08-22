

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2252. �� �����
 * 1. �� �л��� Ű�� �񱳰���� ���� �� �����
 * 
 * Ǯ��
 * 1. ���� ������ 0�� ���(������)�� ť�� ��� �ִ´�.
 * 2. ť���� ���� ������ 0�� ��带 ������ ��� �� �ڽŰ� ������ ����� ������ �����Ѵ�.
 * 3. ���� ���� �� ���� ������ 0�� �� ��带 ť�� �ִ´�. 
 */
public class BOJ_2252_�ټ���� {
	
	static StringBuilder sb;
	static int studentCount;
	static List<List<Integer>> graph;
	// ���� ����
	static int[] degree;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		studentCount = Integer.parseInt(st.nextToken());
		int inputCount = Integer.parseInt(st.nextToken());
		
		// ����� ���� ��ŭ List ����
		graph = new ArrayList<>();
		for(int num=0; num<=studentCount; num++) {
			graph.add(new ArrayList<>());
		}
		degree = new int[studentCount+1];
		
		while(inputCount --> 0) {
			
			st = new StringTokenizer(br.readLine());
			
			// �л� A�� �л� B�� �տ� ���� �Ѵ�.
			int studentA = Integer.parseInt(st.nextToken());
			int studentB = Integer.parseInt(st.nextToken());
			
			// ���� ���� ����
			degree[studentB]++;
			// A�� B ����
			graph.get(studentA).add(studentB);
		}
		
		solution();
		System.out.print(sb);
	}
	
	static void solution() {
		
		Queue<Integer> Q = new ArrayDeque<>();
		
		// 1. �������� 0�� ��带 ť�� ��� �ֱ�
		for(int num=1; num<=studentCount; num++) {
			if(degree[num] == 0) {
				Q.offer(num);
			}
		}
		
		while(!Q.isEmpty()) {
			
			int cur = Q.poll();
			sb.append(cur).append(" ");
			
			// �ڽŰ� ������ ����� ������ ����
			for(int next : graph.get(cur)) {
				
				degree[next]--;
				
				// �������� 0�� �Ǹ� �ֱ�
				if(degree[next] == 0) Q.offer(next);
			}
		}
	}

}
