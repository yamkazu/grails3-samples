package grails.sample.events

import reactor.bus.Event
import reactor.spring.context.annotation.Consumer
import reactor.spring.context.annotation.Selector

@Consumer
class MyEventService {

    @Selector('myEvent')
    void hello(Event<String> event) {
        println "Event fired in Service: ${event.data}"
    }
}
