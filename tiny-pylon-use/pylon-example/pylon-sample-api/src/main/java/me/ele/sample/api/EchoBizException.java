package me.ele.sample.api;

import me.ele.contract.exception.ServiceException;

/**
 * @author: Yang Fan
 * @date: 2019-05-28
 * @desc:
 */
public class EchoBizException extends ServiceException {


    public EchoBizException(String message) {
        super(message);
    }

    public EchoBizException(String code, String message) {
        super(code, message);
    }


}
