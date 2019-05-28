package me.ele.sample.impl;

import me.ele.sample.api.EchoBizException;
import me.ele.sample.api.EchoService;

/**
 * @author: Yang Fan
 * @date: 2019-05-28
 * @desc:
 */
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String message) throws EchoBizException {
        return "echo:" + message;
    }
}
