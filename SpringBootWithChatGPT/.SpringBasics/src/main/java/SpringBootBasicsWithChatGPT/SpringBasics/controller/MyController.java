package SpringBootBasicsWithChatGPT.SpringBasics.controller;

import SpringBootBasicsWithChatGPT.SpringBasics.Model.medicin;
import SpringBootBasicsWithChatGPT.SpringBasics.servicess.medicinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("{/api/medicin}")
public class MyController {

    @Autowired
    private medicinService medicinService;

    @GetMapping("/medicin")
    public List<medicin> getallmedicin(){
        return medicinService.Getallmedicin();
    }

    @GetMapping("/medicin/{id}")
        public Optional<medicin> getById(@PathVariable Long id){
            return medicinService.getById(id);
        }

        @GetMapping("/medicin/{deleteid}")
        public Optional<medicin> deleteById(@PathVariable Long id){
            return medicinService.deleteById(id);
        }




}
