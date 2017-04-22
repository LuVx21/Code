package cn.renxie;
import java.util.Stack;

/**
 * Author: ������
 * Date: 2015-04-22
 * Time: 09:11
 * Declaration: All Rights Reserved !!!
 */
public class Test07 {
    /**
     * ������ջģ��Ķ���
     * ��������ʵ��һ�����С����е��������£���ʵ��������������appendTail��deleteHead��
     * �ֱ�����ڶ���β����������ڶ���ͷ��ɾ�����Ĺ��ܡ�
     */
    public static class MList<T> {
        // ����ջ��ֻ���ڲ��������
        private Stack<T> stack1 = new Stack<>();
        // ����ջ��ֻ���ڵ�������
        private Stack<T> stack2 = new Stack<>();

        public MList() {
        }
        
        // ��Ӳ��������ڶ���β��������
        public void appendTail(T t) {
            stack1.add(t);
        }
        
        // ɾ���������ڶ���ͷ��ɾ�����
        public T deleteHead() {
            // ���жϵ���ջ�Ƿ�Ϊ�գ����Ϊ�վͽ�����ջ���������ݵ���ջ��
            // ���ҽ�����������ѹ�뵯��ջ��
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.pop());
                }
            }

            // �������ջ�л�û�����ݾ��׳��쳣
            if (stack2.isEmpty()) {
                throw new RuntimeException("No more element.");
            }

            // ���ص���ջ��ջ��Ԫ�أ���Ӧ�ľ��Ƕ���Ԫ�ء�
            return stack2.pop();
        }
    }

	/**
	 * @author RenXie
	 * @param args
	 */
	public static void main(String[] args) {
		MList<Integer> testList = new MList<Integer>();
		// ��ջ��ѹ������
		for (int i = 1; i < 10; i++) {
			testList.appendTail(i);
		}

		// ��ջ�ж�ȡ����
		while (true) { // ��������ȷ
			System.out.print(testList.deleteHead() + " ");
		}
	}
}
