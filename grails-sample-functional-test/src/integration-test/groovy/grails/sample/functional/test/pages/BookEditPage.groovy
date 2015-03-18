package grails.sample.functional.test.pages

import geb.Page

class BookEditPage extends Page {

    static url = '/book/edit'

    static at = { title == 'Edit Book' }
}
