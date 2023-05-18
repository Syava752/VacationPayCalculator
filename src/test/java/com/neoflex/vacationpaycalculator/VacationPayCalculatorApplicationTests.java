package com.neoflex.vacationpaycalculator;

import com.neoflex.vacationpaycalculator.vacation.CalculateServiceTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CalculateServiceTest.class)
@AutoConfigureMockMvc
class VacationPayCalculatorApplicationTests {
	@Test
	void contextLoads() {
	}
}
