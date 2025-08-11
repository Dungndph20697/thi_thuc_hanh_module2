import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PhoneManager extends AbstractPhoneManager<Phone> implements Util<Phone> {
    private int idPhone = 0;
    private static final String FILE_PATH_CSV = "phones.csv";

    private Scanner sc = new Scanner(System.in);

    @Override
    public void writeToFile(List<Phone> list) {
        try {
            FileWriter writer = new FileWriter(FILE_PATH_CSV);
            writer.append("Id, Phone name, Price, Quantity, Brand").append("\n");
            for (Phone phone : list) {
                writer.append(phone.toCSV()).append("\n");
            }
            writer.close();
            System.out.println("Đã xuất dữ liệu sang file CSV: " + FILE_PATH_CSV);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Phone> readFromFile() {
        List<Phone> phones = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH_CSV))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) { // Skip header
                    isFirstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                if (values.length >= 5) {

                    Phone phone = new Phone(Integer.valueOf(values[0].trim()), values[1].trim(), values[2].trim(), Integer.parseInt(values[3].trim()), values[4].trim());
                    phones.add(phone);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file CSV: " + e.getMessage());
        }
        return phones;
    }

    @Override
    public int genPhoneID() {
        idPhone++;
        List<Phone> list = readFromFile();
        for (Phone phone : list) {
            if (phone.getId() == idPhone) {
                genPhoneID();
            }
        }
        return idPhone;
    }

    @Override
    public void addPhone(Phone phone) {
        List<Phone> list = readFromFile();
        list.add(phone);
        writeToFile(list);
    }

    @Override
    public void showAllPhones(List<Phone> list) {
        for (Phone phone : list) {
            System.out.println(phone.toString());
        }
    }

    @Override
    public void deletePhone(int id) {
        List<Phone> list = readFromFile();
        for (Phone phone : list) {
            if (phone.getId() == id) {
                System.out.println("Bạn có chắc chắn muốn xoá điện thoại: " + phone.getPhoneName() + " (ID: " + id + ") không? (y/n)");
                String choie = sc.nextLine();
                if (choie.equals("y")) {
                    list.remove(phone);
                    writeToFile(list);
                    System.out.println("Đã xoá điện thoại: " + phone.getPhoneName() + " (ID: " + id + ")");
                    return;
                }
            }
        }
    }

    @Override
    public Phone findPhoneByID(int id) {
        List<Phone> list = readFromFile();
        for (Phone phone : list) {
            if (phone.getId() == id) {
                return phone;
            }
        }
        return null;
    }

    @Override
    public List<Phone> findPhoneByPhoneName(String name) {
        List<Phone> result = new ArrayList<>();
        List<Phone> list = readFromFile();
        for (Phone phone : list) {
            if (phone.getPhoneName().toLowerCase().contains(name.toLowerCase())) {
                result.add(phone);
            }
        }
        return result;
    }


}
