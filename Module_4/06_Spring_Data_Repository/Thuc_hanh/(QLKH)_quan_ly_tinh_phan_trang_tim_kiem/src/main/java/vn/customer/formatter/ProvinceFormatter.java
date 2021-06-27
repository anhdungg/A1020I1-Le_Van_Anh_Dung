package vn.customer.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import vn.customer.model.Province;
import vn.customer.service.ProvinceService;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ProvinceFormatter implements Formatter<Province> {

    private ProvinceService provinceService;

    @Autowired
    public ProvinceFormatter(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    public ProvinceFormatter() {

    }

    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        return provinceService.findById((int) Long.parseLong(text));
    }

    @Override
    public String print(Province object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}