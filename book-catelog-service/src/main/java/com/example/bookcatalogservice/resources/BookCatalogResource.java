package com.example.bookcatalogservice.resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.bookcatalogservice.models.Book;
import com.example.bookcatalogservice.models.CatalogItem;
import com.example.bookcatalogservice.models.Rating;
import com.example.bookcatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId) {
		UserRating userRating = restTemplate.getForObject("http://book-rating-service/rating/user/" + userId,
				UserRating.class);
		List<CatalogItem> catelog = new ArrayList<CatalogItem>();
		for (Rating rating : userRating.getRatings()) {
			Book book = restTemplate.getForObject("http://book-info-service/book/" + rating.getBookId(), Book.class);
			catelog.add(new CatalogItem(book.getName(), "Some description", rating.getRating()));
		}
		return catelog;
	}

}
