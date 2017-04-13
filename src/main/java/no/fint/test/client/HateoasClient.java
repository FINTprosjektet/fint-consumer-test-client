package no.fint.test.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import no.fint.model.administrasjon.personal.Arbeidsforhold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class HateoasClient {

    private static final String URL_ARBEIDSFORHOLD = "https://api.felleskomponent.no/administrasjon/personal/arbeidsforhold";

    @Value("${bearer-token:}")
    private String bearerToken;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public List<Arbeidsforhold> getEmploymentList() {
        HttpHeaders headers = new HttpHeaders();
        headers.put(HttpHeaders.AUTHORIZATION, Lists.newArrayList("Bearer " + bearerToken));
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<Resources<Arbeidsforhold>> response = restTemplate.exchange(URL_ARBEIDSFORHOLD, HttpMethod.GET, new HttpEntity<>(headers), new ParameterizedTypeReference<Resources<Arbeidsforhold>>() {
        });

        return new ArrayList<>(response.getBody().getContent());
    }

    public List<Arbeidsforhold> getEmploymentListJsonFile() throws URISyntaxException, IOException {
        URL resource = HateoasClient.class.getResource("/arbeidsforhold.json");
        String content = new String(Files.readAllBytes(Paths.get(resource.toURI())));
        Resources<Arbeidsforhold> resources = objectMapper.readValue(content, new TypeReference<Resources<Arbeidsforhold>>() {
        });
        return new ArrayList<>(resources.getContent());
    }

}
