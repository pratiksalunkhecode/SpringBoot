package SpringBootBasicsWithChatGPT.SpringBasics.servicess;

import SpringBootBasicsWithChatGPT.SpringBasics.Model.medicin;
import SpringBootBasicsWithChatGPT.SpringBasics.repository.medicinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class medicinService {

    @Autowired
    private medicinRepo medicinRepo;


    public List<medicin> Getallmedicin(){
       return medicinRepo.findAll();
    }


    public Optional<medicin> getById(Long id){
        return medicinRepo.findById(id);
    }


    public Optional<medicin> deleteById(Long id){
         medicinRepo.deleteById(id);
        return null;
    }



}
