package _91_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/20 15:59
 */
public class _94_二叉树的中序遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode TreeNode1 = new TreeNode(2);
        TreeNode TreeNode2 = new TreeNode(3);
        root.right=TreeNode1;
        TreeNode1.left=TreeNode2;

    }
    List<Integer> result = new ArrayList<>();
    boolean isRoot=true;
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        //判断第一次根节点是否是空的
        if (isRoot) {
            isRoot=false;
            if(root==null){
                return result;
            }
        }
        //左子树
        if (root.left!=null){
            inorderTraversal(root.left);
        }
        //根节点
        result.add(root.val);
        //右子树
        if (root.right!=null){
            inorderTraversal(root.right);
        }
        return result;
    }
}
