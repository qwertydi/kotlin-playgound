package com.dmsc.kotlinapp.configuration

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

@Component
class LoggingFilter : WebFilter {
    private val log = LoggerFactory.getLogger(LoggingFilter::class.java)

    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val request = exchange.request
        val response = exchange.response

        log.info("Incoming request: ${request.method} ${request.uri}")

        return chain.filter(exchange)
            .doOnSuccess {
                log.info("Outgoing response status: ${response.statusCode}")
            }
            .doOnError { ex ->
                log.error("Error during request processing", ex)
            }
            .onErrorResume { _ ->
                if (!exchange.response.isCommitted) {
                    exchange.response.statusCode = HttpStatus.INTERNAL_SERVER_ERROR
                }
                exchange.response.setComplete()
            }
    }
}