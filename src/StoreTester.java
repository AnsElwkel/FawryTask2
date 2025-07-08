import java.util.List;

class StoreTester {
    private BookStore bookstore;

    public StoreTester() {
        this.bookstore = new BookStore();
    }

    public void testAddingBooks() {
        System.out.println("Test adding books");

        PaperBook paperBook = new PaperBook("PaperBook-00", "Java", 2017, 50, 10);
        EBook ebook = new EBook("EBook-00", "Head of First Design Patterns", 2008, 30, "PDF" , 12);
        DemoBook demoBook = new DemoBook("DEMO-00", "Sample Book", 2023);

        bookstore.addBook(paperBook);
        bookstore.addBook(ebook);
        bookstore.addBook(demoBook);

        bookstore.getInventory().listBooks();
    }

    public void testRemovingOutdatedBooks() {
        System.out.println("Test Removing outdated books");

        PaperBook old = new PaperBook("PaperBook-01", "How to Program in C++",  1970, 40, 5);
        bookstore.addBook(old);

        List<Book> outdated = bookstore.removeOutdatedBooks(50);
        for (Book book : outdated) {
            System.out.println(book);
        }
        System.out.println("Removed " + outdated.size() + " outdated books");
    }

    public void testBuyingBooks() {
        System.out.println("Test buying books");

        try {
            double amount = bookstore.buyBook("PaperBook-00", 2, "anshesh039@gmail.com", "Dar El Salam");
            System.out.println("Transaction completed: " + amount + "EGP");

            amount = bookstore.buyBook("EBook-00", 1, "anshesh039@gmail.com", "Dar El Salam");
            System.out.println("Transaction completed: " + amount + "EGP");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            bookstore.buyBook("DEMO-001", 1, "anshesh039@gmail.com", "Dar El Salam");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void runAllTests() {
        testAddingBooks();
        System.out.println("===================================");
        testRemovingOutdatedBooks();
        System.out.println("===================================");
        testBuyingBooks();
        System.out.println("Done !!!!!");
    }
}

