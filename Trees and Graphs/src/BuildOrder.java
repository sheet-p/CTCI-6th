import java.util.*;

public class BuildOrder {
    public static void main(String[] args) {
        char projects[] = {'a','b','c','d','e','f'}, dependencies[][] = {{'a','d'}, {'f','b'}, {'b','d'}, {'f','a'}, {'d','c'}};
        int[] inDegree = new int[projects.length];
        Arrays.fill(inDegree,0);

        //loop through dependency and fill inDegree array
        for(char[] dep : dependencies) {
            char src = dep[0];
            char dest = dep[1];

            inDegree[dest - 'a'] += 1;
        }

        Queue<Character> q = new LinkedList<>();

        //add all inDegree 0 to q
        for(char ch : projects) {
            if(inDegree[ch - 'a'] == 0)
                q.offer(ch);
        }

        System.out.println("");
        int counter = 0;
        //for storing topological order
        List<Character> toporder = new ArrayList<>();

        while(! q.isEmpty()) {
            char proj = q.poll();
            toporder.add(proj);

            for(char[] dep : dependencies) {
                if(dep[0] == proj) {
                    inDegree[dep[1] - 'a']--;

                    if(inDegree[dep[1] - 'a'] == 0)
                        q.offer(dep[1]);
                }
            }
            counter++;
        }
        if(counter != projects.length) {
            System.out.println("Error!!");
        }
        else {
            for(char ch : toporder)
                System.out.println(ch);
        }

    }
}
