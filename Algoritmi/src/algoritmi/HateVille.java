package algoritmi;

import static java.lang.Integer.max;
import java.util.Random;

public class HateVille {
    int[] DP;
    
    public HateVille(int[] schei, int n) {
        DP = new int[n + 1];
        DP[0] = 0;
        DP[1] = schei[1];
        for (int i = 2; i <= n; i++) {
            DP[i] = max(DP[i - 1], DP[i - 2] + schei[i]);
        }
    }
    
    public static void main(String[] args) {
        int n = 5;
        Random rng = new Random();
        int[] schei = new int [n + 1];
        schei[0] = 0;
        for (int i = 1; i <= n; i++) {
            schei[i] = rng.nextInt(8) + 1;
            System.out.print(schei[i] + "\t");
        }
        System.out.print('\n');
        HateVille hv = new HateVille(schei, n);
        System.out.println(hv.DP[n]);
    }
}