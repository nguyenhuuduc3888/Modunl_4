package all.service.ipml;

import all.model.Oder;
import all.repository.IOderRepository;
import all.repository.IBookRepository;
import all.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OderService implements IOderService {
    @Autowired
    IOderRepository oderRepository;
    @Autowired
    IBookRepository bookRepository;

    @Override
    public List<Oder> findAll() {
        return oderRepository.findAll();
    }

    @Override
    public Oder save(Oder oder) {
     return    oderRepository.save(oder);
    }

}
