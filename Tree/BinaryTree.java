package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    //根据字符串创建二叉树
    private int i=0;
    TreeNode createTestTree(String s){
        TreeNode root = null;
        if(s.charAt(i) !='#'){
            root = new TreeNode(s.charAt(i));
            i++;
            root.left = createTestTree(s);
            root.right = createTestTree(s);
        }else{
            i++;
        }
        return root;
    }
    //结点个数
    int getSize(TreeNode root){
        if(root == null){
            return 0;
        }
        return getSize(root.left) + getSize(root.right)+1;
    }
    // 叶子结点个数
    int getLeafSize(TreeNode root){
        if(root == null){
            return 0;
        }else if(root.left == null && root.right==null){
            return 1;
        }
        return getSize(root.left) + getSize(root.right);
    }
    // 第 k 层结点个数
    int getKLevelSize(TreeNode root, int k){
        if(root == null){
            return 0;
        }else if(k == 1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }
    // 查找，依次在二叉树的 根、左子树、右子树 中查找 value，如果找到，返回结点，否则返回 null
    TreeNode find(TreeNode root, char value){
        if(root != null ){
            if(root.val == value){
                return root;
            }
            TreeNode left = find(root.left,value);
            if(left != null){
                return left;
            }
            return find(root.right,value);
        }
        return null;
    }

    //二叉树的高度
    int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right)) +1;
    }

/*
    //二叉树的前序遍历 递归
    void binaryTreePrevOrderNonR(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        binaryTreePrevOrderNonR(root.left);
        binaryTreePrevOrderNonR(root.right);
    }
    //二叉树的中序遍历 递归
    void binaryTreeInOrderNonR(TreeNode root){
        if(root == null){
            return;
        }
        binaryTreeInOrderNonR(root.left);
        System.out.print(root.val+" ");
        binaryTreeInOrderNonR(root.right);
    }
    //二叉树的后序遍历 递归
    void binaryTreePostOrderNonR(TreeNode root){
        if(root == null){
            return;
        }
        binaryTreePostOrderNonR(root.left);
        binaryTreePostOrderNonR(root.right);
        System.out.print(root.val+" ");
    }*/
    //二叉树的前序遍历非递归
    void binaryTreePrevOrderNonR(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = null;
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur !=null){
                stack.push(cur);
                System.out.print(cur.val+" ");
                cur = cur.left;
            }
            tmp = stack.pop();
            cur = tmp.right;
        }
    }
    //二叉树的中序遍历非递归
    void binaryTreeInOrderNonR(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = null;
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            tmp = stack.pop();
            System.out.print(tmp.val + " ");
            cur = tmp.right;
        }
    }

    // 二叉树的后序遍历非递归
    void binaryTreePostOrderNonR(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek().right;
            if(cur == null || cur == prev){
                prev = stack.pop();
                System.out.print(prev.val+" ");
                cur = null;
            }
        }
    }

    //二叉树的层序遍历
    void binaryTreeLevelOrder(TreeNode root){
        TreeNode cur = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(cur);
        while(!queue.isEmpty()){
            cur = queue.poll();
            System.out.print(cur.val+" ");
            if(queue.isEmpty()){
                System.out.println();
            }
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }
    //判断一棵树是否是完全二叉树 返回0代表是完全二叉树
    int binaryTreeComplete(TreeNode root){
        TreeNode cur = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(cur);
        while((cur = queue.poll()) != null){
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        for(int i=0; i<queue.size(); i++){
            if(queue.poll() != null){
                return 1;
            }
        }
        return 0;
    }
}
