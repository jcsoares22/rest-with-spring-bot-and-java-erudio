package br.com.systec;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreentingController {
	
	private static final String templete = "hELLO, %s!";
	private  final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greenting")
	public Greenting greenting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greenting(counter.incrementAndGet(), String.format(templete, name));
	}
}
