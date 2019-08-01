package Tree.exercise;

/*
二叉搜索树与双向链表
 */
/*
public class  Solution {
    TreeNode pre = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertHelper(pRootOfTree);
        while(pRootOfTree!=null && pRootOfTree.left != null){
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }
    public void ConvertHelper(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return;
        }
        ConvertHelper(pRootOfTree.left);
        pRootOfTree.left = pre;
        if(pre != null){
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;
        ConvertHelper(pRootOfTree.right);
    }
}*/
/*
二叉树的最小深度
 */
/*
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return getMin(root);
    }
    public int getMin(TreeNode root) {
        if(root == null){
            return Integer.MAX_VALUE;
        }else if(root.left == null && root.right==null){
            return 1;
        }
        return Math.min(getMin(root.left),getMin(root.right))+1;
    }
}*/


/*
判断两个二叉树是否相同
 */
/*
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }else if(p==null && q!=null || p!=null && q==null ){
            return false;
        }
        return p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
*/
/*
判断一个二叉树是否镜像对称
 */
/*
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetricHelper(root.left,root.right);
    }
    public boolean isSymmetricHelper(TreeNode leftTree,TreeNode rightTree) {
        if(leftTree==null && rightTree==null){
            return true;
        }else if((leftTree==null && rightTree!=null)||(leftTree!=null && rightTree==null)){
            return false;
        }
        return leftTree.val==rightTree.val
                && isSymmetricHelper(leftTree.left,rightTree.right)
                && isSymmetricHelper(leftTree.right,rightTree.left);
    }
}
*/

/*
二叉树的最近公共祖先
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null|| root==p ||root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null && right==null){
            return null;
        }else if(left==null && right!=null){
            return right;
        }else if(left!=null && right==null){
            return left;
        }
        return root;
    }
}
