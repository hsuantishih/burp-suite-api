package example.extension;

import burp.api.montoya.MontoyaApi;
import burp.api.montoya.http.handler.*;
import burp.api.montoya.http.message.requests.HttpRequest;

public class MyHttpHandler implements HttpHandler {
    // 宣告私有變數
    private final MontoyaApi api;
    public MyHttpHandler(MontoyaApi apiArg) {

        this.api = apiArg;
    }

    @Override
    public RequestToBeSentAction handleHttpRequestToBeSent(HttpRequestToBeSent requestToBeSent) {
        HttpRequest request = requestToBeSent.withAddedHeader("New-Header", "New-Content");
        this.api.logging().logToOutput("Add New Header to the Http Request");

        return RequestToBeSentAction.continueWith(request);
    }

    @Override
    public ResponseReceivedAction handleHttpResponseReceived(HttpResponseReceived responseReceived) {
        return null;
    }
}
