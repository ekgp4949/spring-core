package com.dhk.core.lifecycle;

public class NetworkClient
{
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect:  " + url);
    }

    public void call(String message) {
        System.out.println("call: "+ url + ", message: " + message);
    }

    public void disconnect() {
        System.out.println("close: " + url);
    }

    // 의존관계 주입이 끝나면 호출
    public void init() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메세지");
    }

    // 스프링 종료 전 호출
    public void close() throws Exception {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}