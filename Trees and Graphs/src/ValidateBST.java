public class ValidateBST {
    public static void main(String[] args) {
        Tree root = new Tree(5);
        root.left = new Tree(4);
        root.right = new Tree(8);
        root.left.left = new Tree(2);
        root.left.right = new Tree(3);
        root.right.left = new Tree(6);
        root.right.right = new Tree(9);

        System.out.println(isBST(root, null, null));
    }

    private static boolean isBST(Tree root, Integer min, Integer max){
        if(root == null) {
            return true;
        }
        else if( (min!=null && root.data<=min) && (max!=null && root.data>=max) ) {
            return false;
        }
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }
}
