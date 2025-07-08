public class EmailDelivery implements IDeliveryStrategy {
    private IMailService mailService = new MailService();
    private String filetype;

    public EmailDelivery(String filetype) {
        this.filetype = filetype;
    }

    @Override
    public void deliver(String bookTitle, int quantity, String email, String address) {
        mailService.sendEmail(bookTitle, filetype, email);
    }
}