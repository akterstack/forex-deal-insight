package bloomberg.fxdeal.insight.deal;

import bloomberg.fxdeal.insight.Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/api/deals")
public class FxDealRestController {

    private FxDealRepository fxDealRepository;

    public FxDealRestController(FxDealRepository fxDealRepository) {
        this.fxDealRepository = fxDealRepository;
    }

    @GetMapping
    public Iterable<FxDeal> test() {
        long start = System.currentTimeMillis();
        Iterable<FxDeal> fxDeals = fxDealRepository.save(
                Utils.loadObjectList(FxDeal.class, new File("BloombergFxD.csv")));
        System.out.println("---------------------- " + ((System.currentTimeMillis() - start)/1000));
        return fxDeals;
    }

}
