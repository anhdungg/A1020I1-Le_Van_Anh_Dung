package abstract_class_va_interface.thuc_hanh.lop_animal_va_interface_edible.animal;

import abstract_class_va_interface.thuc_hanh.lop_animal_va_interface_edible.edible.Edible;

public class Tiger extends Animal implements Edible {

    @Override
    public String makeSound() {
        return "Tiger: roarrrrr!";
    }

    @Override
    public String howToEat() {
        return "Can't eat";
    }
}
