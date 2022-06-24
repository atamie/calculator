package com.atamie.calculator;

import com.sun.net.httpserver.Headers;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service

public class RestClientClass {

    private RestTemplate restTemplate;
    private final String URL = "https://payments.baxipay.com.ng/api/baxipay/";
    private final String AIR_PATH = "services/airtime/providers";
    private final String API_KEY = "Api-key 5adea9-044a85-708016-7ae662-646d59";
    private HttpEntity httpEntity;

    //	exchange(URI url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType)

    public RestClientClass(RestTemplateBuilder builder){
        this.restTemplate = builder.build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization",API_KEY);
        headers.set("Accept","application/json");
        httpEntity = new HttpEntity(headers);
    }

    public ResponseEntity<CustomServiceProviders> getAllAirtimeServiceProviders(){
        ResponseEntity<ServiceProviders> responseEntity;
        CustomServiceProviders custom = new CustomServiceProviders();
        ServiceProviders service;
        CustomProvider[] providers;
        Provider[] p;

        try{
            URI uri = new URI(URL+ AIR_PATH);
            responseEntity = restTemplate.exchange(uri, HttpMethod.GET,httpEntity,ServiceProviders.class);
            service = responseEntity.getBody();
            //System.out.println(service.getMessage());

            custom.setCode(service.getCode());
            custom.setMessage(service.getMessage());
            //System.out.println( custom.getMessage());
            custom.setStatus(service.getStatus());


            int i = service.getData().getProviders().length;
            providers = new CustomProvider[i];
            for(int j=0;j<i;++j) {
                providers[j] = new CustomProvider();
            }

            int h =0;
            p = service.getData().getProviders();

            for(h = 0; h< i; ++h) {
                providers[h].setAirtime_service(p[h].getService_type());
                providers[h].setBiller(p[h].getBiller_id());
                providers[h].setName(p[h].getName());
                providers[h].setPlan(p[h].getPlan());
                providers[h].setProduct(p[h].getProduct_id());
                providers[h].setShortname(p[h].getShortname());
            }

            CustomData data = new CustomData();
            data.setProviders(providers);
            custom.setData(data);
            return ResponseEntity.ok(custom);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            CustomServiceProviders serviceProviders = new CustomServiceProviders();
            serviceProviders.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(serviceProviders);
        }

    }
}
