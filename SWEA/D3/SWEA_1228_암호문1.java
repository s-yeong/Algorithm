import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1228. ��ȣ��1
 * 1. I x, y, s : �տ������� x�� ��ġ �ٷ� ������ y���� ���ڸ� �����Ѵ�. s�� ������ ���ڵ�
 * 2. ��ȣ�� �����ϰ�, ������ ����� ó�� 10���� ���ڸ� ���
 */
public class SWEA_1228_��ȣ��1 {
	
	// ��ȣ�� ����
	static int passwordLength;
	// ��ȣ�� �迭
	static List<Integer> passwordList;
	// ��ɹ� ����
	static int commandLength;
	
	// ���.
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			
			// ��ȣ�� ����
			passwordLength = Integer.parseInt(br.readLine());
			
			// ��ȣ�� �ʱ�ȭ
			StringTokenizer st = new StringTokenizer(br.readLine());
			passwordList = new LinkedList<>();
			while(passwordLength --> 0) {
				passwordList.add(Integer.parseInt(st.nextToken()));
			}
			
			// ��ɹ� ����
			commandLength = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while(commandLength --> 0) {
				
				String command = st.nextToken();
				if(command.equals("I")) {
					// 1. I x, y, s : �տ������� x�� ��ġ �ٷ� ������ y���� ���ڸ� �����Ѵ�. s�� ������ ���ڵ�
					int insertIdx = Integer.parseInt(st.nextToken());	// ���� ��ġ
					int insertCount = Integer.parseInt(st.nextToken()); // ���Լ�
					
					for(int count=0; count<insertCount; count++) {
						passwordList.add(insertIdx, Integer.parseInt(st.nextToken()));
						// �� �������� ���� ��ġ�� ������ �־�� �ϱ� ������ �÷��� ���ش�.
						insertIdx++;
					}
				}
			}
			
			// ������ ��� 10�� ���
			sb.append("#").append(tc).append(" ");
			for(int idx=0; idx<10; idx++) {
				sb.append(passwordList.get(idx)).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
