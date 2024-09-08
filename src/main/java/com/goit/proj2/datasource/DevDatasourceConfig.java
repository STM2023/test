package com.goit.proj2.datasource;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component

public class DevDatasourceConfig implements DatasourceConfig {
    @Override
    public void setup() {
        System.out.println("Setting up datasource for DEV environment. ");
    }
}