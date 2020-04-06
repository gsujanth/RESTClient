package com.neverstop.RESTClient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEvent {

    private long event_id;
    private String event_type;
    private String userId;
    private long event_timestamp;
    private String event_context;
}
