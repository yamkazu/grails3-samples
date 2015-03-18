package grails.sample.functional.test.pages

import geb.Page

class BookShowPage extends Page {

    static url = '/book/show'

    static at = { title == 'Show Book' }
}
