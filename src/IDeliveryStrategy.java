public interface IDeliveryStrategy {
    void deliver(String bookTitle, int quantity, String email, String address);
}