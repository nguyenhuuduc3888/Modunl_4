package all.service;

import all.model.Oder;

import java.util.List;

public interface IOderService {
    List<Oder> findAll();

    Oder save(Oder oder);
}
