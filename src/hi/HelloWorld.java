package hi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		LinkedList<Integer> list = new LinkedList<>();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Введите числа массива через пробел:");
		
//		String string = scanner.nextLine();
		
				
		while(scanner.hasNextInt()) {
			list.add(scanner.nextInt());
		}
		
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i % 2 != 0) { 
                list.remove(i);
            }
        }
//		Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            int current = iterator.next();
//            if (current % 2 != 0) { 
//                iterator.remove();
//            }
//        }

		System.out.println("Ваши числа: " + list);
        Iterator<Integer> reverseIterator = list.descendingIterator();
        while (reverseIterator.hasNext()) {
            System.out.print(reverseIterator.next() + " ");
        }
		scanner.close();
	}

}
