package grails.sample.plugin.spring.security

import grails.compiler.GrailsCompileStatic
import grails.transaction.Transactional
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
@GrailsCompileStatic
class GormUserDetailsService implements UserDetailsService {

    @Transactional(readOnly = true)
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        def person = Person.findByUsername(username)
        if (!person) {
            throw new UsernameNotFoundException("Username not found: ${username}")
        }
        new User(person.username, person.password, person.roles.collect { Role role -> new SimpleGrantedAuthority(role.authority) })
    }
}
