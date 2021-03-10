package xu_ly_ngoai_le_va_debug.bai_tap.su_dung_lop_IllegalTriangleException;

public class IllegalTriangleException extends Exception{

    public IllegalTriangleException(){
        super("Kiểm tra lại tam giác!!!!");
    }

    public IllegalTriangleException(String str){
        super(str);
    }
}
