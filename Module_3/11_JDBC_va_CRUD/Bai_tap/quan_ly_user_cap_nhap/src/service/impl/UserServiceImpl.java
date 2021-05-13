package service.impl;

import model.bean.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.SortName;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final String regexName = "^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ]" +
            "[aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*" +
            "(\\s[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ]" +
            "[aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*$";
    private final String regexEmail = "^[\\w+.]*[\\w+@][\\w+]+[.][\\w]+$";

    private UserRepository repository = new UserRepositoryImpl();

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findId(int id) {
        return repository.findId(id);
    }

    @Override
    public boolean save(String name, String email, String country) {
        if (!name.matches(this.regexName)){
            System.out.println("name");
            return false;
        }
        if (!email.matches(this.regexEmail)){
            return false;
        }
        return repository.save(new User(name, email, country));
    }

    @Override
    public boolean update(int id, String name, String email, String country) {
        if (!name.matches(regexName)){
            return false;
        }
        if (!email.matches(regexEmail)){
            return false;
        }
        return repository.update(id, new User(name, email, country));
    }

    @Override
    public boolean remove(int id) {
        return repository.remove(id);
    }

    @Override
    public List<User> findCountry(String country) {
        return repository.findCountry(country);
    }

    @Override
    public List<User> sortName() {
        ArrayList<User> list = (ArrayList<User>)this.findAll();
        list.sort(new SortName());
        return list;
    }
}
