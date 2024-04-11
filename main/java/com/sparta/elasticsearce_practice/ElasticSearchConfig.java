package com.sparta.elasticsearce_practice;

import co.elastic.clients.transport.TransportUtils;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import javax.net.ssl.SSLContext;

@Configuration
@EnableElasticsearchRepositories(basePackageClasses = com.sparta.elasticsearce_practice.BoardDocumentRepository.class)
public class ElasticSearchConfig extends ElasticsearchConfiguration {

    String fingerprint = "37beffa6659d7a2b206fe9ac6ef2b49215eccb452fd45c3cf26248e34b68dd27";

    SSLContext sslContext = TransportUtils.sslContextFromCaFingerprint(fingerprint);

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .usingSsl(sslContext) // SSL 사용 설정
                .withBasicAuth("elastic", "FJW3vh6q6QyUpvYC8j2B") // 기본 인증을 사용하는 경우
                .build();
    }
}
