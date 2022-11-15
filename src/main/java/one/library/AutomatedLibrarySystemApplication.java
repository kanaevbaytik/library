package one.library;

import one.library.backend.entity.Author;
import one.library.backend.entity.Category;
import one.library.backend.entity.Descriptor;
import one.library.backend.service.AuthorService;
import one.library.backend.service.CategoryService;
import one.library.backend.service.DescriptorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AutomatedLibrarySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomatedLibrarySystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(AuthorService authorService, CategoryService categoryService, DescriptorService descriptorService) {
		return (args) -> {
			authorService.save(new Author("Author 1"));
			authorService.save(new Author("Author 2"));
			authorService.save(new Author("Author 3"));
			authorService.save(new Author("Author 4"));
			authorService.save(new Author("Author 5"));

			categoryService.save(new Category("Category 1"));
			categoryService.save(new Category("Category 2"));
			categoryService.save(new Category("Category 3"));
			categoryService.save(new Category("Category 4"));
			categoryService.save(new Category("Category 5"));

			descriptorService.save(new Descriptor("Descriptor 1"));
			descriptorService.save(new Descriptor("Descriptor 2"));
			descriptorService.save(new Descriptor("Descriptor 3"));
			descriptorService.save(new Descriptor("Descriptor 4"));
			descriptorService.save(new Descriptor("Descriptor 5"));
		};
	}

}
