package grails.sample.actuator

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.context.annotation.Bean

class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application)
    }

//    @Bean
//    HealthIndicator helloHealthIndicator() {
//        new HealthIndicator() {
//            @Override
//            Health health() {
//                Health.up().withDetail('hello', 'world').build()
//            }
//        }
//    }
}
