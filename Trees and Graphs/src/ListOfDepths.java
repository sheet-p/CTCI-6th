import java.util.*;

public class ListOfDepths {
    static Tree root;
    static ArrayList<LinkedList<Tree>> depths = new ArrayList<>();

    public static void main(String[] args) {
        //creating tree
        root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);

        depths = BFS(root);

        printList();
    }

    private static ArrayList<LinkedList<Tree>> BFS(Tree root) {
        ArrayList<LinkedList<Tree>> result = new ArrayList<>();

        LinkedList<Tree> curr = new LinkedList<>();

        if(root != null)
            curr.add(root);

        while(curr.size() > 0) {
            result.add(curr);
            LinkedList<Tree> parents = curr;
            curr = new LinkedList<>();
            for(Tree parent : parents) {
                if(parent.left != null)
                    curr.add(parent.left);
                if(parent.right != null)
                    curr.add(parent.right);
            }
        }

        return result;
    }

    private static void printList() {
        int counter = 1;
        for(LinkedList<Tree> tree : depths) {
            System.out.print("Nodes at depth " + counter++ + ":");
            for(Tree t : tree)
                System.out.println(" " + t.data);
        }
    }
}
