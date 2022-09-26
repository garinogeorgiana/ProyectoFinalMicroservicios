package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.dto.CatalogWS;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/catalog")
public class CatalogController {
	private static final Logger logger = LoggerFactory.getLogger(CatalogController.class);
	private final CatalogService catalogService;

	@Autowired
	public CatalogController(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

	@GetMapping("/{genre}")
	public CatalogWS getCatalogByGenre(@PathVariable String genre) {
		logger.info("Request to get movies and series by genre {}", genre);
		return catalogService.getCatalogByGenre(genre);
	}

}
