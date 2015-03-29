package grails.sample.undertow

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration

@Integration
class UndertowApplicationSpec extends GebSpec {

    def "show a home page"() {
        when: "The home page is visited"
            go '/'

        then: "The title is correct"
            $('title').text() == "Welcome to Grails"
    }
}
