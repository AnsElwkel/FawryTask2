import java.time.LocalDate;

public abstract class Book {
    protected String ISBN , title;
    protected int year;
    protected double price;

    public Book(String ISBN, String title, int year, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public boolean isOutdated(int maxYears) {
        int currentYear = LocalDate.now().getYear();
        return (currentYear - this.year) > maxYears;
    }

    public String getISBN() { return ISBN; }
    public String getTitle() { return title; }
    public int getYear() { return year; }
    public double getPrice(){return price;}

    @Override
    public String toString() {
        return ISBN + "," + title + "," + year + "," + price;
    }
}
