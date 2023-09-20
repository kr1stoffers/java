import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class lab1 {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    private static void RandomMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = random.nextInt(10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    // 1. Даны целые числа а1, а2,..., аn. Вывести на печать только те числа, для
    // которых аi ≥ i.
    private static void Part_1_v1() {
        System.out.println("Enter array elements (separated by a spaces): ");

        String[] input = scanner.nextLine().split(" ");
        Integer[] numbers = new Integer[input.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
            if (numbers[i] >= i) {
                System.out.print(numbers[i] + " ");
            }
        }

    }

    // 2. Дан массив, состоящий из n натуральных чисел. Образовать новый массив,
    // элементами которого будут элементы исходного, оканчивающиеся на цифру k.
    private static void Part_1_v2() {
        System.out.println("Enter array elements (separated by a spaces): ");
        String[] input = scanner.nextLine().split(" ");

        Integer[] firstArray = new Integer[input.length];
        Integer[] secondArray = new Integer[input.length];

        System.out.println("Enter k: ");
        Integer k = scanner.nextInt();
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = Integer.parseInt(input[i]);
            if (firstArray[i] % 10 == k) {
                secondArray[i] = firstArray[i];
            }
        }
        for (int i = 0; i < secondArray.length; i++) {
            if (secondArray[i] != null)
                System.out.print(secondArray[i] + " ");
        }

    }

    // 3. Для заданной квадратной матрицы сформировать одномерный массив из ее
    // диагональных элементов.
    private static void Part_2_v1() {
        System.out.print("Size of matrix: ");
        int matrix_size = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[matrix_size][matrix_size];
        RandomMatrix(matrix);

        ArrayList<Integer> arr = new ArrayList<>();

        int start_index = 0;
        int end_index = matrix_size - 1;

        for (int i = 0; i < matrix_size; i++) { // diagonals
            if (end_index == start_index) {
                arr.add(matrix[i][start_index]);
                start_index++;
                end_index--;
                continue;
            } else {
                arr.add(matrix[i][start_index]);
                start_index++;
                arr.add(matrix[i][end_index]);
                end_index--;
            }
        }
        System.out.println(arr.toString());

    }

    // 4. Дан двумерный массив. Выяснить, есть ли столбцы с одинаковой суммой
    // элементов. Если есть, вывести их номера.
    private static void Part_2_v2() {
        System.out.print("Rows: ");
        int array_rows = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Columns: ");
        int array_columns = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[array_rows][array_columns];
        RandomMatrix(matrix);

        int sum_columns[] = new int[array_columns];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum_columns[j] += matrix[i][j];
            }

        }
        System.out.println("Sum: ");
        System.out.print(Arrays.toString(sum_columns));
        System.out.println();

        int flag = 0;
        for (int i = 0; i < sum_columns.length - 1; i++) {
            if (sum_columns[i] != -1) {
                for (int j = i + 1; j < sum_columns.length; j++) {
                    if (sum_columns[i] == sum_columns[j]) {
                        System.out.print(j + " ");
                        sum_columns[j] = -1;
                        flag = -1;
                    }
                }
                if (flag == -1) {
                    System.out.print(i + " - ");
                    System.out.println(sum_columns[i]);
                    sum_columns[i] = -1;
                    flag = 0;
                }
            }
        }
    }

    public static void Lab1() {
        System.out.println("Choose your destiny(lab): ");
        Integer lab_Number = scanner.nextInt();

        while (lab_Number != 0) {
            scanner.nextLine();

            switch (lab_Number) {
                case 1:
                    Part_1_v1();
                    break;
                case 2:
                    Part_1_v2();
                    break;
                case 3:
                    Part_2_v1();
                    break;
                case 4:
                    Part_2_v2();
                    break;
            }

            System.out.println("\nChoose your destiny(lab): ");
            lab_Number = scanner.nextInt();

        }

    }

}
