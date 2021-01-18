package clean_code_va_refactoring.thuc_hanh.doi_ten_bien_va_tach_hang;

public class Calculator {
    public static int calculator(int firstOperand, int secondsOperand, char operand){
        final char ADDITION = '+';
        final char SUBTRACTION = '-';
        final char MULTIPLICATION = '*';
        final char DIVISION = '/';
        switch (operand){
            case ADDITION:
                return firstOperand+secondsOperand;
            case SUBTRACTION:
                return firstOperand-secondsOperand;
            case MULTIPLICATION:
                return firstOperand*secondsOperand;
            case DIVISION:
                if(secondsOperand!=0){
                    return firstOperand/secondsOperand;
                }else {
                    throw new RuntimeException("Can not divide by 0");
                }
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }

    public static void main(String[] args) {
        System.out.println(calculator(1,0, '/'));
    }
}
