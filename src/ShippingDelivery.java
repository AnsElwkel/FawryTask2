public class ShippingDelivery implements IDeliveryStrategy {
    private IShippingService shippingService = new ShippingService();

    @Override
    public void deliver(String bookTitle, int quantity, String email, String address) {
        shippingService.ship(bookTitle, quantity, address);
    }
}
