package Tra;

public class Table {

    public synchronized void printTable(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "X " + n + "=" + i * n);
        }
    }
}
