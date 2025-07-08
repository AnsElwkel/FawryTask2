public class MailService implements IMailService {
    @Override
    public void sendEmail(String bookTitle, String filetype, String email) {
        System.out.println("Sending " + filetype + " file of '" +
                bookTitle + "' to " + email);
    }
}