package grails.sample

import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import org.junit.Rule
import org.springframework.boot.test.OutputCapture
import spock.lang.Specification

@Integration
@Rollback
class BookSpec extends Specification {

    @Rule
    OutputCapture outputCapture

    def "executes a sample query"() {
        when:
            Book.where { title == 'test title' }.list()

        then:
            outputCapture.toString() =~ /(?s)select.+from.+book.+where/
    }
}
