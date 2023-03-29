import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double num1, num2, result;
        boolean clearFlag = false;

        while (true) {
            if (!clearFlag) {
                System.out.print("Введите первое число: ");
                num1 = input.nextDouble();

                System.out.print("Выберите операцию (+, -, *, /, ^, sqrt): ");
                char operation = input.next().charAt(0);

                switch (operation) {
                    case '+':
                        System.out.print("Введите второе число: ");
                        num2 = input.nextDouble();
                        result = num1 + num2;
                        break;
                    case '-':
                        System.out.print("Введите второе число: ");
                        num2 = input.nextDouble();
                        result = num1 - num2;
                        break;
                    case '*':
                        System.out.print("Введите второе число: ");
                        num2 = input.nextDouble();
                        result = num1 * num2;
                        break;
                    case '/':
                        System.out.print("Введите второе число: ");
                        num2 = input.nextDouble();
                        if (num2 == 0) {
                            System.out.println("Ошибка: деление на ноль!");
                            continue;
                        } else {
                            result = num1 / num2;
                        }
                        break;
                    case '^':
                        System.out.print("Введите степень: ");
                        int power = input.nextInt();
                        result = Math.pow(num1, power);
                        break;
                    case 's':
                        result = Math.sqrt(num1);
                        break;
                    default:
                        System.out.println("Ошибка: некорректная операция!");
                        continue;
                }

                System.out.println("Результат: " + result);
            } else {
                num1 = 0;
                num2 = 0;
                result = 0;
                clearFlag = false;
            }

            System.out.print("Введите команду (clear, exit): ");
            String command = input.next();

            switch (command) {
                case "clear":
                    num1 = 0;
                    num2 = 0;
                    result = 0;
                    clearFlag = true;
                    clearConsole();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Ошибка: некорректная команда!");
                    continue;
            }
        }
    }

    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // ignore
        }
    }
}
