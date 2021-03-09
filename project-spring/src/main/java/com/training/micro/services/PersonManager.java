package com.training.micro.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.training.micro.rest.Person;

@Service
public class PersonManager {

    private final Map<String, Person> personMap   = new ConcurrentHashMap<>();
    private final List<String>        strList     = Collections.synchronizedList(new ArrayList<>());
    private final AtomicLong          counterSync = new AtomicLong();

    public void add(final Person person) {
        this.personMap.put(person.getName(),
                           person);
    }

}
