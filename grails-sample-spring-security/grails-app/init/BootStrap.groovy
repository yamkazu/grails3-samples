import grails.sample.Person
import grails.sample.Role

class BootStrap {

    def init = { servletContext ->
        Role admin = new Role(authority: 'ROLE_ADMIN').save()
        new Person(username: 'admin', password: 'admin').addToRoles(admin).save()
    }

    def destroy = {
    }
}
