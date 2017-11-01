package bloomberg.fxdeal.insight.deal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FxDealService {

    @Autowired
    private final FxDealRepository fxDealRepository;

    public FxDealService(FxDealRepository fxDealRepository) {
        this.fxDealRepository = fxDealRepository;
    }

    @Transactional
    public void saveAll(List<FxDeal> fxDeals) {
        fxDealRepository.save(fxDeals);
    }

}
