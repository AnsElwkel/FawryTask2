public class PaperBook extends Book implements Buyable{
    private int stock;
    public PaperBook(String ISBN, String title, int year, double price , int stock) {
        super(ISBN, title, year, price);
        this.stock = stock;
    }
    @Override
    public boolean hasStock(int quantity) {
        return stock >= quantity;
    }

    @Override
    public void reduceStock(int quantity) throws Exception {
        if (!hasStock(quantity)) {
            throw new Exception("Insufficient stock. Available: " +
                    stock + ", Requested: " + quantity);
        }
        stock -= quantity;
    }

    @Override
    public IDeliveryStrategy getDeliveryApproach() {
        return new ShippingDelivery();
    }

    public int getStock() { return stock; }
}
