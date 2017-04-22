package cn.renxie;
/**
 * Author: ������
 * Date: 2015-04-22
 * Time: 08:17
 * Declaration: All Rights Reserved !!!
 */
public class Test06 {
    /**
     * �������ڵ���
     */
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * ��֪ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
     *
     * @param preorder ǰ��������
     * @param inorder  ����������
     * @return ���ĸ����
     */
    public static BinaryTreeNode construct(int[] preorder, int[] inorder) {
        // ����ĺϷ����жϣ��������鶼����Ϊ�գ����Ҷ������ݣ��������ݵ���Ŀ��ͬ
        if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1) {
            return null;
        }

        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * ��֪ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
     *
     * @param preorder ǰ�����
     * @param ps       ǰ������Ŀ�ʼλ��
     * @param pe       ǰ������Ľ���λ��
     * @param inorder  �������
     * @param is       ��������Ŀ�ʼλ��
     * @param ie       ��������Ľ���λ��
     * @return ���ĸ����
     */
    public static BinaryTreeNode construct(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        // ��ʼλ�ô��ڽ���λ��˵���Ѿ�û����Ҫ�����Ԫ����
        if (prestart > preend) {
            return null;
        }
        // ȡǰ���������ĵ�һ�����֣����ǵ�ǰ�ĸ����
        int value = preorder[prestart];
        int index = instart;
        // ����������Ľ�����Ҹ�����λ��
        while (index <= inend && inorder[index] != value) {
            index++;
        }

        // ���������������������û���ҵ����ڵ㣬˵������Ĳ����ǲ��Ϸ��ģ��׳��쳣
        if (index > inend) {
            throw new RuntimeException("Invalid input");
        }

        // ��������㣬����Ϊ��㸳ֵ
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = value;

        // �ݹ鹹����ǰ����������������������Ԫ�ظ�����index-instart��
        // ��������Ӧ��ǰ�������λ����[prestart+1, prestart+index-instart]
        // ��������Ӧ�����������λ����[instart, index-1]
        node.left = construct(preorder, prestart + 1, prestart + index - instart, inorder, instart, index - 1);
        // �ݹ鹹����ǰ����������������������Ԫ�ظ�����inend-index��
        // ��������Ӧ��ǰ�������λ����[prestart+index-instart+1, preend]
        // ��������Ӧ�����������λ����[index+1, inend]
        node.right = construct(preorder, prestart + index - instart + 1, preend, inorder, index + 1, inend);

        // ���ش����ĸ����
        return node;
    }

    // �������������
    public static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + " ");
            printTree(root.right);
        }
    }

    // ��ͨ������
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
    private static void test1() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // ���н�㶼û�����ӽ��
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    private static void test2() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // ���н�㶼û�����ӽ��
    //            1
    //             \
    //              2
    //               \
    //                3
    //                 \
    //                  4
    //                   \
    //                    5
    private static void test3() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // ����ֻ��һ�����
    private static void test4() {
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // ��ȫ������
    //              1
    //           /     \
    //          2       3
    //         / \     / \
    //        4   5   6   7
    private static void test5() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // �����ָ��
    private static void test6() {
        construct(null, null);
    }

    // ������������в�ƥ��
    private static void test7() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 8, 1, 6, 3, 7};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

	public static void main(String[] args) {
		System.out.print("��ͨ������:");
		test1();
		System.out.print("\n���н�㶼û�����ӽ��:");
		test2();
		System.out.print("\n���н�㶼û�����ӽ��:");
		test3();
		System.out.print("\n����ֻ��һ�����:");
		test4();
		System.out.print("\n��ȫ������:");
		test5();
		System.out.print("\n�����ָ��:");
		test6();
		System.out.println("\n���в�ƥ��:");
		//test7();
	}
}
