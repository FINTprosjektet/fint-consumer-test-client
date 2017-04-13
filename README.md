# FINT consumer test client

Test client that reads the response from the consumer API.  

To run the integration test, create the `application-test.yml` file and include the `bearer-token` property. 
This will connect to the service running on api.felleskomponent.no.  

## Examples

**RestTemplate**
```java
ResponseEntity<Resources<Arbeidsforhold>> response = restTemplate.exchange(URL_ARBEIDSFORHOLD, HttpMethod.GET, new HttpEntity<>(headers), new ParameterizedTypeReference<Resources<Arbeidsforhold>>() {});
```

**ObjectMapper**
```java
Resources<Arbeidsforhold> resources = objectMapper.readValue(content, new TypeReference<Resources<Arbeidsforhold>>() {});
```

## References
- [Consuming Spring-hateoas Rest service](https://www.javacodegeeks.com/2014/01/consuming-spring-hateoas-rest-service-using-spring-resttemplate-and-super-type-tokens.html)