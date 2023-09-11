package com.senescyt.app.emailRecover.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailValues {

    private String emailFrom;
    private String emailTo;
    private String subject;
    private String userName;
    private String token;

}
