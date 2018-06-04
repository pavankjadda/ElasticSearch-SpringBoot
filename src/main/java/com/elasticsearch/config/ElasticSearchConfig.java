package com.elasticsearch.config;


import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import javax.annotation.Resource;
import java.net.InetAddress;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.elasticsearch.repo")
@ComponentScan(basePackages = {"com.elasticsearch.service"})
public class ElasticSearchConfig
{
    private static Logger logger = LoggerFactory.getLogger(ElasticSearchConfig.class);

    @Resource
    private Environment environment;

    @Bean
    public Client client() throws Exception
    {
        Settings settings = Settings.builder().put("cluster.name", environment.getProperty("elasticsearch.clustername")).build();
        return new PreBuiltTransportClient(settings).addTransportAddress(new TransportAddress(InetAddress.getByName(environment.getProperty("elasticsearch.host")),
                                                                            Integer.parseInt(environment.getProperty("elasticsearch.port"))));
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception
    {
        return new ElasticsearchTemplate(client());
    }
}
