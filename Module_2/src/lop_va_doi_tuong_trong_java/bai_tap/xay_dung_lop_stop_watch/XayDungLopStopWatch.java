package lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_stop_watch;

import java.util.Arrays;
import java.util.Random;

public class XayDungLopStopWatch {
    private long startTime = 0;
    private long stopTime = 0;
    XayDungLopStopWatch(){
        this.startTime = System.currentTimeMillis();
    }

    public void start(){
        this.startTime = System.currentTimeMillis();
    }

    public void stop(){
        this.stopTime = System.currentTimeMillis();
    }

    public long getElapsedTime(){
        this.stop();
        return this.stopTime-this.startTime;
    }
    static void randomArray(int[] array, Random random){
        for (int i=0; i<array.length; i++){
            array[i] = random.nextInt(100000);
        }
    }
    public static void main(String[] args) {
        XayDungLopStopWatch elapsedTime = new XayDungLopStopWatch();
        Random random = new Random();

        int[] array = new int[100000];

        randomArray(array, random);
        elapsedTime.start();
         int x=0, last=0;
         for(int i=1; i<array.length; i++){
             last = array[i];
             x=i;
             while(x>0 && array[x-1]>last){
                 array[x] = array[x-1];
                 x--;
             }
             array[x] = last;
         }
         System.out.println("Sắp xếp chèn: " + elapsedTime.getElapsedTime() + " milliseconds");

         randomArray(array, random);
         elapsedTime.start();
         for (int i=0; i<array.length-1; i++){
             int local=i;
             for (int j=i+1; j<array.length; j++){
                 if(array[local]>array[j]){
                     local=j;
                 }
             }
             int a = array[i];
             array[i] = array[local];
             array[local] = a;
         }
         System.out.println("Sắp xếp chọn: " + elapsedTime.getElapsedTime() + " milliseconds");

         randomArray(array, random);
         for(int i=array.length-1; i>0; i--){
             for(int j=1; j<=i; j++){
                 if(array[j-1]>array[j]){
                     int a = array[j];
                     array[j] = array[j-1];
                     array[j-1] = a;
                 }
             }
         }
         System.out.println("Sắp xếp nổi bọt: " + elapsedTime.getElapsedTime() + " milliseconds");
         System.out.println(Arrays.toString(array));
    }
}
