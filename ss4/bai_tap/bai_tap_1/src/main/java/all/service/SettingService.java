package all.service;

import all.repository.ISettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingService implements ISettingService {
    @Autowired
    ISettingRepository settingRepository;

    @Override
    public String[] getLanguages() {
        return settingRepository.getLanguages();
    }

    @Override
    public int[] getPageSize() {
        return settingRepository.getPageSize();
    }
}
