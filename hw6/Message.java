import java.util.Optional;
import java.time.LocalDateTime;

/**
 * Represents a message object.
 *
 * @author ehuang42
 * @version 9.0.1
 */

public class Message {
    private Optional<String> contactName;
    private String to;
    private String from;
    private String body;
    private LocalDateTime date;
    private boolean isImportant;

     /**
     * Creates a message with contact name, to, from, body, sent date, and if
     * it's important or not.
     *
     * @param contactName the contact name associated with the message
     * @param to the message receiver
     * @param from the message sender
     * @param body the message body
     * @param date the date the message was sent
     * @param isImportant if the message is flagged important or not
     */

    public Message(Optional<String> contactName, String to,
        String from, String body, LocalDateTime date, boolean isImportant) {
        this.contactName = contactName;
        this.to = to;
        this.from = from;
        this.body = body;
        this.date = date;
        this.isImportant = isImportant;
    }

    /**
     * @return the message's contact name
     */

    public Optional getContactName() {
        return contactName;
    }

    /**
     * @return the message's receiver
     */

    public String getTo() {
        return to;
    }

    /**
     * @return the message's sender
     */

    public String getFrom() {
        return from;
    }

    /**
     * @return the message's body
     */
    public String getBody() {
        return body;
    }

    /**
     * @return the message's sent date
     */

    public LocalDateTime getDate() {
        return date;
    }

    /**
     * @return if the message is important or not
     */

    public boolean getIsImportant() {
        return isImportant;
    }

}
