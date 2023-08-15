import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2839. ���� ���
 * 1. ������ ��Ȯ�ϰ� Nų�α׷� ����ؾ���
 * 2. ���� ���Դ� 3ų�α׷�, 5ų�α׷� 
 * 3. �ִ��� ���� ������ ��� ������
 * 4. ���� �� ������ -1 ���
 * => Nų�α׷� ��޽� ���� �� ���� �������� �Ǵ��� ���ϱ�
 * 
 * Ǯ��
 * 1. N �ִ� 5000
 * 2. 5ų�� �׷� -> 3ų�� �׷�
 * 3. 5*x + 3*y��� ���� ��, x���� ����ؼ� N�� �Ǵ� �� ���ϱ�
 */
public class BOJ_2839_������� {
	
	// 5000/5 = 1000
	static final int fiveCountMax = 1000;
	// 5000/3 = 1666.x
	static final int threeCountMax = 1666;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		for(int threeCount=0; threeCount<=threeCountMax; threeCount++) {
			for(int fiveCount=0; fiveCount<=fiveCountMax; fiveCount++) {
				
				// 5*x + 3*y = N�� ���� ���� ��,
				if(fiveCount * 5 + threeCount * 3 == N) {
					System.out.println(fiveCount + threeCount);
					// �ٷ� ����
					System.exit(0);
				}
			}
		}
        
		// N ���Ը� ���� �� ���� ��� -1 ���  
		System.out.println(-1);
	}
}
