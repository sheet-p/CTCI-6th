public class CheckBalanced {
    static Tree root;

    public static void main(String[] args) {
        root = new Tree(1);
        root.left = new Tree(2);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right = new Tree(3);
        root.right.right = new Tree(6);
        root.right.right.right = new Tree(7);

        int check = checkHeight(root);
        if(check==-1)
            System.out.println("Not Balanced!!");
        else
            System.out.println("Balanced!!");
    }

    private static int checkHeight(Tree root) {
        if(root == null)
            return 0;
        int lheight = checkHeight(root.left);
        int rheight = checkHeight(root.right);

        if(lheight==-1 || rheight==-1)
            return -1;
        else {
            if(Math.abs(lheight-rheight) > 1)
                return -1;
            if(lheight < rheight)
                return rheight+1;
            else
                return lheight+1;
        }
    }
}
