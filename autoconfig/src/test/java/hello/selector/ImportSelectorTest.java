package hello.selector;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class ImportSelectorTest {

	@Test
	void staticConfig() {
		AnnotationConfigApplicationContext appContext
			= new AnnotationConfigApplicationContext(staticConfig.class);
		HelloBean bean = appContext.getBean(HelloBean.class);
		assertThat(bean).isNotNull();
	}

	@Test
	void selectorConfig() {
		AnnotationConfigApplicationContext appContext
			= new AnnotationConfigApplicationContext(selectorConfig.class);
		HelloBean bean = appContext.getBean(HelloBean.class);
		assertThat(bean).isNotNull();
	}

	@Configuration
	@Import(HelloConfig.class)
	public static class staticConfig {
	}

	@Configuration
	@Import(HelloImportSelector.class)
	public static class selectorConfig {
	}


}
