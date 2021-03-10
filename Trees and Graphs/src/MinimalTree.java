public class MinimalTree {
    static Tree root;
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        Tree root = sortedToBST(0, arr.length-1, arr);

        inOrder(root);
    }

    private static Tree sortedToBST(int start, int end, int[] arr) {
        if(start > end)
            return null;
        int mid = (start+end)/2;

        Tree node = new Tree(arr[mid]);

        node.left = sortedToBST(start, mid-1, arr);
        node.right = sortedToBST(mid+1, end, arr);

        return node;
    }

    private static void inOrder(Tree root) {
        if(root == null)
            return ;

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
}
