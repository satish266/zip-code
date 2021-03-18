package com.sonoma.challenge.resources;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sonoma.challenge.exceptions.ZipRangeException;
import com.sonoma.challenge.services.ZipRangeService;

@RestController
public class ZipRangeResource {

	private static final Logger LOG = LogManager.getLogger(ZipRangeResource.class.getName());

	@Autowired
	ZipRangeService zipRangeService;

	@PostMapping("buildZipCodeRange")
	public ResponseEntity<List<Integer[]>> buildZipCodeRange(@RequestBody List<Integer[]> zipRanges)
			throws ZipRangeException {
		try {
			LOG.info("[ BuildZipCodeRange method {} ]", Arrays.toString(zipRanges.toArray()));
			return new ResponseEntity<List<Integer[]>>(zipRangeService.buildZipCodeRange(zipRanges), HttpStatus.OK);
		} catch (NumberFormatException exc) {
			LOG.debug("[ BuildZipCodeRange NumberFormatException {} ]", exc.getMessage());
			throw new ZipRangeException("Invalid Number", exc.getMessage());
		} catch (Exception e) {
			LOG.debug("[ BuildZipCodeRange Exception {} ]", e.getMessage());
			throw new ZipRangeException("Exception", e.getMessage());
		}
	}
}
