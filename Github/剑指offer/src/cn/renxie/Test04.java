package cn.renxie;

/**
 * Author: ������
 * Date: 2015-04-21 
 * Time: 19:09 
 * Declaration: All Rights Reserved !!!
 */
public class Test04 {
	/**
	 * ��ʵ��һ�����������ַ����е�ÿ���ո��滻��"%20"�����硰We are happy.�����������We%20are%20happy.����
	 *
	 * @param arrays
	 *            Ҫת�����ַ�����
	 * @param usedLength
	 *            �ַ��������Ѿ�ʹ�õĳ���
	 * @return ת����ʹ�õ��ַ����ȣ�-1��ʾ����ʧ��
	 */
	public static int replaceBlank(char[] arrays, int usedLength) {
		// �ж������Ƿ�Ϸ�
		if (arrays == null || arrays.length < usedLength) {
			return -1;
		}

		// ͳ���ַ������еĿհ��ַ���
		int whiteCount = 0;
		for (int i = 0; i < usedLength; i++) {
			if (arrays[i] == ' ') {
				whiteCount++;
			}
		}

		// ����ת������ַ������Ƕ���
		int targetLength = whiteCount * 2 + usedLength;
		int tmp = targetLength; // ���泤�Ƚ�����ڷ���
		if (targetLength > arrays.length) { // ���ת����ĳ��ȴ����������󳤶ȣ�ֱ�ӷ���ʧ��
			return -1;
		}

		// ���û�пհ��ַ��Ͳ��ô���
		if (whiteCount == 0) {
			return usedLength;
		}

		usedLength--; // �Ӻ���ǰ����һ����ʼ������ַ�
		targetLength--; // �������ַ����õ�λ��

		// �ַ����пհ��ַ���һֱ�������еĿհ��ַ�������
		while (usedLength >= 0 && usedLength < targetLength) {
			// ���ǵ�ǰ�ַ��ǿհ��ַ�������"%20"�滻
			if (arrays[usedLength] == ' ') {
				arrays[targetLength--] = '0';
				arrays[targetLength--] = '2';
				arrays[targetLength--] = '%';
			} else { // �����ƶ��ַ�
				arrays[targetLength--] = arrays[usedLength];
			}
			usedLength--;
		}

		return tmp;
	}

	/**
	 * @param arrays
	 *            �жϷǿճ��ȵ�����
	 * @return lengthOfNotBlank ���ݷǿղ��ֵĳ���
	 */
	public static int lengthOfNotBlankOfArray(char[] arrays) {
		// ����Ϊnull��length = 0
		if (arrays == null) {
			return 0;
		}
		int lengthOfNotBlank = arrays.length;
		for (int i = arrays.length - 1; i > -1; i--) {
			// ��Ԫ��Ϊ��
			if (arrays[i] == 0)
				lengthOfNotBlank--;
		}
		return lengthOfNotBlank;
	}

	public static void main(String[] args) {
		char[] arrays = new char[50];
		arrays[0] = ' ';
		arrays[1] = 'e';
		arrays[2] = ' ';
		arrays[3] = ' ';
		arrays[4] = 'r';
		arrays[5] = 'e';
		arrays[6] = ' ';
		arrays[7] = ' ';
		arrays[8] = 'a';
		arrays[9] = ' ';
		arrays[10] = 'p';
		arrays[11] = ' ';

		int length = replaceBlank(arrays, lengthOfNotBlankOfArray(arrays));
		System.out.println(new String(arrays, 0, length) + " length:" + length);
	}
}
