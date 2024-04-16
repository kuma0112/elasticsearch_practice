package com.sparta.elasticsearch_practice;

import co.elastic.clients.transport.TransportUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import javax.net.ssl.SSLContext;

@Configuration
@EnableElasticsearchRepositories(basePackageClasses = com.sparta.elasticsearch_practice.BoardDocumentRepository.class)
public class ElasticSearchConfig extends ElasticsearchConfiguration {

    String fingerprint = "6b120674b921c47eaf8870c473a941101b3881c4f24666fe2e6f6bef628bc2a8";

    SSLContext sslContext = TransportUtils.sslContextFromCaFingerprint(fingerprint);

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .usingSsl(sslContext) // SSL 사용 설정
                .withBasicAuth("elastic", "O01KH-JfQoexKsL9gX6u") // 기본 인증을 사용하는 경우
                .build();
    }
}
