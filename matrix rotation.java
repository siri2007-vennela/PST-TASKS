import java.io.*;
import java.util.*;

class Result {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {

        int m = matrix.size();
        int n = matrix.get(0).size();

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> temp = new ArrayList<>();

            int top = layer;
            int left = layer;
            int bottom = m - 1 - layer;
            int right = n - 1 - layer;

            // Top row
            for (int j = left; j <= right; j++)
                temp.add(matrix.get(top).get(j));

            // Right column
            for (int i = top + 1; i <= bottom; i++)
                temp.add(matrix.get(i).get(right));

            // Bottom row
            for (int j = right - 1; j >= left; j--)
                temp.add(matrix.get(bottom).get(j));

            // Left column
            for (int i = bottom - 1; i > top; i--)
                temp.add(matrix.get(i).get(left));

            int len = temp.size();
            int shift = r % len;

            int k = shift;

            // Top row
            for (int j = left; j <= right; j++) {
                matrix.get(top).set(j, temp.get(k));
                k = (k + 1) % len;
            }

            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                matrix.get(i).set(right, temp.get(k));
                k = (k + 1) % len;
            }

            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                matrix.get(bottom).set(j, temp.get(k));
                k = (k + 1) % len;
            }

            // Left column
            for (int i = bottom - 1; i > top; i--) {
                matrix.get(i).set(left, temp.get(k));
                k = (k + 1) % len;
            }
        }

        // Print rotated matrix
        for (List<Integer> row : matrix) {
            for (int j = 0; j < row.size(); j++) {
                System.out.print(row.get(j));
                if (j < row.size() - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput =
            bufferedReader.readLine().trim().split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            String[] items =
                bufferedReader.readLine().trim().split(" ");

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(Integer.parseInt(items[j]));
            }

            matrix.add(row);
        }

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}