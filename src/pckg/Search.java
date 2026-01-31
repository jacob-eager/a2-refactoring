package pckg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Search {

	public static void time(List<Book> list) {
		
		Random rand = new Random();
		
		System.out.println("List size: " + list.size());
		
		ArrayList<Book> arrayList = new ArrayList<Book>(list);
		
		long startTime;
		long endTime;
		long totalTime;
		
		Sort.byISBN(arrayList);
		startTime = System.currentTimeMillis();
		binarySearch(arrayList, "345418263");
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Time for byISBN() Array List Binary Search: " + totalTime + "ms");
		
		Sort.byID(arrayList);
		startTime = System.currentTimeMillis();
		binarySearch(arrayList, rand.nextInt(1,999));
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Time for byID() Array List Binary Search: " + totalTime + "ms");
		
	}
	
	/* General List<Book> search (returns top matches) */
	
	public static List<Book> top10ByISBN(List<Book> list, String s) {
		
		List<Book> sortedList = new ArrayList<Book>();
		
		for (Book b : list) {
			if (b.isbn.contains(s) || String.valueOf(b.isbn13).contains(s)) {
				sortedList.add(b);
			}
		}
		
		return sortedList;
	}
	
	public static List<Book> top10ByID(List<Book> list, int s) {
		
		List<Book> sortedList = new ArrayList<Book>();
		
		for (Book b : list) {
			if (b.bookID == s) {
				sortedList.add(b);
			}
		}
		
		return sortedList;
	}
	
	
	/* ArrayList - Binary Search (finds exact match, input must be sorted) */
	
	
	public static Book binarySearch(ArrayList<Book> list, Object o) {
		
		int min = 0;
		int max = list.size() - 1; 
		int mid = min + (max - min) / 2;
		Book currBook;
		
		while (min <= max) {
			
			currBook = list.get(mid);
			
			if (currBook.compareTo(o) == 0) {
				return currBook;
			}
			if (currBook.compareTo(o) > 0) {
				max = mid - 1;
			}
			else if (currBook.compareTo(o) < 0) {
				min = mid + 1;
			}
			
			mid = min + (max - min) / 2;
		}
		return null;
	}
	
	
	
}
