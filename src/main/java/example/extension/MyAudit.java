package example.extension;

import burp.api.montoya.MontoyaApi;
import burp.api.montoya.core.Range;
import burp.api.montoya.http.message.HttpRequestResponse;
import burp.api.montoya.http.message.requests.HttpRequest;
import burp.api.montoya.scanner.audit.Audit;
import burp.api.montoya.scanner.audit.issues.AuditIssue;

import java.util.List;

public class MyAudit implements Audit {
    private final MontoyaApi api;

    public MyAudit(MontoyaApi apiArg) {
        this.api = apiArg;
    }


    @Override
    public int insertionPointCount() {
        return 0;
    }

    @Override
    public List<AuditIssue> issues() {
        this.api.logging().logToOutput("This is Audit issue");
        return null;
    }

    @Override
    public void addRequest(HttpRequest request) {

    }

    @Override
    public void addRequest(HttpRequest request, List<Range> insertionPointOffsets) {

    }

    @Override
    public void addRequestResponse(HttpRequestResponse requestResponse) {

    }

    @Override
    public int requestCount() {
        return 0;
    }

    @Override
    public int errorCount() {
        return 0;
    }

    @Override
    public void delete() {

    }

    @Override
    public String statusMessage() {
        return null;
    }
}
