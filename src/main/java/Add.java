/**
 * @author kourosh
 * @since 2019-11-06
 */
public class Add {
    private static char[][] additionRule = new char[][]{
        {'b', 'c', 'd', 'b'},
        {'b', 'b', 'c', 'a'},
        {'a', 'a', 'c', 'b'},
        {'b', 'c', 'd', 'c'}};

    private static Encoding[][] additionLookup = new Encoding[16][16];

    static {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
               additionLookup[i][j] = addSlow(new Encoding(i),new Encoding(j));
            }
        }
    }

    private static Encoding addSlow(Encoding first, Encoding second) {
        Encoding answer = new Encoding();
        for (Integer i : first.indices()) {
            for (Integer j : second.indices()) {
                answer.addCharacter(additionRule[i][j]);
            }
        }
        return answer;
    }

    public static Encoding add(Encoding first, Encoding second){
        return additionLookup[first.getEncoding()][second.getEncoding()];
    }

}
