public class EBook extends Book implements Buyable {
    private String filetype;
    private int size; //with mb

    public EBook(String ISBN, String title, int year, double price ,  String filetype , int size) {
        super(ISBN, title, year, price);
        this.filetype = filetype;
        this.size = size;
    }


    public String getFiletype() { return filetype; }
    public int getSize() { return size; }

    @Override
    public boolean hasStock(int quantity) {
        return true; // Digital books have unlimited availability
    }

    @Override
    public void reduceStock(int quantity) throws Exception {
        // No stock reduction needed for digital books
    }

    @Override
    public IDeliveryStrategy getDeliveryApproach() {
        return new EmailDelivery(filetype);
    }
}