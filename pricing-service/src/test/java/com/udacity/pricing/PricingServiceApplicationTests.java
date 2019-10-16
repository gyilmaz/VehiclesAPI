package com.udacity.pricing;
import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.service.PricingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PricingServiceApplicationTests {

	@MockBean
	PricingService pricingService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getPriceFromService() throws  Exception{
		for(long i=1; i<20; i++ ) {
			Price price = pricingService.getPrice(i);
			Assert.assertTrue(price.getPrice().compareTo(new BigDecimal(4999d))==1);
			Assert.assertTrue(new BigDecimal(25001d).compareTo(price.getPrice())==1);
			Assert.assertEquals(price.getCurrency(),"USD");
			Assert.assertTrue(i==price.getVehicleId());
		}
	}


}
