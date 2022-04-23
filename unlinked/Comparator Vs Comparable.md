# Comparator Vs Comparable
[[JAVA-interviews]]
[[JavaScript-interview-questions]]
[[How to sort list of Objects in java without Stream]]

- Java provide two interfaces to sort objects using data members



## Comparable
- here we need to implements Comparable to our class
- override the method `compareTo`
```
public int compareTo(Movie m)
	{
		return this.year - m.year;
	}
```


- calling `Collections.sort` will sort the Movie Object based on year 



```java

class Movie implements Comparable<Movie>
{
	private double rating;
	private String name;
	private int year;

	// Used to sort movies by year
	public int compareTo(Movie m)
	{
		return this.year - m.year;
	}

	// Constructor
	public Movie(String nm, double rt, int yr)
	{
		this.name = nm;
		this.rating = rt;
		this.year = yr;
	}

	// Getter methods for accessing private data
	public double getRating() { return rating; }
	public String getName() { return name; }
	public int getYear()	 { return year; }
}

// Driver class
class Main
{
	public static void main(String[] args)
	{
		ArrayList<Movie> list = new ArrayList<Movie>();
		list.add(new Movie("Force Awakens", 8.3, 2015));
		list.add(new Movie("Star Wars", 8.7, 1977));
		list.add(new Movie("Empire Strikes Back", 8.8, 1980));
		list.add(new Movie("Return of the Jedi", 8.4, 1983));

		Collections.sort(list);

		System.out.println("Movies after sorting : ");
		for (Movie movie: list)
		{
			System.out.println(movie.getName() + " " +
							movie.getRating() + " " +
							movie.getYear());
		}
	}
}

```


## Comparator
- here separate class is needed to implement Comparator
- method name is `compare`
- here we compare two objects and return , -1 , 1 , 0 
- how to call 
- `	RatingCompare ratingCompare = new RatingCompare();
		`Collections.sort(list, ratingCompare);`



```java


Example




// Class to compare Movies by ratings
class RatingCompare implements Comparator<Movie>
{
	public int compare(Movie m1, Movie m2)
	{
		if (m1.getRating() < m2.getRating()) return -1;
		if (m1.getRating() > m2.getRating()) return 1;
		else return 0;
	}
}

// Class to compare Movies by name
class NameCompare implements Comparator<Movie>
{
	public int compare(Movie m1, Movie m2)
	{
		return m1.getName().compareTo(m2.getName());
	}
}


		RatingCompare ratingCompare = new RatingCompare();
		Collections.sort(list, ratingCompare);

		// Call overloaded sort method with RatingCompare
		// (Same three steps as above)
		System.out.println("\nSorted by name");
		NameCompare nameCompare = new NameCompare();
		Collections.sort(list, nameCompare);
	

		// Uses Comparable to sort by year
		System.out.println("\nSorted by year");
		Collections.sort(list);
		
	}
}

```