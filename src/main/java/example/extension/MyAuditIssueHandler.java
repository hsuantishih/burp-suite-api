package example.extension;

import burp.api.montoya.MontoyaApi;
import burp.api.montoya.scanner.audit.AuditIssueHandler;
import burp.api.montoya.scanner.audit.issues.AuditIssue;

public class MyAuditIssueHandler implements AuditIssueHandler {
    private final MontoyaApi api;

    public MyAuditIssueHandler(MontoyaApi apiArg) {
        this.api = apiArg;
    }


    @Override
    public void handleNewAuditIssue(AuditIssue auditIssue) {
        this.api.logging().logToOutput("There are some issue from audit handler");
    }
}
