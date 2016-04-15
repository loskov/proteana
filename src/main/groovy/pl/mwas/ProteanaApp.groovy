package pl.mwas

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ProteanaApp {
    private static final Logger log = LoggerFactory.getLogger(ProteanaApp.class)

    static void main(String[] args) throws Exception {
        SpringApplication.run(ProteanaApp.class, args)
        log.info("Proteana started")
    }
}