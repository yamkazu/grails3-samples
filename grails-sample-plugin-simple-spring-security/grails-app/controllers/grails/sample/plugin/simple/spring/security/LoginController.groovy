package grails.sample.plugin.simple.spring.security

class LoginController {

    def index() {
        render view: 'auth'
    }
}
