package com.training.micro.error.client;

import java.io.InputStream;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.micro.error.ErrorObject;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class ClientErrorDecoder implements ErrorDecoder {

    @Override
    public RestClientException decode(final String methodKeyParam,
                                      final Response responseParam) {
        if (responseParam.status() != 404) {
            try {
                InputStream asInputStreamLoc = responseParam.body()
                                                            .asInputStream();
                ObjectMapper mapperLoc = new ObjectMapper();
                ErrorObject errorLoc = mapperLoc.readValue(asInputStreamLoc,
                                                           ErrorObject.class);
                RestClientException clientExceptionLoc = new RestClientException();
                clientExceptionLoc.setErrorObject(errorLoc);
                return clientExceptionLoc;
            } catch (Exception e) {
                return new RestClientException("Error while decoding ErrorObject : " + e.getMessage());
            }
        }
        return new RestClientException("Path not found 404");
    }

}
