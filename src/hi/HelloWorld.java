package hi;

import java.util.Arrays;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Инициализация массива для первого метода(printArray(int[]))
		int[] array = {1,2,3,4,5};
		//Вызов первого метода
		printArray(array);
		//Инициализация переменных для второго метода(getSubArrayBetween)
		int[] inputArray = {1,3,5,6,9,11,24};
		int inputStart = 4;
		int inputEnd = 10;
		//Вызов второго метода
		System.out.println(Arrays.toString(getSubArrayBetween(inputArray, inputStart, inputEnd)));
		//Вызов третьего метода, первая задача
		
		//Вызов третьего метода, вторая задача

	}
	
	public static void printArray(int[] numbers) {
		//Отрисовка скобки, чтобы соответсвовать примеру вывода в задании
		System.out.print("[");
		for(int i = 0; i < numbers.length; i ++) {
			if(i < numbers.length - 1) {
				System.out.print(numbers[i] + ", ");
			}else {
				//Отрисовка последнего элемента массива без пробела и запятой
				System.out.print(numbers[i]);
			}
		}
		//Отрисовка закрывающей скобки
		System.out.print("]\n");
	}
	
	public static int[] getSubArrayBetween(int[] numbers, int start, int end) {
		//Инициализируем счётчик для создания выводного массива нужного размера
		int counter = 0;
		//Ищем размер выводимого массива
		for(int i = 0; i < numbers.length; i++) {
			if (numbers[i] >= 4 && numbers[i] <= 10) {
				counter ++;
			}
		}
		//Инициализируем массив размером со счётчик
		int[] returnArray = new int[counter];
		int arrayPointer = 0;
		//Заполняем выводной массив
		for(int i = 0; i < numbers.length; i++) {
			if (numbers[i] >= 4 && numbers[i] <= 10) {
				returnArray[arrayPointer] = numbers[i];
				arrayPointer++;
			}
		}
		return returnArray;
	}
	
	public static int[] getCentralElement1(int[] array) {
		//Проверяем чётный массив или нет
		if(array.length % 2 == 1) {
			int[] returnArray = new int[1];
			returnArray[0] = array[array.length / 2];
			//Нечётный, возвращаем центральный элемент
			return returnArray;
		} else {
			int[] returnArray = new int[2];
			returnArray[0] = array[array.length / 2];
			returnArray[1] = array[(array.length / 2) -1];
			//Чётный, возвращаем центральных 2 элемента
			return returnArray;
		}
	}

}
