package com.edoctor.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "MongoDB JPA操作API")
@RestController
@RequestMapping("/api/v1/mongo/operation")
public class MongoApi {

}
