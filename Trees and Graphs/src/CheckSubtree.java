public class CheckSubtree {
    static Tree root1;
    static Tree root2;

    public static void main(String[] args) {
        /*Test Case 1
        root1 = new Tree(3);
        root1.left = new Tree(2);
        root1.left.left = new Tree(1);
        root1.left.left.left = new Tree(4);
        root1.left.left.right = new Tree(5);
        root1.left.right = new Tree(6);
        root1.right = new Tree(7); */

        //Test Case 2
        root1 = new Tree(3);
        root1.left = new Tree(2);
        root1.right= new Tree(6);
        root1.right.left = new Tree(7);
        root1.left.left = new Tree(1);
        root1.left.right = new Tree(4);

        root2 = new Tree(2);
        root2.left = new Tree(1);
        root2.right = new Tree(4);

        if(root2 == null)
            System.out.println("True"); //emoty tree is a subtree of every tree
        else {
            System.out.println(checkSubTree(root1, root2));
        }
    }

    private static boolean checkSubTree(Tree t1, Tree t2) {
        //only one tree is null and not the other
        if(t1 == null)
            return false;

        else if(t1.data == t2.data && matches(t1,t2))
            return true;

        return checkSubTree(t1.left,t2) || checkSubTree(t1.right,t2);
    }

    private static boolean matches(Tree t1, Tree t2) {
        if(t1==null && t2==null)
            return true;

        else if(t1==null || t2==null)
            return false;

        else if(t1.data != t2.data)
            return false;
        else
            return matches(t1.left,t2.left) && matches(t1.right,t2.right);
    }
}
