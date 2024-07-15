package tesco.market;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import tesco.market.controller.DiscountController;
import tesco.market.entity.Bill;
import tesco.market.entity.DiscountRequest;
import tesco.market.entity.User;
import tesco.market.enums.UserType;
import tesco.market.repo.BillRepo;
import tesco.market.repo.UserRepo;
import tesco.market.service.DiscountService;

@SpringBootTest
@ExtendWith({MockitoExtension.class, SpringExtension.class})
@WebMvcTest(DiscountController.class)
@AutoConfigureMockMvc
class MarketApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private DiscountService discountService;

	@Mock
	private UserRepo userRepository;

	@Mock
	private BillRepo billRepository;

	private User employee;
	private User affiliate;
	private User longTermCustomer;
	private User regularCustomer;
	private Bill bill;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);

		employee = new User();
		employee.setUserName("Employee");
		employee.setUserType(UserType.EMPLOYEE);
		employee.setRegistrationDate(LocalDate.now());

		affiliate = new User();
		affiliate.setUserName("Affiliate");
		affiliate.setUserType(UserType.AFFILIATE);
		affiliate.setRegistrationDate(LocalDate.now());

		longTermCustomer = new User();
		longTermCustomer.setUserName("LongTermCustomer");
		longTermCustomer.setUserType(UserType.CUSTOMER);
		longTermCustomer.setRegistrationDate(LocalDate.now().minusYears(3));

		regularCustomer = new User();
		regularCustomer.setUserName("RegularCustomer");
		regularCustomer.setUserType(UserType.CUSTOMER);
		regularCustomer.setRegistrationDate(LocalDate.now());

		bill = new Bill();
		bill.setAmount(200);
		bill.setGrocery(false);
	}

	@Test
	public void testCalculateNetPayableAmount() throws Exception {
		User user = new User();
		user.setUserName("John Doe");
		user.setUserType(UserType.EMPLOYEE);
		user.setRegistrationDate(LocalDate.now());

		Bill bill = new Bill();
		bill.setAmount(100.0);
		bill.setGrocery(false);

		DiscountRequest request = new DiscountRequest();
		request.setUser(user);
		request.setBill(bill);

		when(discountService.calculateNetPayableAmount(any(User.class), any(Bill.class))).thenReturn(90.0); // Example return value

		mockMvc.perform(MockMvcRequestBuilders.post("/api/discount/calculate")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(request)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.content().json("90.0"));
	}

	private String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
