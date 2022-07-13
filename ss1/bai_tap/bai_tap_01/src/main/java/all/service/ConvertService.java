package all.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {
    @Override
    public double convert(double usd, double rate) {
        return usd * rate;
    }
}
