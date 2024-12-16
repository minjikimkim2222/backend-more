package test.lion.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

/*
    spring bean에 ElasticSearch 클라이언트 등록
 */

//@Configuration
public class ElasticSearchConfig {
    @Value("${spring.data.elasticsearch.url}")
    String url;

    @Bean
    public RestClient elasticsearchClient(){
        // ElasticSearch 7.15 이상에서는 Java API Client 사용
        return RestClient.builder(HttpHost.create(url)).build();
    }
}
