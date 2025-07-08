public class ShippingService implements IShippingService {
    @Override
    public void ship(String bookTitle, int quantity, String address) {
        System.out.println("Shipping " + quantity + " copies of '" +
                bookTitle + "' to " + address);
    }
}