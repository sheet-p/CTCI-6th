import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ValidateBST {
    static Tree root;
    static List<Integer> check = new ArrayList<>();

    public static void main(String[] args) {
        root = new Tree(1);
        root.left = new Tree(2);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right = new Tree(3);
        root.right.right = new Tree(6);
        root.right.right.right = new Tree(7);

        inOrder(root);

        //check if 'check' is sorted
        List<Integer> beforesort = new ArrayList<>(check);
        Collections.sort(check);

        System.out.println(check.equals(beforesort));
    }

    private static void inOrder(Tree root) {
        if(root == null)
            return ;

        inOrder(root.left);
        check.add(root.data);
        inOrder(root.right);
    }
}
