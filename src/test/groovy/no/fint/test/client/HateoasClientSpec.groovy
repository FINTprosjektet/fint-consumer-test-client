package no.fint.test.client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest
class HateoasClientSpec extends Specification {

    @Autowired
    private HateoasClient hateoasClient

    def "Get list of employments from local json file"() {
        when:
        def employmentList = hateoasClient.getEmploymentListJsonFile()

        then:
        employmentList.size() == 2
        employmentList[0].systemId.identifikatorverdi == 'hfk.no:123:2'
        employmentList[1].systemId.identifikatorverdi == 'hfk.no:234:1'
    }
}
