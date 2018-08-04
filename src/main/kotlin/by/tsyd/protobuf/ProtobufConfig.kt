package by.tsyd.protobuf

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter

@Configuration
class ProtobufConfig {
    @Bean
    fun protobufConverter() = ProtobufHttpMessageConverter()
}