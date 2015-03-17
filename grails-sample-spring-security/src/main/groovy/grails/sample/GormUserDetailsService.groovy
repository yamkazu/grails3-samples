package grails.sample

import grails.transaction.Transactional
import groovy.transform.CompileStatic
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
@CompileStatic
class GormUserDetailsService implements UserDetailsService {

    @Transactional(readOnly = true)
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        def person = Person.where { username == username }.get()
        if (!person) {
            throw new UsernameNotFoundException("Username not found: ${username}")
        }
        new User(person.username, person.password, person.roles.collect { Role role -> new SimpleGrantedAuthority(role.authority) })
    }
}
