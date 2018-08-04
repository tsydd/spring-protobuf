package by.tsyd.protobuf

import by.tsyd.protobuf.proto.HelloProtos
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class HelloController {
    @GetMapping("/hello/{name}")
    @ResponseBody
    fun hello(@PathVariable name: String): String = "Hello, $name!"

    @PostMapping("/p/hello")
    @ResponseBody
    fun protobufHello(@RequestBody msg: HelloProtos.Hello): HelloProtos.HelloResponse =
        HelloProtos.HelloResponse.newBuilder()
            .setMessage("Hello, ${msg.name}!")
            .build()
}