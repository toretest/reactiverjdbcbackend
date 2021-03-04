package endpoints

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class api {

fun ping(){
       println("Hello")
    }

}
