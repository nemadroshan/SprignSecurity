package com.nt.service;

import java.util.Calendar;
import org.springframework.stereotype.Service;

@Service("wishService")
public class WishMessageServiceImpl implements WishMessageService {

	@Override
	public String getWishMessage() {
		Calendar calendar = null;
		int hour = 0;
		// get System Date
		calendar = Calendar.getInstance();
		// get current hour of the day
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		// generate wish Message
		if (hour < 12)
			return "Good Morning::";
		else if (hour < 16)
			return "Good Aftertoon";
		else if (hour < 20)
			return "Good Evening";
		else
			return "Good night";
	}
}
