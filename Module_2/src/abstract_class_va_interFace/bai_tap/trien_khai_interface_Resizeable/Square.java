package abstract_class_va_interface.bai_tap.trien_khai_interface_Resizeable;

import abstract_class_va_interface.bai_tap.trien_khai_interface_Colorable.*;

public class Square extends Rectangle implements Resizeable, Colorable{
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        super.resize(percent);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
