import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1759. ��ȣ ����� 
 * 1. ��ȣ�� ���� �ٸ� L���� ���ĺ� �ҹ��� = �ּ� �� ���� ����(a, e, i, o, u) + �ּ� �� ���� �������� ����
 * 2. ���ĺ��� ��ȣ���� �����ϴ� ������ �迭
 * 3. C���� ���ڵ��� ��� �־����� �� ���ɼ� �ִ� ��ȣ�� ��� ���ϱ�
 *
 * Ǯ��
 * 1. C���� ���ڸ� ���� L���� ���ĺ� ����� (����)
 * 2. ���� �Ѱ� + �� ���� ������ �����ϰ� �ִ��� üũ�ϰ� ī��Ʈ
 * 3. �����ϴ� ������ �迭�ؾ� �ϱ� ������, �̸� ������ �ϰ� ������ ¥�� �ȴ�.
 */
public class BOJ_1759_��ȣ����� {
	
	static int combiLen, alphabetLength;
	static char[] alphabets;
	static char[] combi;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		// ����� �� �ʱ�ȭ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		combiLen = Integer.parseInt(st.nextToken());
		alphabetLength = Integer.parseInt(st.nextToken());
		alphabets = new char[alphabetLength];
		
		st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<alphabetLength; idx++) {
			alphabets[idx] = st.nextToken().charAt(0);
		}
		combi = new char[combiLen];
		
		// ����
		Arrays.sort(alphabets);
		recur(0, 0);
		System.out.print(sb);
	}
	
	
	static void recur(int depth, int start) {
		
		// ���� �Ϸ�
		if(depth == combiLen) {
			//2. ���� �Ѱ� + �� ���� ������ �����ϰ� �ִ��� üũ�ϱ�;
			int vowelCount = 0;	// ���� ��
			for(char alphabet : combi) {
				if(alphabet == 'a' || alphabet == 'e' || alphabet == 'i' || alphabet == 'o' || alphabet == 'u') {
					vowelCount++;
				}
			}
			if(vowelCount > 0 && (combiLen-vowelCount) >= 2) {
				sb.append(String.valueOf(combi)).append("\n");
			}
			
		}
		else {
			for(int idx=start; idx<alphabetLength; idx++) {
				combi[depth] = alphabets[idx];
				recur(depth+1, idx+1);
			}
		}
		
	}
}
