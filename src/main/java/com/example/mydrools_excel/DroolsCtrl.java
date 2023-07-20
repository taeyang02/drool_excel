package com.example.mydrools_excel;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DroolsCtrl {
    @Autowired
    private KieSession kieSession;

    @GetMapping("/getteck")
    public Customer request (@RequestBody Customer customer) {
        kieSession.insert(customer);
        kieSession.fireAllRules();
        return customer;
    }

}
