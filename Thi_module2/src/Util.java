import java.util.List;

public interface Util<O> {
    void writeToFile(List<O> list);

    List<O> readFromFile();

    int genPhoneID();
}
