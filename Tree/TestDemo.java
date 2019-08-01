package Tree;

public class TestDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        String str = "AB##C##";
        BinaryTree.TreeNode root = binaryTree.createTestTree(str);
        //binaryTree.binaryTreePrevOrderNonR(root);
       // binaryTree.binaryTreeInOrderNonR(root);
        //binaryTree.binaryTreePostOrderNonR(root);
        //binaryTree.binaryTreeLevelOrder(root);
        System.out.println(binaryTree.binaryTreeComplete(root));
        /*
        System.out.println(binaryTree.getSize(root));
        System.out.println(binaryTree.getLeafSize(root));
        System.out.println(binaryTree.getKLevelSize(root,2));
        System.out.println(binaryTree.height(root));
        System.out.println(binaryTree.find(root,'C').val);*/
    }
}
