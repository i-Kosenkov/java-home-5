import java.util.Arrays;

public class Main4 {
    public static void main(String[] args) {
        String[][] cheese = new String[8][8];
        for (int i = 0; i < 7; i = i + 2) {
            for (int j = 0; j < 7; j = j + 2) {
                cheese[i][j] = "■";
                cheese[i][j + 1] = "□";
                cheese[i + 1][j] = "□";
                cheese[i + 1][j + 1] = "■";
            }
        }
        cheese[0][0] = "♛";
        cheese[1][4] = "♛";
        cheese[2][7] = "♛";
        cheese[3][5] = "♛";
        cheese[4][2] = "♛";
        cheese[5][6] = "♛";
        cheese[6][1] = "♛";
        cheese[7][3] = "♛";
        for (String[] strings : cheese) {
            for (int j = 0; (strings != null && j < strings.length); j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println();
        }
    }
}
