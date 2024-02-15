import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] products = {"Хлеб", "Яблоки", "Молоко"};
        int[] prices = {100, 200, 300};
        int[] basket = new int[3];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {// Заполняем список и выводим на экран.
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб/шт");
        }

        while (true) {
            int sumProducts = 0;
            int productNumber;
            int productCount;
            System.out.println("Выбирите товар и количество или введите 'end'");
            String inputString = scanner.nextLine();
            if (inputString.equals("end")) {
                System.out.println("Ваша корзина:");
                for (int i = 0; i < basket.length; i++) {
                    if (basket[i] != 0) {//
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

            String[] parts = inputString.split(" ");// Разбиваем пробелом введенную пользователем строку на массив

            if (parts.length != 2) { // ПРОВЕРЯЕМ СОСТОИТ ЛИ ПОЛЬЗОВАТЕЛЬСКИЙ ВВОД ИЗ ДВУХ ЧАСТЕЙ
                System.out.println("Неправильный ввод. Введите номер и количество продукта через пробел или 'end' ");
            } else {
                // ЛОВИМ ВВЕЛ ЛИ ПОЛЬЗОВАТЕЛЬ ЧИСЛА, А НЕ ТЕКСТ
                try {productNumber = Integer.parseInt(parts[0]);// Преобразум в число первую часть массива,для дальнейшего
                    //приобразования в индекс (вычтем еденицу) при заполнении в массиве basket

                    if (productNumber > basket.length || productNumber < 0 || productNumber == 0) { // ПРОВЕРЯЕМ ПОДХОДЯТ ЛИ
                        // ВВЕДЕНЫЕ ПОЛЬЗОВАТЕЛЕМ ДАННЫЕ НА РОЛЬ НОМЕРА ПРОДУКТА
                        System.out.println("Неправильнй ввод номера продукта");
                    } else {
                        productCount = Integer.parseInt(parts[1]);// Преобразуем в число вторую часть массива.
                        basket[productNumber - 1] += productCount;// Прибавим к значению в массиве вторую часть
                        // под приобразованную  в индекс (вычли 1) 1-ую часть
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Неправильный ввод. Введите числа");
                    continue;
                }

            }
        }
    }
}
