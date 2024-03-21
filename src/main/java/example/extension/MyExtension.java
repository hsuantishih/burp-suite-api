package example.extension;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;
import burp.api.montoya.http.message.requests.HttpRequest;
import burp.api.montoya.scanner.*;
import burp.api.montoya.scanner.audit.Audit;
import burp.api.montoya.scanner.audit.issues.AuditIssue;
import burp.api.montoya.sitemap.SiteMap;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
        MyScanCheck ScanCheck = new MyScanCheck(api);

        // 註冊 handler
        api.http().registerHttpHandler(HttpHandler);
        api.scope().registerScopeChangeHandler(ScopeHandler);
        api.scanner().registerAuditIssueHandler(AuditIssueHandler);
        api.scanner().registerScanCheck(ScanCheck);

        // 測試 爬蟲Crawl
        // Crawl MyCrawl;
        // MyCrawl = api.scanner().startCrawl(CrawlConfiguration.crawlConfiguration("http://192.168.56.105/"));


        // 測試 Audit
        Audit MyAudit;
        MyAudit = api.scanner().startAudit(AuditConfiguration.auditConfiguration(BuiltInAuditConfiguration.LEGACY_ACTIVE_AUDIT_CHECKS));

        // 新增 request
//        MyAudit.addRequest(HttpRequest.httpRequestFromUrl("http://192.168.56.105/"));

        api.logging().logToOutput(MyAudit.statusMessage());


        // 路徑宣告
        Path path = Paths.get("C:\\Users\\danie\\Desktop\\23.xml");

        // 當前目錄
//        String userDir = Paths.get("").toAbsolutePath().toString();

        // try 和 error
//        try {
////            AuditResult result = AuditResult.auditResult(MyAudit.issues());
//        } catch (Exception e) {
//            api.logging().logToOutput("There is an error.");
//        }

        // 目前都是 empty: 官方bug
//        MyAudit.issues();

        for (AuditIssue item : api.siteMap().issues()) {
            api.logging().logToOutput(item.name());
        }

        // 顯示存檔路徑及檔名
        api.logging().logToOutput(path.toString());

        // 生成檔案
        api.scanner().generateReport(api.siteMap().issues(), ReportFormat.XML, path);
    }
}
