package all.repository;

import org.springframework.stereotype.Repository;

@Repository
public class SettingRepository implements ISettingRepository {
    @Override
    public String[] getLanguages() {
        String[] languages = {"English", "Vietnamese", "Japanese", "Chinese"};
        return languages;
    }

    @Override
    public int[] getPageSize() {
        int[] pageSize = {5, 10, 15, 25, 50,100};
        return pageSize;
    }
}
