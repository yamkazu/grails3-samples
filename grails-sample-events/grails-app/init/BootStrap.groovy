import grails.events.Events
import reactor.bus.Event

class BootStrap implements Events {

    def init = { servletContext ->
        on('myEvent') { Event event ->
            println "Event fired in BootStrap: ${event.data}"
        }
    }

    def destroy = {
    }
}
