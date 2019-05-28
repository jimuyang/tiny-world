package me.ele.sample.api;

/**
 * @author: Yang Fan
 * @date: 2019-05-28
 * @desc:
 */
public interface EchoService {

    String echo(String message) throws EchoBizException;
}

