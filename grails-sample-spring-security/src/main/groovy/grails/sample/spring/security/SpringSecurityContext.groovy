package grails.sample.spring.security

import grails.compiler.GrailsCompileStatic
import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User

@GrailsCompileStatic
trait SpringSecurityContext {

    Authentication getAuthentication() {
        SecurityContextHolder.context.authentication
    }

    Collection<? extends GrantedAuthority> getAuthorities() {
        authentication.authorities
    }

    Object getCredentials() {
        authentication.credentials
    }

    Object getDetails() {
        authentication.details
    }

    Object getPrincipal() {
        authentication.principal
    }

    boolean isAuthenticated() {
        authentication.authenticated
    }

    boolean isLoggedIn() {
        !(authentication instanceof AnonymousAuthenticationToken) && authenticated
    }

    Person getCurrentUser() {
        if (!loggedIn) {
            return null
        }
        Person.findByUsername(((User) principal).username)
    }
}
