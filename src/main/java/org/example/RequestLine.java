package org.example;

import java.util.Objects;

public class RequestLine {
    private final String method;
    private final String urlPath;
    private QueryStrings queryStrings;

    public RequestLine(String requestLine) {
        // GET /calculate?operand1=11&operator=*&operand2=2 HTTP/1.1
        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];
        String[] urlPathTokens = tokens[1].split("\\?");
        this.urlPath = urlPathTokens[0];

        if(urlPathTokens.length == 2){
            this.queryStrings = new QueryStrings(urlPathTokens[1]);
        }
    }

    public RequestLine(String method, String urlPath, QueryStrings queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryStrings = queryString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryStrings);
    }

    public boolean isGetRequest() {
        return "GET".equals(this.method);
    }

    public boolean matchPath(String s) {
        return urlPath.equals(s);
    }

    public QueryStrings getQueryStrings() {
        return this.queryStrings;
    }
}
