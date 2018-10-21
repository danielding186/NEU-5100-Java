package assignment6;

import java.util.*;

public class Mreview implements Comparable<Mreview> {
	// instance variables
	private String title; // title of the movie
	private ArrayList<Integer> ratings; // list of ratings stored in a Store object

	public Mreview() {
		this.title = "";
		this.ratings = new ArrayList<Integer>();
	}

	public Mreview(String ttl) {
		this.title = ttl;
		this.ratings = new ArrayList<Integer>();
	}

	public Mreview(String ttl, int firstRating) {
		this.title = ttl;
		this.ratings = new ArrayList<Integer>();
		this.ratings.add(firstRating);
	}

	public String getTitle() {
		return this.title;
	}

	public void addRating(int r) {
		this.ratings.add(r);
	}

	public double aveRating() {
		if (this.ratings.size() == 0)
			return 0.;

		double total = 0;
		for (int rat : this.ratings) {
			total += rat;
		}
		return total / this.ratings.size();
	}

	public int numRatings() {
		return this.ratings.size();
	}

	public int compareTo(Mreview obj) {
		return this.title.compareTo(obj.title);
	}

	public boolean equals(Object obj) {
		try {
			return this.title.equals(((Mreview) obj).getTitle());

		} catch (ClassCastException e) {
		}
		return false;
	}
	
	public String toString() {
		return String.format("%s average %.2f out of %d ratings",
				this.title, this.aveRating(), this.numRatings());
	}
	
	public static void main(String[] args) {
		Mreview m1 = new Mreview("abc");
		Mreview m2 = new Mreview("abc");
		Mreview m3 = new Mreview("abcd");
		String abc = "abc";
		
		// test for equals & compareTo
		System.out.println(m1.equals(m2));
		System.out.println(m1.equals(m3));
		System.out.println(m1.equals(abc));
		System.out.println(m1.compareTo(m3));
		
		// add ratings to m1
		m1.addRating(5);
		m1.addRating(73);
		m1.addRating(25);
		m1.addRating(15);
		
		System.out.println(m1);
		System.out.println(m1.aveRating());
	}

}
