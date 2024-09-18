package com.khadri.jdbc.prepare.data.supermarket.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.khadri.jdbc.prepare.data.supermarket.dao.model.SuperMarket;
import com.khadri.jdbc.prepare.data.supermarket.daos.SuperMarketInsertDao;


class SuperMarketDataProcessorTest {
	@Mock
	SuperMarketDataProcessor superMarketDataProcessor;
	
	@Mock
	Scanner scanner;
	
	@InjectMocks
	SuperMarketInsertDao superMarketInsertDao;
	
	@Mock
	SuperMarket superMarket;

	@Test
	void testSuperMarketDataProcessor() {
		fail("Not yet implemented");
	}

	@Test
	void testProcess() {
		Mockito.when(scanner.next()).thenReturn("HANI");
		//int expProdName = superMarketDataProcessor.process(1);
		 
		//assertEquals(expProdName, 1);
	}

}
