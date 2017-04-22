package cn.renxie;
import java.util.Stack;

/**
 * Author: ������
 * Date: 2015-04-21
 * Time: 21:36
 * Declaration: All Rights Reserved !!!
 */
public class Test05 {
    /**
     * ������
     */
    public static class ListNode {
        int val; // ����ֵ
        ListNode nxt; // ��һ�����
    }

    /**
     * �����������Ľ��ֵ
     * ʹ��ջ�ķ�ʽ����
     * @param root ����ͷ���
     */
    public static void printListInverselyUsingIteration(ListNode root) {
        Stack<ListNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.nxt;
        }
        ListNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            System.out.print(tmp.val + " ");
        }
    }

    /**
     * �����������Ľ��ֵ
     * ʹ�õݹ�ķ�ʽ����
     * @param root ����ͷ���
     */
    public static void printListInverselyUsingRecursion(ListNode root) {
        if (root != null) {
            printListInverselyUsingRecursion(root.nxt);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode();
        root.val = 1;
        root.nxt = new ListNode();
        root.nxt.val = 2;
        root.nxt.nxt = new ListNode();
        root.nxt.nxt.val = 3;
        root.nxt.nxt.nxt = new ListNode();
        root.nxt.nxt.nxt.val = 4;
        root.nxt.nxt.nxt.nxt = new ListNode();
        root.nxt.nxt.nxt.nxt.val = 5;

        System.out.print("ջ��");
        printListInverselyUsingIteration(root);
        System.out.print("\n"+"�ݹ飺");
        printListInverselyUsingRecursion(root);
    }

}
