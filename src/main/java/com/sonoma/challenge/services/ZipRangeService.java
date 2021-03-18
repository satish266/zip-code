package com.sonoma.challenge.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sonoma.challenge.exceptions.ZipRangeException;

@Service
public interface ZipRangeService {

	public List<Integer[]> buildZipCodeRange(List<Integer[]> zipCodeRanges) throws ZipRangeException;

}
