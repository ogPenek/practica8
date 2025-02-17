import java.util.Scanner;

public class practicaN8 {
    
    public static String getValidString(Scanner scanner) {
        while (true) {
            System.out.println("Введіть рядок (мінімум 2 слова, кожне слово від 3 символів):");
            String input = scanner.nextLine().trim();
            String[] words = input.split("\\s+");

            if (words.length < 2) {
                System.out.println("Помилка! Має бути мінімум 2 слова.");
                continue;
            }

            boolean valid = true;
            for (String word : words) {
                if (word.length() < 3) {
                    System.out.println("Помилка! Кожне слово має містити мінімум 3 символи.");
                    valid = false;
                    break;
                }
            }

            if (valid) {
                return input;
            }
        }
    }

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseEachWord(String str) {
        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(new StringBuilder(word).reverse()).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userString = getValidString(scanner);

        while (true) {
            System.out.println("Оберіть опцію:");
            System.out.println("1 - Перевернути весь рядок");
            System.out.println("2 - Перевернути тільки слова");
            System.out.println("3 - Вийти");
            System.out.print("Ваш вибір: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("Перевернутий рядок: " + reverseString(userString));
                    break;
                case "2":
                    System.out.println("Перевернуті слова: " + reverseEachWord(userString));
                    break;
                case "3":
                    System.out.println("До побачення!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Невірний вибір, спробуйте ще раз.");
            }
        }
    }
}
