/**
 * @author kourosh
 * @since 2019-11-06
 */
public class Add {
    private static char[][] additionRule = new char[][] {
        {'b','c','d','b'},
        {'b','b','c','a'},
        {'a','a','c','b'},
        {'b','c','d','c'}};


    public static Encoding add(Encoding first, Encoding second) {
        if(first.isFull() && second.isFull()){
            return first;
        }
        Encoding answer = new Encoding();
        for (Integer i : first.indeces()) {
            for (Integer j : second.indeces()) {
                answer.addCharacter(additionRule[i][j]);
            }
        }
        return answer;
    }
}
