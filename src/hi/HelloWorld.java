package hi;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human human = new Human("cola","marriage","80lvl","wash your hands");
		//Метод доступен только внутри класса - возможно вызвать другим методом но только изнутри Human
		//System.out.println(human.getSecret());
		//Метод доступен вообще везде
		System.out.println(human.getNews());
		//Защищённый метод, только в пакете и его наследниках
		System.out.println(human.getExperience());
		//Метод доступен только внутри пакета
		System.out.println(human.getGossip());
	}

}
