package grails.sample.actuator

import grails.test.mixin.integration.Integration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.boot.test.TestRestTemplate
import org.springframework.http.HttpStatus
import spock.lang.Specification

@Integration
class JolokiaSpec extends Specification {

    @Autowired
    SecurityProperties security

    @Value('${local.management.port}')
    int port

    def "access to Jolokia"() {
        when:
            def entity = new TestRestTemplate('user', password).getForEntity("http://localhost:${port}/admin/jolokia/read/java.lang:type=Memory", String)

        then:
            entity.statusCode == HttpStatus.OK
        and:
            def body = entity.body
            body.contains('"HeapMemoryUsage":')
    }

    private String getPassword() {
        return security.user.password
    }
}
