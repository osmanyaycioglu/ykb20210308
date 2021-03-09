package a.b.c;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public TestBean testBean() {
        return new TestBean();
    }

    @Bean
    public XyzBean xyzBean() {
        return new XyzBean();
    }

}
