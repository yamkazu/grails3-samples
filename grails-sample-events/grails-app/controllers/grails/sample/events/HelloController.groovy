package grails.sample.events

class HelloController {

    def index() {
        notify 'myEvent', 'Hello World!'
        render 'Notified!'
    }
}
