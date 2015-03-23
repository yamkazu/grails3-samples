package grails.sample

import org.springframework.security.authentication.AccountExpiredException
import org.springframework.security.authentication.CredentialsExpiredException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.LockedException
import org.springframework.security.web.WebAttributes

class LoginController implements SpringSecurityTrait {

    static defaultAction = 'auth'

    def auth() {
        if (loggedIn) {
            redirect uri: createLink(uri: '/')
            return
        }

        render view: 'auth'
    }

    def authfail() {
        String errorMessage = ''

        def exception = session[WebAttributes.AUTHENTICATION_EXCEPTION]
        if (exception) {
            if (exception instanceof AccountExpiredException) {
                errorMessage = message(code: 'springSecurity.errors.login.expired')
            } else if (exception instanceof CredentialsExpiredException) {
                errorMessage = message(code: 'springSecurity.errors.login.passwordExpired')
            } else if (exception instanceof DisabledException) {
                errorMessage = message(code: 'springSecurity.errors.login.disabled')
            } else if (exception instanceof LockedException) {
                errorMessage = message(code: 'springSecurity.errors.login.locked')
            } else {
                errorMessage = message(code: 'springSecurity.errors.login.fail')
            }
        }

        render view: 'auth', model: [errorMessage: errorMessage]
    }

    def denied() {
        render view: 'denied'
    }
}
