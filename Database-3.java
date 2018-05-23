import java.util.Optional;
import java.util.function.Predicate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Represents a database for messages.
 *
 * @author ehuang42
 * @version 9.0.1
 */

public class Database {

    private List<Message> messages;
    private Optional name;
    private String nameInString;
    private String searchUpper;
    private String searchLower;
    private Message msg;

    /**
     * Creates a database to store messages.
     *
     * @param messages the messages list the database takes in
     */

    public Database(List<Message> messages) {
        this.messages = messages;
    }

     /**
     * @param n the index of the list
     * @return a certain messages stored at the index
     */

    public Message getMessage(int n) {
        return (Message) messages.get(n);
    }

    /**
     * @return all the messages in the database
     */

    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Filters the message with given predicate.
     * @param filter the predicate given
     * @return the list that has been filtered
     */

    public List<Message> filter(Predicate<Message> filter) {
        List<Message> myFilter = new ArrayList<Message>();
        for (int i = 0; i < messages.size(); i++) {
            msg = getMessage(i);
            if (filter.test(msg)) {
                myFilter.add(msg);
            }
        }
        return myFilter;
    }

    /**
     * Get the filtered messages given a start date and end date.
     *
     * @param start the start date of the range
     * @param end the end date of the range
     * @return the list that has been filtered with dates
     */

    public List<Message> getMessagesBetween(LocalDateTime start,
        LocalDateTime end) {
        return (filter(msg ->
            (msg.getDate().isBefore(end) && msg.getDate().isAfter(start))
                || (msg.getDate().isEqual(start))
                    || (msg.getDate().isEqual(end))));
    }

    /**
     * Sort the messages in the database by the contact names.
     *
     * @return the map that stores contact name and corresponding messages
     * sent from them
     */

    public Map<String, List<Message>> sortMessagesByContact() {
        Map<String, List<Message>> myMap = new HashMap<String, List<Message>>();
        List<Message> stored = filter(new Predicate<Message>() {
            public boolean test(Message m) {
                name = m.getContactName();
                return (name.isPresent());
            }
        });

        for (int i = 0; i < stored.size(); i++) {
            List<Message> value = new ArrayList<Message>();
            nameInString = stored.get(i).getContactName().get().toString();
            if (myMap.keySet().contains(nameInString)) {
                List<Message> middle = myMap.get(nameInString);
                middle.add(stored.get(i));
                myMap.put(nameInString, middle);
            } else {
                value.add(stored.get(i));
                myMap.put(nameInString, value);
            }
        }
        return myMap;
    }

    /**
     * Get the filtered messages given a keyword.
     *
     * @param keyword the desired keyword to search
     * @return the list that has been filtered with keyword
     */

    public List<Message> getMessagesWithKeyword(String keyword) {

        Predicate<Message> isRelated = new Predicate<Message>() {
            public boolean test(Message nowMsg) {
                searchUpper = keyword.toUpperCase();
                searchLower = keyword.toLowerCase();
                return nowMsg.getBody().contains(searchUpper)
                    || nowMsg.getBody().contains(searchLower);
            }
        };
        return filter(isRelated);
    }

    /**
     * Get the filtered messages--those have priority.
     *
     * @return the list that has been filtered with priority
     */

    public  List<Message> getMessagesWithPriority() {
        return filter(Message::getIsImportant);
    }
}



