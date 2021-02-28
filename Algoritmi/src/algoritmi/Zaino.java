package algoritmi;

import static java.lang.Integer.max;
import java.util.Random;

public class Zaino {
    int[][] DP;
    
    public Zaino(int[] peso, int[] schei, int n, int C) {
        DP = new int[n + 1][C + 1];
        for (int i = 0; i <= n; i++) {
            DP[i][0] = 0;
        }
        for (int c = 0; c <= C; c++) {
            DP[0][c] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int c = 1; c <= C; c++) {
                if (peso[i] <= c) {
                    DP[i][c] = max(DP[i - 1][c - peso[i]] + schei[i], DP[i - 1][c]);
                }
                else {
                    DP[i][c] = DP[i - 1][c];
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int n = 4;
        int C = 100;
        Random rng = new Random();
        int[] peso = new int[n + 1];
        int[] schei = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            peso[i] = rng.nextInt(100);
            System.out.print(peso[i] + "\t");
            schei[i] = rng.nextInt(10) + 1;
        }
        System.out.print("\n");
        for (int i = 1; i <= n; i++) {
            schei[i] = rng.nextInt(20) + 1;
            System.out.print(schei[i] + "\t");
        }    
        System.out.print("\n");
        Zaino z = new Zaino(peso, schei, n, C);
        System.out.println(z.DP[n][C]);
    }
}