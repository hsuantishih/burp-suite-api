package example.extension;

import burp.api.montoya.MontoyaApi;
import burp.api.montoya.scope.ScopeChange;
import burp.api.montoya.scope.ScopeChangeHandler;

public class MyScopeHandler implements ScopeChangeHandler {
    // 宣告私有變數
    private final MontoyaApi api;

    public MyScopeHandler(MontoyaApi apiArg) {
        // 由 Extension 傳遞 api 參數
        this.api = apiArg;
    }

    @Override
    public void scopeChanged(ScopeChange scopeChange) {
        this.api.logging().logToOutput("Scope has been change");
    }
}
