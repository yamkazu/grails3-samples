import grails.sample.json.views.Person

class BootStrap {

    def init = { servletContext ->
        new Person(name: 'yamada', age: 20).save()
    }

    def destroy = {
    }
}
