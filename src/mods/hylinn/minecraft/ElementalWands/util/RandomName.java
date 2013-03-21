package hylinn.minecraft.ElementalWands.util;

import java.util.Random;

public class RandomName {

	private static final Random rand = new Random();
	private static final String[] names = {
	  "Albert", "Alexander", "Arthur", "Benjamin", "Carl", "Chester", "Clarence", "Earle", "Edwin", "Elias", "Galileo", "George",
	  "Henry", "Isaac", "Jerome", "Johannes", "Jonas", "Levi", "Louis", "Martin", "Ole", "Percy", "Pierre", "Ralph", "Samuel",
	  "Thomas", "Timothy", "Walter", "Whitcomb", "Alice", "Anne", "Anna", "Barbara", "Bette", "Beulah", "Carol", "Frances", "Gertrude",
	  "Grace", "Harriet", "Josephine", "Julie", "Lillian", "Margaret", "Marjorie", "Martha", "Mary", "Patricia", "Patsy", "Ruth",
	  "Sarah", "Stephanie", "Sybilla", "Virginia"
	};
	
	public static String nextName() {
		return names[rand.nextInt(names.length)];
	}

}
