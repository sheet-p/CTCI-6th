public class PathsWithSum {
    static Tree root;
    static int count = 0;

    public static void main(String[] args) {
        root = new Tree(3);
        root.left = new Tree(-3);
        root.left.right = new Tree(-1);
        root.left.left = new Tree(7);
        root.right = new Tree(4);
        root.right.left = new Tree(-2);
        root.right.left.left = new Tree(2);

        int runningSum = 0;
        countSum(root, runningSum, 7);

        System.out.println(count);
    }

    private static void countSum(Tree root, int runningSum, int sum) {
        if(root == null)
            return ;

        runningSum += root.data;

        if(runningSum == sum)
            count ++;

        countSum(root.left, runningSum, sum);
        countSum(root.right,runningSum, sum);
    }
}
