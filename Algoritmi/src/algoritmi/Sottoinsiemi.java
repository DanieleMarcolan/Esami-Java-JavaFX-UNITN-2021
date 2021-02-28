package algoritmi;

import java.util.ArrayList;

public class Sottoinsiemi {
    int[] S;
    
    public Sottoinsiemi(int n) {
        S = new int[n];
        sottoinsiemiRec(n, S, 0);
    }
    
    public void sottoinsiemiRec(int n, int[] S, int i) {
        if (i >= n) {
            for (int j = 0; j < n; j++) {
                System.out.print(S[j] + "\t");
            }
            System.out.print("\n");
        }
        else {
            ArrayList<Integer> C = new ArrayList<>();
            C.add(0);
            C.add(1);
            for(Integer c : C) {
                S[i] = c;
                sottoinsiemiRec(n, S, i + 1);
            }
        }
    }
    
    public static void main(String[] args) {
        int n = 3;
        Sottoinsiemi s = new Sottoinsiemi(n);
    }
}