package notepad;

public class Note extends Record {
    private String subject;
    private String text;


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note  {" +
                "id=" + getId() +
                ", Subject='" + subject + '\'' +
                ", Text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean hasSubstring(String str) {
        return subject.contains(str) || text.contains(str);
    }
}

