package com.senescyt.app.emailRecover.dto.service;

import com.senescyt.app.emailRecover.dto.EmailValues;

public interface EmailService {

    boolean sendEmail(EmailValues values);
}
