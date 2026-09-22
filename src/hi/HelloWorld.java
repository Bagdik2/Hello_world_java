package hi;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Set;

public class HelloWorld {

	public static void main(String[] args) {
		//Создаём два сета из задачи
		Set<Integer> set1 = new TreeSet<>(Set.of(0, 1, 2));
		Set<Integer> set2 = new TreeSet<>(Set.of(1, 2, 3));
		//Выводим сеты в консоль для наглядности
		System.out.println(set1 + " " + set2);
		
		//Выводим результат в консоль
		System.out.println(symmetricDifference(set1,set2));
	}
	
	public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
		//Ищем разность 2 сета с 1-м
		Set<T> diff = new TreeSet<>(set2);
		diff.removeAll(set1);
		//Ищем разность 1 сета со 2-м
		Set<T> diff1 = new TreeSet<>(set1);
		diff1.removeAll(set2);
		//Объёдиняем, так как TreeSet - он автоматически сортируется
		diff.addAll(diff1);
		//Выводим готовый сет из метода
		return diff;
	}

}
