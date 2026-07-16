package hi;

import java.util.Arrays;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Инициализация массива для первого метода(printArray(int[]))
		int[] array = {1,2,3,4,5};
		//Вызов первого метода
		System.out.println("Метод 1:");
		printArray(array);
		//Инициализация переменных для второго метода(getSubArrayBetween)
		int[] inputArray = {1,3,5,6,9,11,24};
		int inputStart = 4;
		int inputEnd = 10;
		int[] inputArray1 = {1,3,1,32,9,7,7,11};
		int inputStart1 = 3;
		int inputEnd1 = 7;
		//Вызов второго метода
		System.out.println("Метод 2:");
		System.out.println(Arrays.toString(getSubArrayBetween(inputArray, inputStart, inputEnd)));
		System.out.println(Arrays.toString(getSubArrayBetween(inputArray1, inputStart1, inputEnd1)));
		//Инициализация массивов для третьего метода
		int[] inputArray3_1_1 = {1,5,2,17};
		int[] inputArray3_1_2 = {14,16,3};
		//Вызов третьего метода и перевод его в переменную для удобства использования, первая задача
		System.out.println("Метод 3.1:");
		int[] outputArrayMain3_1 = getCentralElement1(inputArray3_1_1);
		int[] outputArrayMain3_2 = getCentralElement1(inputArray3_1_2);
		printArray(outputArrayMain3_1);
		printArray(outputArrayMain3_2);
		//Топорный вариант вывода
		//System.out.println("[" + getCentralElement1(inputArray3_1_2)[0] + "]");
		//Вызов третьего метода, вторая задача
		System.out.println("Метод 3.2:");
		System.out.println(Arrays.toString(getCentralElement2(inputArray3_1_1)));
		System.out.println(Arrays.toString(getCentralElement2(inputArray3_1_2)));
		//Инициализация массивов для четвёртого метода
		int[] inputArray4_1_1 = {1,3,7,5};
		int[] inputArray4_1_2 = {8,4,2,4};
		//Вызов четвёртого метода, первая задача
		System.out.println("Метод 4.1:");
		System.out.println(Arrays.toString(mergeAndSort(inputArray4_1_1, inputArray4_1_2)));
		//System.out.println(Arrays.toString(mergeAndSort(inputArray4_1_2)));
		//Вызов четвёртого метода, вторая задача
		System.out.println("Метод 4.2:");
		System.out.println(Arrays.toString(mergeAndSortArrays(inputArray4_1_1, inputArray4_1_2)));
		//Инициализация и вызов пятого метода
		System.out.println("Метод 5:");
		int[] inputArray5 = {3,5,20,8,7,3,100};
		printOddNumbers(inputArray5);
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
			if (numbers[i] >= start && numbers[i] <= end) {
				counter ++;
			}
		}
		//Инициализируем массив размером со счётчик
		int[] returnArray = new int[counter];
		int arrayPointer = 0;
		//Заполняем выводной массив
		for(int i = 0; i < numbers.length; i++) {
			if (numbers[i] >= start && numbers[i] <= end) {
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
			returnArray[0] = array[(array.length / 2) -1];
			returnArray[1] = array[array.length / 2];
			//Чётный, возвращаем центральных 2 элемента
			return returnArray;
		}
	}
	
	public static int[] getCentralElement2(int[] array) {
		int center = array.length / 2;
		//Проверяем чётный массив или нет
		if(array.length % 2 == 1) {
			int[] returnArray = new int[1];
			returnArray = Arrays.copyOfRange(array, center, center + 1);
			//Нечётный, возвращаем центральный элемент
			return returnArray;
		} else {
			int[] returnArray = new int[2];
			returnArray = Arrays.copyOfRange(array, center -1, center + 1);
			//Чётный, возвращаем центральных 2 элемента
			return returnArray;
		}
	}
	
	public static int[] mergeAndSort(int[] first, int[] second) {
		int firstSize = first.length;
		int secondSize = second.length;
		int returnSize = firstSize + secondSize;
		int[] returnArray = new int[returnSize];
		for(int i = 0; i < first.length; i++) {
			returnArray[i] = first[i];
		}
		for(int i = firstSize; i < returnSize; i++) {
			int j = i - firstSize;
			returnArray[i] = second[j];
		}

        for (int i = 0; i < returnArray.length - 1; i++) {
            for (int j = 0; j < returnArray.length - i - 1; j++) {
                if (returnArray[j] > returnArray[j + 1]) {
                    // Меняем элементы местами
                    int temp = returnArray[j];
                    returnArray[j] = returnArray[j + 1];
                    returnArray[j + 1] = temp;
                }
            }
        }

        return returnArray;
	}
	
	public static int[] mergeAndSortArrays(int[] first, int[] second) {
		int firstSize = first.length;
		int secondSize = second.length;
		int returnSize = firstSize + secondSize;
		int[] returnArray = new int[returnSize];
		for(int i = 0; i < first.length; i++) {
			returnArray[i] = first[i];
		}
		for(int i = firstSize; i < returnSize; i++) {
			int j = i - firstSize;
			returnArray[i] = second[j];
		}
		Arrays.sort(returnArray);
		
		return returnArray;
	}
	
	public static void printOddNumbers(int[] arr) {
		int counter = 0;
		//Ищем размер выводимого массива
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 1) {
				counter ++;
			}
		}
		int[] returnArray = new int[counter];
		int arrayPointer = 0;
		//Заполняем выводной массив
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 1) {
				returnArray[arrayPointer] = arr[i];
				arrayPointer++;
			}
		}
		//Упрощённая отрисовка массива, не как в примере
		//printArray(returnArray);
		//Отрисовка массива как в примере
		for(int i = 0; i < returnArray.length; i ++) {
			System.out.print(returnArray[i]);
			if(i < returnArray.length - 1) {
				System.out.print(',');
			}
		}
	}

}
