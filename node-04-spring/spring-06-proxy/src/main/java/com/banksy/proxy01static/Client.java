package com.banksy.proxy01static;

import com.banksy.proxy01static.service.Impl.Host;
import org.junit.Test;
/**
 * 客户角色：【使用代理角色来进行一些操作】去找代理！
 * @Author banksy
 **/
public class Client {
    @Test
    public static void main(String[] args) {
        //房东要租房
        Host host = new Host();
        //中介帮助房东
        Proxy proxy = new Proxy(host);
        //你去找中介！
        proxy.rent();
    }
}
