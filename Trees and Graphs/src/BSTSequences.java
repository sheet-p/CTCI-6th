import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BSTSequences {
    private static Tree root;
    static LinkedList<Integer> preSequences;
    static LinkedList<Integer> postSequences;

    public static void main(String[] args) {
        root = new Tree(2);
        root.left = new Tree(1);
        root.right = new Tree(3);

        preSequences = new LinkedList<>();
        postSequences = new LinkedList<>();
        allpreSequences(root);
        allpostSequences(root);

        ArrayList<LinkedList<Integer>> allSequences = new ArrayList<>();
        allSequences.add(preSequences);
        allSequences.add(postSequences);

    }

    private static void allpreSequences(Tree root) {
        if(root == null)
            return ;
        preSequences.add(root.data);
        allpreSequences(root.left);
        allpreSequences(root.right);
    }

    private static void allpostSequences(Tree root) {
        if(root == null)
            return ;
        postSequences.add(root.data);
        allpostSequences(root.right);
        allpostSequences(root.left);
    }
}
