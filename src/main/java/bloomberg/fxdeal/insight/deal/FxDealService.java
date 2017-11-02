package bloomberg.fxdeal.insight.deal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FxDealService {

    private AtomicInteger count = new AtomicInteger(0);

    @Autowired
    private final FxDealRepository fxDealRepository;

    public FxDealService(FxDealRepository fxDealRepository) {
        this.fxDealRepository = fxDealRepository;
    }

    @Transactional
    public FxDeal save(FxDeal fxDeal) {
        return fxDealRepository.save(fxDeal);
    }

    @Transactional
    public Iterable<FxDeal> saveAll(List<FxDeal> fxDeals) {
        System.out.println("=================================================");
        System.out.println(count.addAndGet(1));
        return fxDealRepository.save(fxDeals);
    }

}
