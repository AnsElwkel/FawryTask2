/*Design Notes:
  to keep it salable and extensible -> I make the IDeliveryStrategy(to add another kind of delivery approach) and Buyable(to support the types to delivering and payment process)
* */

public class Main{
    public static void main(String[] args) {
        StoreTester test = new StoreTester();
        test.runAllTests();
    }
}