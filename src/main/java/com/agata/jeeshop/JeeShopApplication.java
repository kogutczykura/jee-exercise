package com.agata.jeeshop;

import com.github.jknack.handlebars.Options;
import com.google.common.base.Objects;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import pl.allegro.tech.boot.autoconfigure.handlebars.HandlebarsHelper;

import java.io.IOException;

@Configuration
@SpringBootApplication
public class JeeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JeeShopApplication.class, args);
	}

	@HandlebarsHelper
	public static class IfEqualHelper {
		public CharSequence ifEqual(final Object obj1, final Options options) throws IOException {
			Object obj2 = options.param(0);
			return Objects.equal(obj1, obj2) ? options.fn() : options.inverse();
		}
	}
}
