package algoritmi;

public class Domino {
    int[] DP;
    
    public Domino(int n) {
        DP = new int[n + 1];
        DP[0] = 1;
        DP[1] = 1;
        for (int i = 2; i <= n; i++) {
            DP[i] = DP[i - 1] + DP[i - 2];
        }
    }
    
    public static void main(String[] args) {
        int n = 5;
        Domino d = new Domino(n);
        System.out.println(d.DP[n]);
    }    
}