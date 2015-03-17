package grails.sample

import grails.util.Holders
import org.springframework.security.crypto.password.PasswordEncoder

class Person {

    String username
    String password

    static constraints = {
        username blank: false, unique: true
        password blank: false
    }

    static mapping = {
        password column: '`password`'
    }

    static hasMany = [roles: Role]

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = Holders.grailsApplication.mainContext.getBean(PasswordEncoder).encode(password)
    }
}
