package bloomberg.fxdeal.insight.deal;

import bloomberg.fxdeal.insight.StreamUtils;
import bloomberg.fxdeal.insight.Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/api/deals")
public class FxDealRestController {

    private FxDealService fxDealService;

    public FxDealRestController(FxDealService fxDealService) {
        this.fxDealService = fxDealService;
    }

    @GetMapping("test")
    public Long test() {
        List<FxDeal> fxDealsToSave = Utils.loadObjectList(FxDeal.class, new File("BloombergFxD.csv"));
        long start = System.currentTimeMillis();
        fxDealService.saveAll(fxDealsToSave);
        return (System.currentTimeMillis() - start);
    }

    @GetMapping("testParallelStream")
    public Long testParallelStream() {
        List<FxDeal> fxDealsToSave = Utils.loadObjectList(FxDeal.class, new File("BloombergFxD.csv"));
        long start = System.currentTimeMillis();
        //int from = 0, to = 100;
        fxDealsToSave.parallelStream()
                .collect(StreamUtils.batchCollector(1000, fxDealService::saveAll));
                //.map(i -> fxDealsToSave.get(from))
                //.forEach(fxDealService::saveAll);
        //fxDealRepository.save(fxDealsToSave);
        return (System.currentTimeMillis() - start);
    }

}
