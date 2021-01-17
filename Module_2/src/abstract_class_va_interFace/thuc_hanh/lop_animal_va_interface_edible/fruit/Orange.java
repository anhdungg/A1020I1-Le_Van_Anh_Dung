package abstract_class_va_interface.thuc_hanh.lop_animal_va_interface_edible.fruit;

import abstract_class_va_interface.thuc_hanh.lop_animal_va_interface_edible.edible.Edible;

public class Orange extends Fruit implements Edible {
    @Override
    public String howToEat() {
        return "Orange could be juiced";
    }
}
