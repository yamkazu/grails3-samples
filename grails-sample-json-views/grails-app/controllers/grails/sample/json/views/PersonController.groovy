package grails.sample.json.views

import grails.rest.RestfulController

class PersonController extends RestfulController {

    static responseFormats = ['json']

    PersonController() {
        super(Person)
    }
}
