package all.service;

import all.repository.ITranslateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.Kernel;
import java.util.Map;

@Service
public class TranslateService implements ITranslateService {
    @Autowired
    ITranslateRepository translateRepository;

    @Override
    public String translate(String keySearch) {
        Map<String, String> MapList = translateRepository.getData();
        String result = MapList.get(keySearch);
        if (result == null) {
            result = "Khong dich duoc be oi";
        }
        return result;
    }

}
