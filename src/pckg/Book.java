package pckg;

public class Book {

	int bookID, goodreadsBookID, bestBookID, workID, booksCount, originalPublicationYear, ratingsCount,
			workRatingsCount, workTextReviewsCount, ratings1, ratings2, ratings3, ratings4, ratings5;
	double averageRating;
	long isbn13;
	String isbn, authors, originalTitle, title, languageCode, imageURL, smallImageURL;

	public Book(int bookID, int goodreadsBookID, int bestBookID, int workID, int booksCount, String isbn, long isbn13,
			String authors, int originalPublicationYear, String originalTitle, String title, String languageCode,
			double averageRating, int ratingsCount, int workRatingsCount, int workTextReviewsCount, int ratings1,
			int ratings2, int ratings3, int ratings4, int ratings5, String imageURL, String smallImageURL) {
		this.bookID = bookID;
		this.goodreadsBookID = goodreadsBookID;
		this.bestBookID = bestBookID;
		this.workID = workID;
		this.booksCount = booksCount;
		this.isbn = isbn;
		this.isbn13 = isbn13;
		this.authors = authors;
		this.originalPublicationYear = originalPublicationYear;
		this.originalTitle = originalTitle;
		this.title = title;
		this.languageCode = languageCode;
		this.averageRating = averageRating;
		this.ratingsCount = ratingsCount;
		this.workRatingsCount = workRatingsCount;
		this.workTextReviewsCount = workTextReviewsCount;
		this.ratings1 = ratings1;
		this.ratings2 = ratings2;
		this.ratings3 = ratings3;
		this.ratings4 = ratings4;
		this.ratings5 = ratings5;
		this.imageURL = imageURL;
		this.smallImageURL = smallImageURL;
	}

	// Simple constructor
	public Book(int bookID, String isbn, String authors, int initialPublicationYear, String title, String languageCode,
			double averageRating) {

		this.bookID = bookID;
		this.isbn = isbn;
		this.authors = authors;
		this.originalPublicationYear = initialPublicationYear;
		this.title = title;
		this.languageCode = languageCode;
		this.averageRating = averageRating;
	}

	public int getBookId() {
		return bookID;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthors() {
		return authors;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public String getIsbn() {
		return isbn;
	}

	@Override
	public String toString() {
		return bookID + ": " + title + " by " + authors + " (Rating: " + averageRating + ")";
	}

	public int compareTo(Object o) {
		if (o instanceof String)
			return compareTo((String) o);
		if (o instanceof Integer)
			return compareTo((Integer) o);
		return -1; // should be unreachable
	}

	public int compareTo(String compISBN) {
		if (String.valueOf(isbn13).equals(compISBN))
			return 0;
		return isbn.compareTo(compISBN);
	}

	public int compareTo(Integer compID) {
		if (bookID == compID) return 0;
		if (bookID > compID) return 1;
		return -1;
	}

}
