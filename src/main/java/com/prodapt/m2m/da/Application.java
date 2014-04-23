package com.prodapt.m2m.da;

import static reactor.event.selector.Selectors.$;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import reactor.core.Environment;
import reactor.core.Reactor;
import reactor.core.spec.Reactors;

import com.prodapt.m2m.da.events.Publisher;
import com.prodapt.m2m.da.events.Receiver;

@Configuration
@ComponentScan({
    "package com.prodapt.m2m.da",
    "package com.prodapt.m2m.da.core"
})
@EnableAutoConfiguration
public class Application implements CommandLineRunner{

	@Bean
    Environment env() {
    	return new Environment();
    }

    @Bean
    public RestTemplate rest() {
    	return new RestTemplate();
    }

    public static void main(String[] args) throws InterruptedException {
    	SpringApplication.run(Application.class, args);
    }

/////// EVENT PROCESSOR USING REACTOR PATTERN /////

 
    @Bean
    Reactor createReactor(Environment env) {
        return Reactors.reactor()
            .env(env)
            .dispatcher(Environment.THREAD_POOL)
            .get();
    }

    @Autowired
    private Reactor reactor;

    @Autowired
    private Receiver receiver;

    @Autowired
    private Publisher publisher;

    @Override
    public void run(String... args) throws Exception {
        reactor.on($("commands"), receiver);
    }
}