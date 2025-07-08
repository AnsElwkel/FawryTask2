public interface Buyable {
    boolean hasStock(int quantity);
    void reduceStock(int quantity) throws  Exception;
    IDeliveryStrategy getDeliveryApproach();
    double getPrice();
}