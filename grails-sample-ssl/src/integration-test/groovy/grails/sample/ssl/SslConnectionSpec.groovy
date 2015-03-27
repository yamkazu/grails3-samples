package grails.sample.ssl

import grails.test.mixin.integration.Integration
import org.apache.http.conn.ssl.SSLConnectionSocketFactory
import org.apache.http.conn.ssl.SSLContextBuilder
import org.apache.http.conn.ssl.TrustSelfSignedStrategy
import org.apache.http.impl.client.HttpClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.TestRestTemplate
import org.springframework.http.HttpStatus
import spock.lang.Specification

@Integration
class SslConnectionSpec extends Specification {

    @Value('${local.server.port}')
    int port

    def "Test SSL connection"() {
        given:
            def socketFactory = new SSLConnectionSocketFactory(new SSLContextBuilder().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build())
            def httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory).build()

            def testRestTemplate = new TestRestTemplate()
            testRestTemplate.getRequestFactory().httpClient = httpClient

        when:
            def entity = testRestTemplate.getForEntity("https://localhost:${port}/hello", String)

        then:
            entity.statusCode == HttpStatus.OK
            entity.body == 'Hello World!'
    }
}
