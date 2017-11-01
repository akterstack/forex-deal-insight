package bloomberg.fxdeal.test.insight

import bloomberg.fxdeal.insight.Utils
import bloomberg.fxdeal.insight.deal.FxDeal
import org.junit.Test

import static org.junit.Assert.*


class CsvMapperTests {

    @Test
    void testCsvToPojoMapper() {
        List<FxDeal> fxDealList = Utils.loadObjectList(FxDeal, new File("BloombergFxD.csv"))
        assertEquals("All records cannot be mapped.", fxDealList.size(), 100_000)
    }

}
