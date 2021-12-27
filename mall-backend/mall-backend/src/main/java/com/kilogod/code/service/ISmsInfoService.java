package com.kilogod.code.service;

import com.kilogod.code.common.res.ResultData;
import com.kilogod.code.domain.dto.SmsInfoDTO;
import com.kilogod.code.domain.dto.SmsNameInfoDTO;

import javax.xml.bind.ValidationException;

/**
 * @author anding
 * @Description:
 */
public interface ISmsInfoService {
    ResultData sendSms(SmsInfoDTO dto) throws ValidationException;
    boolean validateSms(SmsInfoDTO dto) throws ValidationException;
    ResultData sendSmsName(SmsNameInfoDTO dto) throws ValidationException;
}