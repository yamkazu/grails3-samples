package grails.sample.functional.test

import geb.spock.GebReportingSpec
import grails.sample.functional.test.pages.BookCreatePage
import grails.sample.functional.test.pages.BookEditPage
import grails.sample.functional.test.pages.BookIndexPage
import grails.sample.functional.test.pages.BookShowPage
import grails.test.mixin.integration.Integration

@Integration
class BookSpec extends GebReportingSpec {

    def cleanup() {
        Book.withTransaction {
            Book.executeUpdate('delete Book')
        }
    }

    def "list books"() {
        given:
            Book.withTransaction {
                new Book(title: 'Test Book').save()
            }

        when:
            to BookIndexPage

        then:
            books as Set == ['Test Book'] as Set
    }

    def "add a new book"() {
        when:
            to BookCreatePage
            $('form').title = 'New Book'
            $('input', type: 'submit', name: 'create').click()

        then:
            at BookShowPage
            $('.property-value').text() == 'New Book'

    }

    def "update a book"() {
        given:
            def book = Book.withTransaction {
                new Book(title: 'Test Book').save()
            }

        when:
            to BookEditPage, book.id
            $('form').title = 'Update Book'
            $('input', type: 'submit', class: 'save').click()

        then:
            at BookShowPage
            $('.property-value').text() == 'Update Book'
    }

    def "delete a book"() {
        given:
            def book = Book.withTransaction {
                new Book(title: 'Test Book').save()
            }

        when:
            to BookShowPage, book.id
            withConfirm {
                $('input', type: 'submit', class: 'delete').click()
            }

        then:
            at BookIndexPage
            !books
    }
}
