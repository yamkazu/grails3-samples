package grails.sample.inteceptors


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(HelloInterceptor)
class HelloInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test hello interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"hello")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
