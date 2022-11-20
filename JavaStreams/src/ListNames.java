import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListNames {
 
	//@Test
	public void Regular() {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList<>();
		names.add("Ayushi");
		names.add("Olive");
		names.add("Alex");
		names.add("Steve");
		names.add("Alvin");
		int count = 0;
		
	   for(int i = 0; i < names.size(); i++) {
		   String actual = names.get(i);
		   if(actual.startsWith("A")) {
			   count++;
		   }
	   }
	   System.out.println(count);
				

	}
	
	//@Test
	public void StreamFilter() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Ayushi");
		names.add("Olive");
		names.add("Alex");
		names.add("Steve");
		names.add("Alvin");
		
		//there is no life for intermediate operation (filter) without terminal operation (count)
		//terminal operation will execute only if intermediate operation (filter) evaluates to true or returns true
		//create a stream of strings instead of declaring entire list
		//how to use filter in stream API
		long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		                               //OR
		
		long d = Stream.of("Ayushi", "Olive", "Alex","Steve","Alvin").filter(s->
		s.startsWith("A")).count();
		System.out.println(d);
		
		//print all the names in ArrayList whose length is > 4
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		//print only the first name in ArrayList whose length is > 4
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}


	//@Test
	public void StreamMap() {
		//print names which have last letter with "e" to Uppercase
		Stream.of("Ayushi", "Olive", "Alex","Steve","Alvin").filter(s->s.endsWith("e")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//print names with first letter as "a" sorted and in uppercase
		List<String> names1 = Arrays.asList("Ayushi","Olive","Alex","Steve","Alvin");
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//merging two different lists
		ArrayList<String> names = new ArrayList<>();
		names.add("Adam");
		names.add("Elon");
		names.add("Max");
		
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		newStream.sorted().forEach(s->System.out.println(s));
		
		//finding an element in the names1 list stream
		boolean flag = names1.stream().anyMatch(s->s.equalsIgnoreCase("alex"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}

	@Test
	public void streamCollect() {
		//collectors are used to collect elements as list/set etc, used in real time when data modification is required by converting elements
		//into a list
		List<String> ls = Stream.of("Ayushi", "Olive", "Alex","Steve","Alvin").filter(s->s.endsWith("e")).map(s->s.toUpperCase())
				          .collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		//print unique number from the below array, sort the array and return 3rd element
		List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
		
	}
}

