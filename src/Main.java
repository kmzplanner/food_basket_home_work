import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] products = {"Хлеб", "Яблоки", "Молоко"};
        int[] prices = {100, 200, 300};
        int[] basket = new int[3];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб/шт");
        }

        while (true) {
            int sumProducts = 0;
            int productNumber = 0;
            int productCount = 0;
            System.out.println("Выбирите товар и количество или введите 'end'");
            String inputString = scanner.nextLine();
            if (inputString.equals("end")) {
                System.out.println("Ваша корзина:");
                for (int i = 0; i < basket.length; i++) {
                    if (basket[i] != 0) {
                        System.out.println(products[i] + " " +
                                basket[i] + " шт " + prices[i] + " руб/шт " +
                                (basket[i] * prices[i]) + " руб в сумме ");
                        sumProducts += basket[i] * prices[i];
                    }
                }
                System.out.println("Итого " + sumProducts + " руб");
                System.out.println("Программа завершина");
                break;
            }

            String[] parts = inputString.split(" ");
            productNumber = Integer.parseInt(parts[0]) - 1;
            productCount = Integer.parseInt(parts[1]);
            basket[productNumber] += productCount;
        }
    }
}
