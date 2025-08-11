import java.util.List;

public abstract class AbstractPhoneManager<O> {
    public abstract void addPhone(O o);

    public abstract void showAllPhones(List<O> list);

    public abstract void deletePhone(int id);

    public abstract O findPhoneByID(int id);

    public abstract List<O> findPhoneByPhoneName(String name);

}
