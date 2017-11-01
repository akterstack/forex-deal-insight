package bloomberg.fxdeal.test.insight

import bloomberg.fxdeal.insight.Application
import bloomberg.fxdeal.insight.deal.FxDeal
import bloomberg.fxdeal.insight.deal.FxDealRepository
import bloomberg.fxdeal.insight.deal.FxDealService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.util.Assert

import java.sql.Timestamp

@RunWith(SpringJUnit4ClassRunner)
@SpringBootTest(classes = [Application])
class FxDealServiceTests {

    @Autowired
    FxDealService fxDealService

    @Autowired
    FxDealRepository fxDealRepository

    @Test
    void saveFxDeal() {
        Iterable<FxDeal> fxDeals = fxDealService.saveAll([
                new FxDeal(
                        uuid: UUID.randomUUID(),
                        fromCurrency: Currency.getInstance("USD"),
                        toCurrency: Currency.getInstance("BDT"),
                        timestamp: new Timestamp(System.currentTimeMillis()),
                        amount: 100
                )
        ])
        Assert.notEmpty(fxDeals.toList(), "Deal not saved")
    }

}
