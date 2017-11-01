package bloomberg.fxdeal.insight.deal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deals")
public class FxDealRestController {

    private FxDealRepository fxDealRepository;

    public FxDealRestController(FxDealRepository fxDealRepository) {
        this.fxDealRepository = fxDealRepository;
    }

}
