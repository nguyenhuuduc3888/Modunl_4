package all.service;

import all.repository.ITranslateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslateService implements ITranslateService {
    @Autowired
    ITranslateRepository translateRepository;

    @Override
    public String translate(String keySearch) {
        return translateRepository.translate(keySearch);
    }
}
