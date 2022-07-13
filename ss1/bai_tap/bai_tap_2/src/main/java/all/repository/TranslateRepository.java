package all.repository;


import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository

public class TranslateRepository implements ITranslateRepository {
    static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("Milk", "Sua");
        dictionary.put("Rice", "Gao");
        dictionary.put("Water", "Nuo" +
                "c");
    }

    @Override
    public String translate(String keySearch) {
        String result = dictionary.get(keySearch);
        if (result == null) {
            result = "Khong dich duoc be oi";
        }
        return result;
    }
}

