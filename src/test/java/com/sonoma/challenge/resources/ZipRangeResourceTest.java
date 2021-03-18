package com.sonoma.challenge.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.sonoma.challenge.services.ZipRangeService;

@SpringBootTest
public class ZipRangeResourceTest {

	@InjectMocks
	ZipRangeResource zipRangeResource;

	@Mock
	ZipRangeService zipRangeService;

	@Test
	public void testPositiveResponseCode() throws Exception {
		List<Integer[]> test = new ArrayList<>();
		test.add(new Integer[] { 94133, 94133 });
		test.add(new Integer[] { 94200, 94299 });
		test.add(new Integer[] { 94226, 94699 });
		List<Integer[]> response = new ArrayList<>();
		response.add(new Integer[] { 94133, 94133 });
		response.add(new Integer[] { 94200, 94699 });
		ResponseEntity<List<Integer[]>> entity = zipRangeResource.buildZipCodeRange(test);
		when(zipRangeService.buildZipCodeRange(test)).thenReturn(response);
		assertEquals(200, entity.getStatusCodeValue());
	}

	@Test
	public void testResponse() throws Exception {
		List<Integer[]> test = new ArrayList<>();
		test.add(new Integer[] { 94133, 94133 });
		test.add(new Integer[] { 94200, 94299 });
		test.add(new Integer[] { 94226, 94699 });
		List<Integer[]> response = new ArrayList<>();
		response.add(new Integer[] { 94133, 94133 });
		response.add(new Integer[] { 94200, 94699 });
		when(zipRangeService.buildZipCodeRange(test)).thenReturn(response);
		ResponseEntity<List<Integer[]>> entity = zipRangeResource.buildZipCodeRange(test);
		assertEquals(response.get(0)[0], entity.getBody().get(0)[0]);
	}

	@Test
	public void testNegativeResponse() throws Exception {
		List<Integer[]> test = new ArrayList<>();
		test.add(new Integer[] { 94133, 94133 });
		test.add(new Integer[] { 94200, 94299 });
		test.add(new Integer[] { 94226, 94699 });
		List<Integer[]> response = new ArrayList<>();
		response.add(new Integer[] { 94133, 94133 });
		response.add(new Integer[] { 94200, 94699 });
		ResponseEntity<List<Integer[]>> entity = zipRangeResource.buildZipCodeRange(test);
		when(zipRangeService.buildZipCodeRange(test)).thenReturn(response);
		assertNotEquals(response, entity.getBody());
	}

}
