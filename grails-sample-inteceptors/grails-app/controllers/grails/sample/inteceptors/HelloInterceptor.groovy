package grails.sample.inteceptors

class HelloInterceptor {

    boolean before() {
        println "This interceptor is applied only to HelloController"
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
