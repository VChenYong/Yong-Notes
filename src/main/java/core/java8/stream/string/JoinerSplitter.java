package core.java8.stream.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoinerSplitter {

	public static String join ( List<String> listOfString ) {
		return listOfString
				.stream()
				.collect(Collectors.joining(","));
	}
	
	public static String joinWithPrefixPostFix ( List<String> listOfString ) {
		return listOfString
				.stream()
				.collect(Collectors.joining(",","[","]"));
	}
	
	public static List<String> split ( String str ) {
		return Stream.of(str.split(","))
				.map (String::new)
				.collect(Collectors.toList());
	}
	
	public static List<Character> splitToListOfChar ( String str ) {
		return str.chars()
				.mapToObj(item -> (char) item)
				.collect(Collectors.toList());
	}
		
}
