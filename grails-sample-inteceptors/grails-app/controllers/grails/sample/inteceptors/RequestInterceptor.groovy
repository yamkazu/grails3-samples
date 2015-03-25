package grails.sample.inteceptors

import groovy.transform.CompileStatic

@CompileStatic
class RequestInterceptor {

    RequestInterceptor() {
        matchAll()

        // matchAll()
        //    .excludes(controller: 'login') // using excludes

        // match(controller:"book", action:"show") // using strings
        // match(controller: ~/(author|publisher)/) // using regex
    }

    boolean before() {
        println ">>> before: [${request.method}] ${request.forwardURI}"
        println "  session:"
        session.attributeNames.each { String name ->
            println "    - ${name}: ${session.getAttribute(name)}"
        }
        println "  params:"
        params.keySet().each { Object key ->
            println "     - ${key}: ${params.get(key)}"
        }

        true
    }

    boolean after() {
        println "<<< after: [${request.method}] ${request.forwardURI}"
        println "  model:"
        model?.keySet()?.each { String key ->
            println "    - ${key}: ${model.get(key)}"
        }
        println "  view: ${view}"

        true
    }

    void afterView() {
        println "<<< afterView: [${request.method}] ${request.forwardURI}"
        println "  throwable: ${throwable?.getClass()}"
    }
}
