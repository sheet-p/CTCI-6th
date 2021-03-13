public class Successor {
    static Tree root;

    public static void main(String[] args) {
        root = insert(root, 3);
        root = insert(root,2);
        root = insert(root,1);
        root = insert(root,5);
        root = insert(root,4);
        root = insert(root,7);
        root = insert(root,6);

        Tree inSucc = inOrderSuccessor(root.right);

        if(inSucc != null)
            System.out.println(inSucc.data);
        else
            System.out.println("No InOrder Successor Exists!!");
    }

    private static Tree insert(Tree root, int value) {
        if(root == null)
            return (new Tree(value));

        Tree temp = null;
        if(value <= root.data) {
            temp = insert(root.left, value);
            root.left = temp;
        }
        else {
            temp = insert(root.right, value);
            root.right = temp;
        }
        temp.parent = root;

        return root;
    }

    private static Tree inOrderSuccessor(Tree node) {
        if(node == null)
            return node.parent;

        if(node.right != null)
            return minValue(node.right);
        else {
            Tree curr = node;
            Tree par = node.parent;

            while(par!=null && par.left!=curr) {
                curr = par;
                par = curr.parent;
            }

            return par;
        }
    }

    private static Tree minValue(Tree node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
}
