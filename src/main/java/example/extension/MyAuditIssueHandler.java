package example.extension;

import burp.api.montoya.MontoyaApi;
import burp.api.montoya.scanner.ReportFormat;
import burp.api.montoya.scanner.audit.AuditIssueHandler;
import burp.api.montoya.scanner.audit.issues.AuditIssue;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MyAuditIssueHandler implements AuditIssueHandler {
    private final MontoyaApi api;
    private final Path path;

    public MyAuditIssueHandler(MontoyaApi apiArg) {
        this.api = apiArg;
        this.path = Paths.get("D:\\BurpSuiteJava");
    }

    @Override
    public void handleNewAuditIssue(AuditIssue auditIssue) {
        this.api.logging().logToOutput("There are some issue from audit handler");
        this.api.logging().logToOutput("The followings are the detail");

        this.api.logging().logToOutput(auditIssue.name());
        this.api.logging().logToOutput(auditIssue.detail());
        this.api.logging().logToOutput(auditIssue.baseUrl());
    }
}
