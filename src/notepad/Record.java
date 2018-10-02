package notepad;

public abstract class Record {

    public static  int count = 0;

    private int id;

    public Record() {
        count++;
        id = count;
    }
public  abstract boolean hasSubstring(String str);

    public int getId() {
        return id;
    }
}
