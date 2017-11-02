package bloomberg.fxdeal.insight.deal;

import bloomberg.fxdeal.insight.Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/deals")
public class FxDealRestController {

    private FxDealRepository fxDealRepository;

    public FxDealRestController(FxDealRepository fxDealRepository) {
        this.fxDealRepository = fxDealRepository;
    }

    @GetMapping
    public Long test() {
        List<FxDeal> fxDealsToSave = Utils.loadObjectList(FxDeal.class, new File("BloombergFxD.csv"));
        long start = System.currentTimeMillis();
        fxDealRepository.save(fxDealsToSave);
        return (System.currentTimeMillis() - start)/1000;
    }

}
