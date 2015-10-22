import java.io.Serializable;

/**
 * Messages sent bu Socket,
 * with message type and content.
 */
public class Message implements Serializable {
    static final transient String LOGIN = "LG";
    static final transient String CHAT  = "CT";

    private String type;
    private String content;

    Message() {}

    Message(String message) {
        fromString(message);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString() {
        return type + content;
    }

    public void fromString(String message) {
        setType(message.substring(0, 2));
        setContent(message.substring(2));
    }
}
