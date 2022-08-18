package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
@Log4j
public class SampleTests {
//	@Setter(onMethod_ = {@Autowired})
	@Autowired
	private Restaurant restaurant;

	@Test
	public void testExist() {
		Optional<String> opt = Optional.empty(); // Optional를 null로 초기화함.

		 

		System.out.println(opt.orElse("빈 Optional 객체"));

		System.out.println(opt.orElseGet(String::new));
	}
}
