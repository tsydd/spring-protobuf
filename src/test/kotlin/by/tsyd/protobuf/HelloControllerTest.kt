package by.tsyd.protobuf

import by.tsyd.protobuf.proto.HelloProtos
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject
import org.springframework.boot.test.web.client.postForObject
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner::class)
class HelloControllerTest {

    @LocalServerPort
    var port: Int = 0

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun testHello() {
        val response = restTemplate.getForObject<String>("http://localhost:$port/hello/world")
        assertEquals("Hello, world!", response)
    }

    @Test
    fun testProtobufHello() {
        val request = HelloProtos.Hello.newBuilder()
            .setName("world")
            .build()
        val response = restTemplate.postForObject<HelloProtos.HelloResponse>("http://localhost:$port/p/hello", request)
        assertEquals("Hello, world!", response?.message)
    }
}