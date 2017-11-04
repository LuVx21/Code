package cn.renxie;
/**
 * Author: 王俊超
 * Date: 2015-04-22
 * Time: 08:17
 * Declaration: All Rights Reserved !!!
 */
public class Test06 {
    /**
     * 二叉树节点类
     */
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 已知某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preorder 前序遍历结果
     * @param inorder  中序遍历结果
     * @return 树的根结点
     */
    public static BinaryTreeNode construct(int[] preorder, int[] inorder) {
        // 输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同
        if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1) {
            return null;
        }

        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 已知某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preorder 前序遍历
     * @param ps       前序遍历的开始位置
     * @param pe       前序遍历的结束位置
     * @param inorder  中序遍历
     * @param is       中序遍历的开始位置
     * @param ie       中序遍历的结束位置
     * @return 树的根结点
     */
    public static BinaryTreeNode construct(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        // 开始位置大于结束位置说明已经没有需要处理的元素了
        if (prestart > preend) {
            return null;
        }
        // 取前序遍历结果的第一个数字，就是当前的根结点
        int value = preorder[prestart];
        int index = instart;
        // 在中序遍历的结果中找根结点的位置
        while (index <= inend && inorder[index] != value) {
            index++;
        }

        // 如果在整个中序遍历结果中没有找到根节点，说明输入的参数是不合法的，抛出异常
        if (index > inend) {
            throw new RuntimeException("Invalid input");
        }

        // 创建根结点，并且为结点赋值
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = value;

        // 递归构建当前根结点的左子树，左子树的元素个数：index-instart个
        // 左子树对应的前序遍历的位置在[prestart+1, prestart+index-instart]
        // 左子树对应的中序遍历的位置在[instart, index-1]
        node.left = construct(preorder, prestart + 1, prestart + index - instart, inorder, instart, index - 1);
        // 递归构建当前根结点的右子树，右子树的元素个数：inend-index个
        // 右子树对应的前序遍历的位置在[prestart+index-instart+1, preend]
        // 右子树对应的中序遍历的位置在[index+1, inend]
        node.right = construct(preorder, prestart + index - instart + 1, preend, inorder, index + 1, inend);

        // 返回创建的根结点
        return node;
    }

    // 中序遍历二叉树
    public static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + " ");
            printTree(root.right);
        }
    }

    // 普通二叉树
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

    // 所有结点都没有右子结点
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

    // 所有结点都没有左子结点
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

    // 树中只有一个结点
    private static void test4() {
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 完全二叉树
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

    // 输入空指针
    private static void test6() {
        construct(null, null);
    }

    // 输入的两个序列不匹配
    private static void test7() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 8, 1, 6, 3, 7};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

	public static void main(String[] args) {
		System.out.print("普通二叉树:");
		test1();
		System.out.print("\n所有结点都没有右子结点:");
		test2();
		System.out.print("\n所有结点都没有左子结点:");
		test3();
		System.out.print("\n树中只有一个结点:");
		test4();
		System.out.print("\n完全二叉树:");
		test5();
		System.out.print("\n输入空指针:");
		test6();
		System.out.println("\n序列不匹配:");
		//test7();
	}
}
