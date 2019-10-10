package com.example.api.controller;

import com.example.api.dto.ApiResponse;
import com.example.api.model.Message;
import com.example.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

import static com.example.api.util.Constant.*;

/**
 * The controller for REST request
 */
@RestController
@RequestMapping(API_PATH)
public class ApiController {
    // The ApiService is used for further processing the message.
    private final ApiService apiService;

    /**
     * The constructor for autowired by dependency injection facilities.
     * @param apiService The api service.
     */
    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    /**
     * Method for handle GET request for get all message list.
     * @return list of all message as JSON serialized.
     */
    @GetMapping(MESSAGE_PATH)
    public ResponseEntity<List<Message>> getAllMessage(){
        return ResponseEntity.ok(apiService.getAllMessage());
    }

    /**
     * Method for handle POST request for saving the message.
     * @param message The message received from client.
     * @return ApiResponse as JSON serialized.
     */
    @PostMapping(MESSAGE_PATH)
    public ResponseEntity<ApiResponse> saveMessage(@RequestBody Message message){
        ApiResponse apiResponse = new ApiResponse(apiService.saveMessage(message), SUCCES_MESSAGE_COLLECTED);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().build().toUri()).body(apiResponse);
    }
}
