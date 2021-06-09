package dictionary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerDictionary {
    private String[] eng = new String[]{"","hello", "mouse", "laptop", "controller"};
    private String[] vin = new String[]{"", "xin chào", "chuột", "máy tính xách tay", "điều khiển"};

    @GetMapping(value = "/")
    public String home(){
        return "index";
    }

    @GetMapping(value = "/translate")
    public String translate(@RequestParam("input") String input, Model model){
        model.addAttribute("input", input);
        model.addAttribute("output", find(input));
        return "index";
    }

    private String find(String input){
        input = input.toLowerCase();
        for (int i=0; i<this.eng.length; i++){
            if (eng[i].equals(input)){
                return this.vin[i];
            }
        }
        return "Không tìm thấy";
    }
}
