package grails.sample.actuator

import grails.test.mixin.integration.Integration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.boot.test.TestRestTemplate
import org.springframework.http.HttpStatus
import spock.lang.Specification

@Integration
class EndpointsSpec extends Specification {

    @Autowired
    SecurityProperties security

    @Value('${local.management.port}')
    int port

    def "access to /health"() {
        when:
            def entity = new TestRestTemplate('user', password).getForEntity("http://localhost:${port}/admin/health", String)

        then:
            entity.statusCode == HttpStatus.OK
        and:
            def body = entity.body
            body.contains('"status":"UP"')
            body.contains('"diskSpace":')
            body.contains('"hello":')
    }

    def "access to /info"() {
        when:
            def entity = new TestRestTemplate('user', password).getForEntity("http://localhost:${port}/admin/info", String)

        then:
            entity.statusCode == HttpStatus.OK
        and:
            def body = entity.body
            body.contains('"name":"grails-sample-actuator"')
            body.contains('"git":')
    }

    def "access to /metrics"() {
        when:
            def entity = new TestRestTemplate('user', password).getForEntity("http://localhost:${port}/admin/metrics", String)

        then:
            entity.statusCode == HttpStatus.OK
        and:
            def body = entity.body
            body.contains('"mem":')
    }

    private String getPassword() {
        return security.user.password
    }
}
