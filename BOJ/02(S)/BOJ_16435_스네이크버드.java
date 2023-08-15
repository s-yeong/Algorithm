import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 16435. ������ũ����
 * 1. ���� �ϳ� ������ ���� 1 ����
 * 2. ������ ���� h
 * 3. ������ũ����� �ڽ��� ���̺��� �۰ų� ���� ���̿� �ִ� ���ϵ��� ���� �� ����
 * => ������ũ������ ó�� ���̰� L�϶� ���ϵ��� �Ծ� �ø� �� �ִ� �ִ� ����
 * 
 * Ǯ��
 * 1. ������ ���� ���� ���� ���� ���� �����鼭 ���� ���� ��Ű��ȴ�.
 *
 */
public class BOJ_16435_������ũ���� {

	// ���� ����
	static int fruitCount;
	// ������ũ ���� ����
	static int birdLen;
	// ���� �迭
	static int[] fruitArr;
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		fruitCount = Integer.parseInt(st.nextToken());
		birdLen = Integer.parseInt(st.nextToken());
		fruitArr = new int[fruitCount];
		
		st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<fruitCount; idx++) {
			fruitArr[idx] = Integer.parseInt(st.nextToken());
		}
		// ����
		Arrays.sort(fruitArr);
		
		for(int idx=0; idx<fruitCount; idx++) {
			
			// 3. ������ũ����� �ڽ��� ���̺��� �۰ų� ���� ���̿� �ִ� ���ϵ��� ���� �� ����
			if(birdLen >= fruitArr[idx]) {
				// 1. ���� �ϳ� ������ ���� 1 ����
				birdLen++;
			}
		}
		System.out.println(birdLen);
	}

}
