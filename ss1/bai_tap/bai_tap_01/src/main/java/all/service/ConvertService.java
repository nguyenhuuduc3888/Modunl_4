package all.service;

import all.repository.IConvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConvertService implements IConvertService {
    @Autowired
    IConvertRepository convertRepository;

    @Override
    public double convert(double usd, double rate) {
        return convertRepository.convert(usd, rate);
    }
}
