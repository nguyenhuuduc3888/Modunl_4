package all.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ConvertRepository implements IConvertRepository {
    @Override
    public double convert(double usd, double rate) {
        return usd * rate;
    }
}
