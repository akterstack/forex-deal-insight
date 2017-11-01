package bloomberg.fxdeal.insight;

import bloomberg.fxdeal.insight.deal.FxDeal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.File;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //@PostConstruct
    void setUp() {
        System.out.println("////////////////////////////////////////////////////////////////");
        Utils.loadObjectList(FxDeal.class, new File("BloombergFxD.csv"));
    }

}
