package com.sonoma.challenge.serviceimpls;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ZipRangeServiceImplTest {
	@Autowired
	private ZipRangeServiceImpl zipRangeService;

	@Test
	public void testResponse() throws Exception {
		List<Integer[]> test = new ArrayList<>();
		test.add(new Integer[] { 94133, 94133 });
		test.add(new Integer[] { 94200, 94299 });
		test.add(new Integer[] { 94226, 94699 });
		List<Integer[]> entity = zipRangeService.buildZipCodeRange(test);
		List<Integer[]> response = new ArrayList<>();
		response.add(new Integer[] { 94133, 94133 });
		response.add(new Integer[] { 94200, 94699 });
		Assertions.assertEquals(response.get(0)[0], entity.get(0)[0]);
	}
	

	@Test
	public void testResponse1() throws Exception {
		List<Integer[]> test = new ArrayList<>();
		List<Integer[]> entity = zipRangeService.buildZipCodeRange(test);
		List<Integer[]> response = new ArrayList<>();
		Assertions.assertEquals(response, entity);
	}


	@Test
	public void testNegativeResponse() throws Exception {
		List<Integer[]> test = new ArrayList<>();
		test.add(new Integer[] { 94133, 94133 });
		test.add(new Integer[] { 94200, 94299 });
		test.add(new Integer[] { 94226, 94699 });
		List<Integer[]> entity = zipRangeService.buildZipCodeRange(test);
		List<Integer[]> response = new ArrayList<>();
		response.add(new Integer[] { 94133, 94133 });
		response.add(new Integer[] { 94200, 94699 });
		Assertions.assertNotEquals(response, entity);
	}

}
