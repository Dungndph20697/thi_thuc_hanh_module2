import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PhoneManager phoneManager = new PhoneManager();
        Scanner sc = new Scanner(System.in);
        while (true) {
            menu();
            int choie = Integer.valueOf(sc.nextLine());
            switch (choie) {
                case 1: {
//                    System.out.println("Chọn loại điện thoại (1: xách tay, 2: chính hãng):");
//                    int type = Integer.valueOf(sc.nextLine());
//                    if (type == 1) {
//                        System.out.println("Nhập ID điện thoại: ");
//                        int id = Integer.valueOf(sc.nextLine());
//                        System.out.println("Nhập tên điện thoại: ");
//                        String phoneName = sc.nextLine();
//                        System.out.println("Nhập giá điện thoại: ");
//                        String price = sc.nextLine();
//                        System.out.println("Nhập số lượng điện thoại: ");
//                        int quantity = Integer.parseInt(sc.nextLine());
//                        System.out.println("Nhập nhà sản xuất: ");
//                        String brand = sc.nextLine();
//                        System.out.println("Nhập quốc gia xuất xứ: ");
//                        String sourceCountry = sc.nextLine();
//                        System.out.println("Nhập trạng thái (1: Da sua chua, 2: chua sua chua): ");
//                        int status = Integer.parseInt(sc.nextLine());
//                        Phone phone = new UnlockedPhone(id, phoneName, price, quantity, brand, sourceCountry, status);
//                        phoneManager.addPhone(phone);
//                    } else if (type == 2) {
//                        System.out.println("Nhập ID điện thoại: ");
//                        int id = Integer.valueOf(sc.nextLine());
//                        System.out.println("Nhập tên điện thoại: ");
//                        String phoneName = sc.nextLine();
//                        System.out.println("Nhập giá điện thoại: ");
//                        String price = sc.nextLine();
//                        System.out.println("Nhập số lượng điện thoại: ");
//                        int quantity = Integer.parseInt(sc.nextLine());
//                        System.out.println("Nhập nhà sản xuất: ");
//                        String brand = sc.nextLine();
//                        System.out.println("Nhập thời gian bảo hành: ");
//                        String warrantyDuration = sc.nextLine();
//                        System.out.println("Nhập phạm vi bảo hành: ");
//                        String warrantyCoverage = sc.nextLine();
//                        Phone phone = new GenuinePhone(id, phoneName, price, quantity, brand, warrantyDuration, warrantyCoverage);
//                        phoneManager.addPhone(phone);
//                    }
                    int id = phoneManager.genPhoneID();
                    System.out.println("Nhập tên điện thoại: ");
                    String phoneName;
                    while (true) {
                        phoneName = sc.nextLine();
                        if (phoneName.isEmpty()) {
                            System.out.println("Tên điện thoại không được để trống. Vui lòng nhập lại:");
                        } else {
                            break;
                        }
                    }


                    System.out.println("Nhập giá điện thoại: ");
                    String price;
                    while (true) {
                        price = sc.nextLine();
                        if (price.isEmpty()) {
                            System.out.println("Giá điện thoại không được để trống. Vui lòng nhập lại:");
                        }
                        {
                            try {
                                Double.parseDouble(price);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Giá điện thoại không hợp lệ. Vui lòng nhập lại:");
                            }
                        }
                    }
                    System.out.println("Nhập số lượng điện thoại: ");
                    int quantity;
                    while (true) {
                        try {
                            quantity = Integer.parseInt(sc.nextLine());
                            if (quantity <= 0) {
                                System.out.println("Số lượng điện thoại phải lớn hơn 0. Vui lòng nhập lại:");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Số lượng điện thoại không hợp lệ. Vui lòng nhập lại:");
                        }
                    }
                    System.out.println("Nhập nhà sản xuất: ");
                    String brand;
                    while (true) {
                        brand = sc.nextLine();
                        if (brand.isEmpty()) {
                            System.out.println("Nhà sản xuất không được để trống. Vui lòng nhập lại:");
                        } else {
                            break;
                        }
                    }
                    Phone phone = new Phone(id, phoneName, price, quantity, brand);
                    phoneManager.addPhone(phone);

                    break;
                }
                case 2: {
                    try {
                        System.out.println("Nhập ID điện thoại cần xoá: ");
                        int id = Integer.valueOf(sc.nextLine());
                        phoneManager.deletePhone(id);

                    } catch (Exception e) {
                        System.out.println("ID điện thoại không hợp lệ hoặc không tồn tại.");
                    }
                    break;
                }
                case 3: {
                    phoneManager.showAllPhones(phoneManager.readFromFile());
                    break;
                }
                case 4: {
                    System.out.print("Chọn tìm kiếm (1: tìm kiếm theo tên, 2: tìm kiếm theo id): ");
                    int choi2 = Integer.valueOf(sc.nextLine());
                    if (choi2 == 1) {
                        System.out.print("Nhập tên điện thoại cần tìm: ");
                        String name = sc.nextLine();
                        List<Phone> list = phoneManager.findPhoneByPhoneName(name);
                        phoneManager.showAllPhones(list);
                    } else if (choi2 == 2) {
                        System.out.print("Nhập ID điện thoại cần tìm: ");
                        int id = Integer.valueOf(sc.nextLine());
                        Phone phone = phoneManager.findPhoneByID(id);
                        if (phone != null) {
                            System.out.println(phone.toString());
                        } else {
                            System.out.println("Không tìm thấy điện thoại với ID: " + id);
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    return;
                }
            }
        }
    }

    private static void menu() {
        {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI--");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xoá");
            System.out.println("3. Xem danh sách điện thoại");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
        }
    }
}