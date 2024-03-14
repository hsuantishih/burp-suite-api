package example.extension;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;

public class MyExtension implements BurpExtension {
    public MyExtension() {

    }

    @Override
    public void initialize(MontoyaApi api) {
        api.extension().setName("My Extension");
        api.logging().logToOutput("Hello Extension");

        // 宣告及初始化物件
        MyHttpHandler HttpHandler = new MyHttpHandler(api);
        MyScopeHandler ScopeHandler = new MyScopeHandler(api);
        MyAuditIssueHandler AuditIssueHandler = new MyAuditIssueHandler(api);


        // 註冊 handler
        api.http().registerHttpHandler(HttpHandler);
        api.scope().registerScopeChangeHandler(ScopeHandler);
        api.scanner().registerAuditIssueHandler(AuditIssueHandler);

    }
}
