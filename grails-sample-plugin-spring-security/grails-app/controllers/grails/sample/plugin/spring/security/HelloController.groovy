package grails.sample.plugin.spring.security

import org.springframework.security.access.annotation.Secured
import org.springframework.security.access.prepost.PreAuthorize

class HelloController {

    @PreAuthorize('fullyAuthenticated')
    def index() {
        render 'index page'
    }

    @Secured('ROLE_ADMIN')
    def admin() {
        render 'admin page'
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    def user() {
        render 'user page'
    }
}
