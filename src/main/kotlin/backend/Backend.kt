package backend

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>){

    val jsonResponse = """{
            "value": 1,
            "percentage": "Joao Alves",
            "cashback": "joao.alves"
        }"""

    embeddedServer(Netty, 8080){
        routing {
            get("/") {
                call.respondText(calc(99.98,2.99, 20.0), ContentType.Application.Json, status = HttpStatusCode(200, ""))
            }
        }
    }.start(true)




}

fun calc (value: Double, pp: Double, cb: Double): String {

    val p = value *(pp/100)
    val win = value*(cb/100)

    return  """{
            "value": $value,
            "percentage": $p,
            "cashback": $win,
            "amout_to_pay": ${value+p-win}
            ""
        }"""
}