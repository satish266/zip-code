package com.sonoma.challenge.serviceimpls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sonoma.challenge.exceptions.ZipRangeException;
import com.sonoma.challenge.services.ZipRangeService;

@Service
public class ZipRangeServiceImpl implements ZipRangeService {

	Integer min = Integer.MAX_VALUE;
	Integer max = 0;

	@Override
	public List<Integer[]> buildZipCodeRange(List<Integer[]> zipCodeRanges) throws ZipRangeException {
		min = Integer.MAX_VALUE;
		max = 0;
		List<Integer[]> zipRangeEvaluation = new ArrayList<>();

		if (zipCodeRanges.size() == 0)
			return zipRangeEvaluation;


		/* Complexity O(n) where n is number of zip code ranges. */
		for (int i = 0; i < zipCodeRanges.size(); i++) {
			int zipMin = zipCodeRanges.get(i)[0];
			int zipMax = zipCodeRanges.get(i)[1];
			if (zipCodeRanges.get(i).length == 2 && (Math.floor(zipMin) == zipMin) && (Math.floor(zipMax) == zipMax)) {
				if (min > zipMin) {
					min = zipMin;
				}
				if (max < zipMax) {
					max = zipMax;
				}
			} else {
				  throw new ZipRangeException(
		                  "Invalid Range", "Invalid input of zip code ranges");
			}
		}
		// Initialize an array of max - min length
		String[] data = new String[max - min + 1]; 
		zipCodeRanges.forEach((zipCode) -> Arrays.fill(data, zipCode[0] - min, zipCode[1] - min + 1, "range"));
		Integer leftZipRange = min - 1;
		Integer rightZipRange = min;
		/*  Complexity is a constant O(c) where c in worst case would be 99999. */
		for (int i = 0; i < data.length - 1; i++) {
			if (data[i] == "range") {
				rightZipRange = min + i;
			}
			if (data[i] == null) {
				leftZipRange = min + i;
			}

			if (data[i] == "range" && data[i + 1] == null) { 
		/* Time to populate Zip Code Restriction Range Array */
				Integer[] lst = { leftZipRange + 1, rightZipRange };
				zipRangeEvaluation.add(lst);
			}
		}
		Integer[] last = { leftZipRange + 1, max };
		zipRangeEvaluation.add(last);
		if (min == Integer.MAX_VALUE && max == 0) {
			return zipRangeEvaluation;
		}
		return zipRangeEvaluation;

	}
}
