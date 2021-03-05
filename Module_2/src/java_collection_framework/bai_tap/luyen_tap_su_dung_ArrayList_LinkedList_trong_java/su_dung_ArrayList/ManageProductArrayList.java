package java_collection_framework.bai_tap.luyen_tap_su_dung_ArrayList_LinkedList_trong_java.su_dung_ArrayList;

import java_collection_framework.bai_tap.luyen_tap_su_dung_ArrayList_LinkedList_trong_java.su_dung_ArrayList.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ManageProductArrayList {
    ArrayList<Product> products = new ArrayList<>();

    private void add(int id, String nameProduct, double money){
        Product product = new Product(id, nameProduct, money);
        this.products.add(product);
    }
    private void addProduct(Scanner input){
        System.out.print("Id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Tên sản phẩm: ");
        String nameProduct = input.nextLine();
        System.out.print("Giá: ");
        double money = input.nextDouble();
        Product product = new Product(id, nameProduct, money);
        this.products.add(product);
    }

    private boolean editProduct(Scanner input){
        System.out.print("Nhập id cần chỉnh sửa: ");
        int id = input.nextInt();
        input.nextLine();
        int posProduct = this.searchIdProduct(id);
        if(posProduct!=-1){
            System.out.println(this.products.get(posProduct));
            System.out.print("Id: ");
            this.products.get(posProduct).setId(input.nextInt());
            input.nextLine();
            System.out.print("Tên sản phẩm: ");
            this.products.get(posProduct).setNameProduct(input.nextLine());
            System.out.print("Giá: ");
            this.products.get(posProduct).setMoney(input.nextDouble());
            return true;
        }else {
            return false;
        }
    }

    private boolean deleteProduct(Scanner input){
        System.out.print("Nhập id cần xoá: ");
        int id = input.nextInt();
        input.nextLine();
        int posProduct = this.searchIdProduct(id);
        if(posProduct!=-1){
            this.products.remove(posProduct);
            return true;
        }else {
            return false;
        }
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        for (Product product : this.products){
            string.append(product.toString()).append("\n");
        }
        return string.toString();
    }

    private String searchNameProduct(Scanner input){
        System.out.print("Nhập tên sản phẩm: ");
        String name = input.nextLine();
        StringBuilder string = new StringBuilder();
        if (!this.products.isEmpty()) {
            for (Product product : this.products) {
                if (product.getNameProduct().equals(name)) {
                    string.append(product.toString()).append("\n");
                }
            }
        }
        if(string.length()==0){
            return "Not Found";
        }else {
            return string.toString();
        }
    }

    private boolean sortProduct(Scanner input){
        int select;
        do {
            System.out.println("1. Sắp xếp tăng dần \n" +
                    "2. Sắp xếp giảm dần \n" +
                    "3. Thoát");
            System.out.print("Chọn menu: ");
            select = input.nextInt();
            input.nextLine();
            switch (select){
                case 1:
                    Product.statusSort = true;
                    break;
                case 2:
                    Product.statusSort = false;
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Nhập sai xin hãy nhập lại.");
            }
        }while (select<1 || select>3);
        if(this.products.isEmpty() || select==3){
            return false;
        }else {
            Collections.sort(this.products);
            return true;
        }
    }
    private int searchIdProduct(int id){
        if (!this.products.isEmpty()) {
            for (int i = 0; i < this.products.size(); i++) {
                if (this.products.get(i).getId() == id) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ManageProductArrayList manage = new ManageProductArrayList();
        manage.add(1, "Thuoc", 10000);
        manage.add(5, "Nuoc loc", 15000);
        manage.add(4, "May tinh", 400000);
        manage.add(3, "Chuot", 500000);
        int select;
        do {
            System.out.println("1. Thêm sản phẩm \n" +
                    "2. Sửa thông tin sản phẩm theo id \n" +
                    "3. Xoá sản phẩm theo id \n" +
                    "4. Hiển thị danh sách sản phẩm \n" +
                    "5. Tìm kiếm sản phẩm theo tên \n" +
                    "6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá \n" +
                    "7. Thoát");
            System.out.print("Chọn menu: ");
            select = input.nextInt();
            input.nextLine();
            switch (select) {
                case 1:
                    manage.addProduct(input);
                    break;
                case 2:
                    if (manage.editProduct(input)) {
                        System.out.println("Sửa thông tin thành công.");
                    } else {
                        System.out.println("Không tìm thấy id");
                    }
                    break;
                case 3:
                    if (manage.deleteProduct(input)) {
                        System.out.println("Xoá thành công.");
                    } else {
                        System.out.println("Không tìm thấy id.");
                    }
                    break;
                case 4:
                    System.out.println(manage.toString());
                    break;
                case 5:
                    System.out.println(manage.searchNameProduct(input));
                    break;
                case 6:
                    if (manage.sortProduct(input)) {
                        System.out.println("Sắp xếp thành công.");
                    }else {
                        System.out.println("Sắp xếp thất bại.");
                    }
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Nhập sai xin hãy nhập lại.");
            }
        } while (select != 7);
    }
}
