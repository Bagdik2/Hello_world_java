package hi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {

		//Создаём ссылочный список LinkedList для нашего массива целых чисел
		LinkedList<Integer> list = new LinkedList<>();
		
		//Создаём сканнер для ввода данных с клаваиатуры
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите числа массива через пробел:");
		
		//Заполняем массив переменными из сканнера, целочисленными через пробел
		while(scanner.hasNextInt()) {
			list.add(scanner.nextInt());
		}
		
		//Удаляем нечётные элементы и ноль
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i % 2 != 0) { 
                list.remove(i);
            }
        }
        list.remove(0);
        
		System.out.println("Ваши числа: " + list);
        Iterator<Integer> reverseIterator = list.descendingIterator();
        
        //Выводим перевёрнутый массив при помощи итератора
        while (reverseIterator.hasNext()) {
            System.out.print(reverseIterator.next() + " ");
        }
		scanner.close();
	}

}
