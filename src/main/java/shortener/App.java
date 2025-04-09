package shortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.AbstractView;
import org.springframework.http.HttpStatus;

@SpringBootApplication
@RestController
public class App implements CommandLineRunner {	
	@Autowired
	private UrlRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
    public void run(String... args) throws Exception {}
	
	@GetMapping("/s/{getKey}")
	public AbstractView externalRedirect(@PathVariable String getKey) {
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(repository.findByShortKey(getKey).site);
		return redirectView;
	}
	
	@RequestMapping("/")
	public AbstractView viewHome() {
		InternalResourceView view = new InternalResourceView("client.html");
		return view;
	}	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody Url url) {
		repository.save(url);
	}
}
