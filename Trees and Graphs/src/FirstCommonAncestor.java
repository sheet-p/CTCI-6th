public class FirstCommonAncestor {
    static Tree root;

    public static void main(String[] args) {
        root = new Tree(3);
        root.left = new Tree(7);
        root.left.left = new Tree(1);
        root.left.right = new Tree(6);
        root.left.right.left = new Tree(4);
        root.left.right.right = new Tree(3);
        root.right = new Tree(2);
        root.right.left = new Tree(12);
        root.right.right = new Tree(22);

        Tree ancestor = findCommon(root, root.left.left, root.left.right.left);
        System.out.println("Common Ancestor is : " + ancestor.data);
    }

    private static Tree findCommon(Tree root, Tree p, Tree q) {
        //check if both nodes are in the tree
        if(!inTree(root, p) || !inTree(root,q))
            return null;

        return commonAncestor(root, p, q);
    }

    private static Tree commonAncestor(Tree root, Tree p, Tree q) {
        if(root==null || root==p || root==q)
            return root;

        boolean isPOnLeft = inTree(root.left, p);
        boolean isQOnLeft = inTree(root.left, q);

        //they belong to different subtrees so root will be the first common ancestor
        if(isPOnLeft != isQOnLeft)
            return root;

        return isPOnLeft ? commonAncestor(root.left, p, q) : commonAncestor(root.right, p, q);
    }

    private static boolean inTree(Tree root, Tree p) {
        if(root == null)
            return false;

        if(root == p)
            return true;

        return inTree(root.left, p) || inTree(root.right, p);
    }
}
