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
        dictionary.put("Water", "Nuoc");
    }

    @Override
    public Map<String, String> getData() {
        return dictionary;
    }

}

