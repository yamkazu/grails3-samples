package grails.sample.ms.app.insights

import com.microsoft.applicationinsights.web.internal.WebRequestTrackingFilter
import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import org.springframework.context.annotation.Bean

import javax.servlet.Filter

class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application)
    }

    @Bean
    Filter webRequestTrackingFilter() {
        new WebRequestTrackingFilter()
    }
}
