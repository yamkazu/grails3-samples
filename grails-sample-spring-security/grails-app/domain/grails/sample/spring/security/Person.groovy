package grails.sample.spring.security

import org.springframework.security.crypto.password.PasswordEncoder

class Person {

    String username
    String password

    PasswordEncoder passwordEncoder

    static constraints = {
        username blank: false, unique: true
        password blank: false
    }

    static mapping = {
        password column: '`password`'
    }

    static hasMany = [roles: Role]

    static transients = ['passwordEncoder']

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = passwordEncoder.encode(password)
    }
}
