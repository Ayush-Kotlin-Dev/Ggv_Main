package com.ayush.ggv

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.html.*
import kotlinx.html.*

fun Application.configureRouting() {
    routing {
        route(path = "/") {
            get {
                call.respondHtml {
                    head {
                        title { +"Counselling System Backend" }
                        style {
                            +"""
                            body {
                                font-family: 'Helvetica Neue', sans-serif;
                                background-color: #f4f4f9;
                                color: #333;
                                padding: 40px;
                                text-align: center;
                            }
                            h1 {
                                color: #4CAF50;
                                font-size: 3em;
                            }
                            h2 {
                                color: #555;
                                margin-top: 20px;
                                font-size: 1.5em;
                            }
                            p {
                                color: #777;
                                font-size: 1.2em;
                                line-height: 1.6;
                                margin-top: 20px;
                            }
                            """.trimIndent()
                        }
                    }
                    body {
                        h1 { +"Counselling System Backend Server" }
                        h2 { +"Guru Ghasidas Vishwavidyalaya, Bilaspur" }
                        p {
                            +"This backend serves as the core service for the counseling system of the university."
                        }
                        p {
                            +"We provide a seamless integration between students and counselors, aiding the academic and personal growth of students."
                        }
                        p {
                            +"Our system ensures efficient allocation and scheduling for individual counseling sessions."
                        }
                    }
                }
            }
        }
    }
}
