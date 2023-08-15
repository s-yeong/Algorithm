import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2536. ������
 * 1-1. ��� ��ȭ�� - ����,���� ���� 100
 * 1-2. ������ ������ - ����, ���� ���� 10
 * 1-3. �������� ���� ��ȭ���� ���� ����
 * 2. �����̰� ��ȭ�� ������ ������ ���� ����
 * => �����̰� ���� ���� ������ ���̸� ���ϱ�
 *	
 * ���� Ǯ��
 * 1. ���� �� ������ �Ÿ� + �Ʒ��� �� ������ �Ÿ� => ���� �Ʒ� �������� �־����ٰ� ����
 * 2. �ߺ��Ǵ� �簢���� ����? => ����ϱ� ����
 * 3. ���� �Ʒ� ���������� ������ ũ�� ��ŭ 1�� �����Ѵ�. => �ߺ��Ǵ� �κ� ��� �ʿ�X
 * 4. ��ȭ������ 1�� ����� ��� ���ϸ� �װ� ���� ������ ����
 */
public class BOJ_2536_������ {

	// ������ ��
	static int confettiCount;
	static int[][] paper;
	static final int confettiSize = 10;
	static final int paperSize = 100;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		confettiCount = Integer.parseInt(br.readLine());
		paper = new int[paperSize][paperSize];
		
		for(int count = 0; count<confettiCount; count++) {
			st = new StringTokenizer(br.readLine());
			
			// �������� ���� ���� ��ȭ���� ���� �� ������ �Ÿ�
			int leftDiff = Integer.parseInt(st.nextToken());
					
			// �������� �Ʒ��� ���� ��ȭ���� �Ʒ��� �� ������ �Ÿ�
			int downDiff = Integer.parseInt(st.nextToken());
		
			for(int row=downDiff; row<downDiff+confettiSize; row++) {
				for(int col=leftDiff; col<leftDiff+confettiSize; col++) {
					paper[row][col] = 1;
				}
			}
		}
		
		// ������ ĥ�� �κ� ���ϱ�
		int answer = 0;
		for(int row=0; row<paperSize; row++) {
			for(int col=0; col<paperSize; col++) {
				if(paper[row][col] == 1) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

}
