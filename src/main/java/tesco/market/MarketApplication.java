package tesco.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketApplication.class, args);
	}

}

/*
* {
  "user": {
    "name": "string",
    "userType": "EMPLOYEE | AFFILIATE | CUSTOMER",
    "registrationDate": "YYYY-MM-DD"
  },
  "bill": {
    "amount": 0.0,
    "isGrocery": true | false
  }
}
*/
