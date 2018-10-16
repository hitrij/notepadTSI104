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

    @Override
    public void askQuestions() {
        System.out.println("Enter Subject for Note and Alarm or Text for Reminder:");
        subject = Main.askString();

        System.out.println("Enter Text for Note and Alarm or Date for Reminder:");
        text = Main.askString();
    }
}

