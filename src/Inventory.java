import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private HashMap<String , Book> books;

    public Inventory() {
        books = new HashMap<>();
    }

    void addBook(Book book) {
        books.put(book.getISBN(), book);
    }

    public ArrayList<Book> removeOutdatedBooks(int  lastYear) {
        var outdatedBooks = new ArrayList<Book>();
        for(Book book : books.values())
            if(book.isOutdated(lastYear))
                outdatedBooks.add(book);

        for(Book book : outdatedBooks)
            books.remove(book.getISBN());

        return  outdatedBooks;
    }

    public Book removeBook(String isbn) {
        Book book = books.remove(isbn);
        if (book != null) {
            System.out.println("Removed " + book.getTitle() + " from inventory");
        }
        return book;
    }

    public Book getBook(String ISBN) {
        if(!books.containsKey(ISBN))
             return null;
        return books.get(ISBN);
    }

    public void listBooks() {
        System.out.println("Current inventory:");
        for (Book book : books.values())
            System.out.println(book);
    }
}
