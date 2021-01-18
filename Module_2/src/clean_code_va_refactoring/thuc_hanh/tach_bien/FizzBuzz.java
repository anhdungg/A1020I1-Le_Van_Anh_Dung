package clean_code_va_refactoring.thuc_hanh.tach_bien;

public class FizzBuzz {
    public static String fizzBuzz(int number){
        boolean isFizz = number%3==0;
        boolean isBuzz = number%5==0;

        if(isFizz && isBuzz){
            return "FizzBuzz";
        }else if (isBuzz){
            return "Buzz";
        }else if(isFizz){
            return "Fizz";
        }else return ""+number;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(3));
    }
}
