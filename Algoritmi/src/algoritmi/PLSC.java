package algoritmi;

import static java.lang.Integer.max;

public class PLSC {
    int[][] DP;
    
    public PLSC(int n, int m, char[] s, char[] t) {
        DP = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            DP[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            DP[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s[i] == t[j]) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                }
                else if (s[i] != t[j]) {
                    DP[i][j] = max(DP[i - 1][j], DP[i][j - 1]);
                }
            }
        }       
    }
    
    public static void main(String[] args) {
        int n = 6;
        int m = 6;
        char[] s = {'#', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] t = {'#', 'x', 'y', 'a', 'd', 'd', 'z'};
        PLSC plsc = new PLSC(n, m, s, t);
        System.out.println(plsc.DP[n][m]);
    }
}