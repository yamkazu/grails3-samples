package grails.sample.functional.test.pages

import geb.Page

class BookIndexPage extends Page {

    static url = '/book'

    static at = { title == 'Book List' }

    static content = {
        books { $('#list-book tbody a').collect { it.text() } }
    }
}
