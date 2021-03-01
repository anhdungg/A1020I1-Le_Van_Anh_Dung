package java_collection_framework.bai_tap.luyen_tap_su_dung_ArrayList_LinkedList_trong_java.su_dung_ArrayList;

import stack_queue.bai_tap.to_chuc_du_lieu_hop_ly_Demerging_su_dung_Queue.Manage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ManageProduct {
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

    private boolean editProduct(int id, Scanner input){
        int posProduct = this.searchIdProduct(id);
        if(posProduct!=-1){
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

    private boolean deleteProduct(int id, Scanner input){
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

    private String searchNameProduct(String name){
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

    private boolean sortProduct(){
        if(this.products.isEmpty()){
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
        ManageProduct manage = new ManageProduct();
        int select;
        while (true){
            System.out.println("1. Thêm sản phẩm \n" +
                    "2. Sửa thông tin sản phẩm theo id \n" +
                    "3. Xoá sản phẩm theo id \n" +
                    "4. Hiển thị danh sách sản phẩm \n" +
                    "5. Tìm kiếm sản phẩm theo tên \n" +
                    "6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá");
            select = input.nextInt();
            input.nextLine();
            switch (select){
                case 1:
                    manage.addProduct(input);
                    break;
                case 2:

            }
        }

//        manage.add(1, "Thuoc", 10000);
//        manage.add(5, "Nuoc loc", 15000);
//        manage.add(4, "May tinh", 400000);
//        manage.add(3, "Chuot", 500000);

//        System.out.println(manage.searchNameProduct("Chuot"));
//        System.out.println(manage.editProduct(1, input));
//        System.out.println(manage.toString());
//        manage.deleteProduct(1, input);
//        System.out.println(manage.toString());
//        manage.sortProduct();
//        System.out.println(manage.toString());
    }
}
