package ru.test.task.service;


import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.test.task.model.AnswersDTO;
import ru.test.task.model.ResponseDTO;
import ru.test.task.model.ResponsesDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestTaskServiceImpl implements TestTaskService {

    org.apache.http.client.HttpClient httpClient = HttpClientBuilder.create().build();
    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

    private RestTemplate restTemplate = new RestTemplate(requestFactory);


    @Override
    public ResponsesDTO getAnswers(String intitle) {

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString("http://api.stackexchange.com/2.2/search")
                .queryParam("order", "desc")
                .queryParam("sort", "activity")
                .queryParam("intitle", intitle)
                .queryParam("site", "stackoverflow");

        AnswersDTO items = null;
        List<ResponseDTO> responses = null;
        try {
            items = restTemplate.getForObject(builder.toUriString(), AnswersDTO.class);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }

        if (items != null) {
            responses = items.getItems().stream().map(ResponseDTO::new).collect(Collectors.toList());
        }

        return new ResponsesDTO(responses);

    }
}
