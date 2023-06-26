import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class JavaStreamDemo {
	int count = 0;

	@Test(priority = 1)
	public void regular() {

		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Rahul");
		arrayList.add("Keshav");
		arrayList.add("Taimur");
		arrayList.add("Sanni");
		arrayList.add("Sagar");

		for (int i = 0; i < arrayList.size(); i++) {
			String actual = arrayList.get(i);
			if (actual.startsWith("S")) {
				count++;
			}
		}
		System.out.println(count);
	}

	@Test(priority = 2)
	public void streamDemo() {

		System.out.println("***********************************************************");
		ArrayList<String> arrayList = new ArrayList<String>();

		arrayList.add("Rahul");
		arrayList.add("Keshav");
		arrayList.add("Taimur");
		arrayList.add("Sanni");
		arrayList.add("Sagar");
//		there is no life for intermediate operations if there is no terminal operation
//		terminal operation will execute only if intermediate operation(filter) returns true
//		in below line count() is terminal operation
		Long c = arrayList.stream().filter(s -> s.startsWith("S")).count();
		System.out.println(c);
		System.out.println("***********************************************************");

		// create Stream
		long d = Stream.of("Rakesh", "Ramesh", "Krunal", "Kamlesh", "Chetan").filter(s -> {
			s.startsWith("K");
			return false;// if intermediate operation returns false, then even if terminal operation is
							// written , then it will not execute terminal operation
		}).count();// prints 0 as intermediate operations returns false

		System.out.println(d);
		System.out.println("***********************************************************");

//	print all the names from arraylist
		arrayList.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
	}

	@Test(priority = 3)
	public void sitemap() {
		System.out.println("***********************************************************");
//		print the names of which starts with K and in Uppercase
		Stream.of("Rakesh", "Ramesh", "Krunal", "Kamlesh", "Chetan").filter(s -> s.startsWith("K"))
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		System.out.println("***********************************************************");

//		print the names of which starts with K and in Uppercase with limitation
		Stream.of("Rakesh", "Ramesh", "Krunal", "Kamlesh", "Chetan").filter(s -> s.startsWith("K")).limit(1)
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

	}

	@Test(priority = 4)
	public void streamCollect() {
		System.out.println("***********************************************************");
		// TO store the stream values in list
		List<String> list = Stream.of("Rakesh", "Ramesh", "Krunal", "Kamlesh", "Chetan").filter(s -> s.startsWith("K"))
				.map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(list.get(0));
		System.out.println("***********************************************************");
		
		//print unique no from this array
		List<Integer> a1=Arrays.asList(3,5,2,32,5,3,23,5,23,6);
		a1.stream().distinct().forEach(s->System.out.println(s));
		System.out.println("***********************************************************");


	}
}
