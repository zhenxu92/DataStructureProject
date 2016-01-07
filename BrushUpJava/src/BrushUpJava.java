import java.util.*;

/* Assignment A1: Java Warm up
 * @author Shen Jiang
 * 
 * A java program BrushUoJava with a main method accomplish tasks as required.
 * */

public class BrushUpJava {
	public static void main(String[] args) {
		// 1. prints out a message (using System.out.println) consisting of the string 
		//   "This program was developed by " and then your name.
		System.out.print("This program was developed by " + "Shen Jiang ");
		
		// 2. prints out "having UWNetID " and then your UWNetID.
		System.out.println("having UW NetID " + "shayne93");
		
		// 3. creates an instance of class Random using seed 0.
		long seed = 0;
		Random generator = new Random(seed);
		
		// 4. generates a list of 10 random numbers (each in the range 0 to 99), using that instance.
		List<Double> randomList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			randomList.add(generator.nextDouble() * 99);
		}
		
		// 5. prints out the string "The first 10 random numbers: ".
		System.out.println("The first 10 random numbers: ");
		
		// 6. prints out the list of 10 random numbers, 
		//    with each successive pair of numbers separated by a comma and a space ", ".
		for (double ele : randomList) {
			System.out.print(ele);
			System.out.print(", ");
		}
		System.out.println();
		
		// 7. sorts the numbers into nondecreasing order.
		Collections.sort(randomList);
		
		// 8. prints out the string "The (sorted) first 10 random numbers: ".
		System.out.println("The (sorted) first 10 random numbers: ");
		
		// 9. prints the numbers in their sorted order, using the same format as in step e.
		for (double ele : randomList) {
			System.out.print(ele);
			System.out.print(", ");
		}
		System.out.println();
		
		// 10. print out "The last three digits of my student number: "
		//     followed by the last three digits of your student number.
		System.out.println("The last three digits of my student number: " + "517");
		
		// 11. reseeds the random number generator 
		//     (creating a new instance of Random), using the last three digits of your student number).
		seed = 517;
		Random newGenerator = new Random(seed);

		// 12. again generates a list of 10 random numbers, but now using the new Random instance.
		List<Double> newRandomList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			newRandomList.add(newGenerator.nextDouble() * 99);
		}
		
		// 13. print out the string "Ten new random numbers: "
		System.out.println("Ten new random numbers: ");
		
		// 14. prints out the new list, unsorted, in the same format as before.
		for (double ele : newRandomList) {
			System.out.print(ele);
			System.out.print(", ");
		}
		System.out.println();
		
		// 15. sorts the new list, as before.
		Collections.sort(newRandomList);
		
		// 16. prints out the string "Now sorted: ".
		System.out.println("Now sorted: ");
		
		// 17. print the sorted new list, as before.
		for (double ele : newRandomList) {
			System.out.print(ele);
			System.out.print(", ");
		}
		System.out.println();
	}
}
