package grails.sample.actuator

import groovy.transform.CompileStatic
import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.stereotype.Component

@Component
@CompileStatic
class HelloHealthIndicator implements HealthIndicator {

    @Override
    Health health() {
        Health.up().withDetail('hello', 'world').build()
    }
}
