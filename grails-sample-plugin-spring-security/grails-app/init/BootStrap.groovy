import grails.sample.plugin.spring.security.Person
import grails.sample.plugin.spring.security.Role

class BootStrap {

    def init = { servletContext ->
        Role admin = new Role(authority: 'ROLE_ADMIN').save()
        Role user = new Role(authority: 'ROLE_USER').save()
        new Person(username: 'admin', password: 'admin').addToRoles(admin).save()
        new Person(username: 'user', password: 'user').addToRoles(user).save()
    }

    def destroy = {
    }
}
