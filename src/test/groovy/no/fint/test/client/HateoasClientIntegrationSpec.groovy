package no.fint.test.client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Ignore
import spock.lang.Specification

@Ignore
@ActiveProfiles("test")
@ContextConfiguration
@SpringBootTest
class HateoasClientIntegrationSpec extends Specification {

    @Autowired
    private HateoasClient hateoasClient

    def "Get list of employments"() {
        when:
        def employments = hateoasClient.getEmploymentList()

        then:
        employments.size() > 0
    }

}
