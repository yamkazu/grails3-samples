package grails.sample.functional.test.pages

import geb.Page

class BookCreatePage extends Page {

    static url = '/book/create'

    static at = { title == 'Create Book' }
}
