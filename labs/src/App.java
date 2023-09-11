import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);

    // 10. Даны целые числа а1, а2,..., аn. Вывести на печать только те числа, для
    // которых аi ≥ i.
    private static void lab_1_1_1() {
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

    // Дан массив, состоящий из n натуральных чисел. Образовать новый массив,
    // элементами которого будут элементы исходного, оканчивающиеся на цифру k.
    private static void lab_1_1_2() {
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

    // Для заданной квадратной матрицы сформировать одномерный массив из ее
    // диагональных элементов.
    private static void lab_1_2_1() {
        Random random = new Random();

        System.out.print("Size of matrix: ");
        int matrix_size = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[matrix_size][matrix_size];

        for (int i = 0; i < matrix_size; i++) {
            for (int j = 0; j < matrix_size; j++) {
                matrix[i][j] = random.nextInt(10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("\n");
        }

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

    // Дан двумерный массив. Заменить первый нуль в каждом столбце на количество
    // нулей в этом столбце.
    private static void lab_1_2_2() {
        Random random = new Random();

        System.out.print("Rows: ");
        int array_rows = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Columns: ");
        int array_columns = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[array_rows][array_columns];

        for (int i = 0; i < array_rows; i++) {
            for (int j = 0; j < array_columns; j++) {
                matrix[i][j] = random.nextInt(3);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("\n");
        }

        int[] zero_elements = new int[array_columns];

        for (int i = 0; i < array_rows; i++) { // looking for zeros
            for (int j = 0; j < array_columns; j++) {
                if (matrix[i][j] == 0) {
                    zero_elements[j]++;
                }
            }
        }

        for (int j = 0; j < array_columns; j++) {
            for (int i = 0; i < array_rows; i++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = zero_elements[j];
                    break;
                }
            }
        }
        System.out.println("\n");
        for (int i = 0; i < array_rows; i++) {
            for (int j = 0; j < array_columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("\n");
        }

    }

    public static void main(String[] args) throws Exception {
        System.out.println("Choose youre desteny(lab): ");
        Integer lab_Number = scanner.nextInt();

        while (lab_Number != 0) {
            scanner.nextLine();

            switch (lab_Number) {
                case 1:
                    lab_1_1_1();
                    break;
                case 2:
                    lab_1_1_2();
                    break;
                case 3:
                    lab_1_2_1();
                    break;
                case 4:
                    lab_1_2_2();
                    break;
            }

            System.out.println("\nChoose youre desteny(lab): ");
            lab_Number = scanner.nextInt();

        }

        scanner.close();
    }

}
