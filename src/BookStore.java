import java.lang.reflect.Array;
import java.util.ArrayList;

public class BookStore {
    private Inventory inventory;
    private PaymentService paymentService;

    public BookStore() {
        this.inventory = new Inventory();
        this.paymentService = new PaymentService();
    }

    public void addBook(Book book) {
        inventory.addBook(book);
    }

    public ArrayList<Book> removeOutdatedBooks(int lastYear) {
        return  inventory.removeOutdatedBooks(lastYear);
    }

    public double buyBook(String ISBN , int quantity , String email, String address) throws Exception {
        Book book = inventory.getBook(ISBN);
        if(book == null)
            throw new Exception("book not found");

        if(!(book instanceof Buyable))
            throw new Exception("book is not a Buyable");

        Buyable buyableBook = (Buyable) book;

        if (!buyableBook.hasStock(quantity)) // Check stock availability
            throw new Exception("Insufficient stock");

        buyableBook.reduceStock(quantity); // Reduce stock

        IDeliveryStrategy deliveryStrategy = buyableBook.getDeliveryApproach();
        deliveryStrategy.deliver(book.getTitle(), quantity, email, address);

        double totalAmount = buyableBook.getPrice() * quantity;
        return paymentService.processPayment(totalAmount);
    }

    public Inventory getInventory() {
        return inventory;
    }
}
